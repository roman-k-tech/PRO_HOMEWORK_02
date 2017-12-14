public class Answer {

    private Integer yes = 0;
    private Integer no = 0;

    public Answer () {}

    public Answer (String answer)
    {
        if (answer.equals("yes")) {
            yes++;
        }
        else {
            no++;
        }
    }

    public Integer getYes() {
        return yes;
    }
    public Integer getNo() {
        return no;
    }

    public void increment (String answer)
    {
        if (answer.equals("yes")) {
            yes++;
        }
        else {
            no++;
        }
    }
}
