<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 14.12.2017
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOMEWORK_02 - ANKETA</title>
</head>
<body>
        <%String output = (String) session.getAttribute("statistic"); %>
        <br>
        <% if (output == null || output.equals("")) { %>
            You dont have statistic yet!
        <% } else { %>
            Your current statistic: <br><br>
            <%= output %>
        <% } %>
        <br>
        <br>Click this link to <a href="/index.jsp">QUESTIONS</a> to get back to questions.
</body>
</html>
