<%-- 
    Document   : home
    Created on : Jan 8, 2026, 10:39:55 PM
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
            String username = (String) session.getAttribute("username");
            if (username == null) {
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie c : cookies) {
                        if (c.getName().equalsIgnoreCase("username")) {
                            username=c.getValue();
                            session.setAttribute("username", username);
                            break;
                        }
                    }
                }
            }
            
            if(username==null){
            response.sendRedirect("index.jsp");
            }
        %>
        <h1>xin chào,${sessionScope.username}</h1>
        <a href="logout">logout</a>
    </body>
</html>
