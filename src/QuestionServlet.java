import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.*;
import java.util.Set;

public class QuestionServlet extends HttpServlet {

    private static final String TEMPLATE =
            "<html>" + "<head><title>HOMEWORK-02</title></head>" + "<body><h1>%s</h1></body></html>";

    private HashMap<String, Answer> hashMap = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");

        HttpSession session = request.getSession(true);
        if (login != null ) {
            session.setAttribute("user_login", login);
            response.sendRedirect("index.jsp");
            return;
        }

        Set<Entry<String, String[]>> set = request.getParameterMap().entrySet();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(TEMPLATE, "Your answers are:"));

        String key;
        String value;
        for (Entry entry : set)
        {
            key = (String) entry.getKey();
            if (!key.contains("question")) {
                continue;
            }
            value = ((String[])entry.getValue())[0];
            stringBuilder.append(key + " - " + value);
            stringBuilder.append("<br>");

            if (hashMap.containsKey(key)) {
                Answer answer = hashMap.get(key);
                answer.increment(value);
                hashMap.put(key, answer);
            }
            else {
                hashMap.put(key, new Answer(value));
            }
        }

        session.setAttribute("output", stringBuilder.toString());
        response.sendRedirect("index.jsp");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null)) {
            session.removeAttribute("user_login");
            session.removeAttribute("output");
            session.removeAttribute("statistic");
            hashMap.clear(); // ?? Is that needed to clear stats after logout? Not clear.
        }
        else if(a.equals("statistic"))
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : hashMap.entrySet())
            {
                stringBuilder.append(entry.getKey() + ":<br>");
                stringBuilder.append("YES" + " - " + ((Answer)entry.getValue()).getYes() + "<br>");
                stringBuilder.append("NO" + " - " + ((Answer)entry.getValue()).getNo() + "<br>");
            }
            session.setAttribute("statistic", stringBuilder.toString());
            response.sendRedirect("display.jsp");
            return;
        }

        response.sendRedirect("index.jsp");
    }

}
