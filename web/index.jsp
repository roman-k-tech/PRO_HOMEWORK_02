<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.12.2017
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HOMEWORK_02 - ANKETA</title>
  </head>
    <body>

    <% String login = (String)session.getAttribute("user_login"); %>
    <% String personName = (String)session.getAttribute("personName"); %>
    <% String personAge = (String)session.getAttribute("personAge"); %>

    <% if (login == null || "".equals(login)) { %>
        <form action="/login" method="POST">LOGIN<br>
            Login: <input type="text" name="login"><br>
            <br>
            Name: <input type="text" name="personName"><br>
            Age: <input type="text" name="personAge"><br>
            <br>
            <input type="submit" />
        </form>
    <% } else { %>
        <form action="/question" method = "POST">
            <br>
            Do you like JAVA?
            <br/><input type = "radio" name = "question1" value = "yes"/> YES
            <br/><input type = "radio" name = "question1" value = "no"/> NO

            <br/>
            Do you like .NET?
            <br/><input type = "radio" name = "question2" value = "yes"/> YES
            <br/><input type = "radio" name = "question2" value = "no"/> NO

            <br/>
            Do you have a cat?
            <br/><input type = "radio" name = "question3" value = "yes"/> YES
            <br/><input type = "radio" name = "question3" value = "no"/> NO
            <br/><input type = "submit"/>
        </form>
    <br>
    <%String output = (String) session.getAttribute("output"); %>
        <%if (output != null) {%>
            <%= output%>
        <% } %>
    <br>
    Click this link <a href="/display?a=statistic">STATISTIC</a> to see results.
    <br>
    You are logged in as: <%= login %> (<%= personName%>, of age <%= personAge%>).
    Click this link <a href="/login?a=exit">LOGOUT</a> to logout.
    <% } %>
  </body>
</html>
