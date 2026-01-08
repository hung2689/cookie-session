<%-- 
    Document   : index
    Created on : Jan 8, 2026, 7:13:01 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equalsIgnoreCase("username")) {
                        username=c.getValue();
                    }
                }
            }
        %>

        <form action="login" method="post">
            <label>Username:</label>
            <input type="text" name="username" value="<%=username%>" required><br>

            <label>Password:</label>
            <input type="password" name="password" required><br>

            <input type="checkbox" name="remember" value="true">
            <label>Remember me</label><br>

            <button type="submit">Login</button>
        </form>
            <p style="color: red">${requestScope.msg}</p>

    </body>
</html>
