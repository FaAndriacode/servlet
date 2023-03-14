<%-- 
    Document   : Redirection
    Created on : 7 mars 2023, 04:59:50
    Author     : andriniaina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String Url = (String)request.getAttribute("Url");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Redirection</h1>
        <p><%= Url %></p>
    </body>
</html>
