<%-- 
    Document   : error
    Created on : 2016/07/19, 14:42:24
    Author     : 1999itukinao
--%>
<%@page import="Model.TCWHelper"%>
<%
     TCWHelper tcwh = new TCWHelper();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR!</h1>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%= request.getParameter("error") %><br><br>
        <%= tcwh.top() %>
    </body>
</html>
