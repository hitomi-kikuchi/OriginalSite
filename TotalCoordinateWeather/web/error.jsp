<%-- 
    Document   : error
    Created on : 2016/07/19, 14:42:24
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
     TCWHelper tcwh = new TCWHelper();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>TCWerror Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <span class="header-left">
                    <%= TCWHelper.getInstance().top() %>
                </span>
            </header>
            <div id="contents">
                <center>
                    <h1>- ERROR! -</h1>
                    <h4>エラーが発生しました。以下の項目を確認してください。<br><br>
                    <%= request.getParameter("error") %></h4>
                </center>
            <!--/#contents--></div>
        <!--/#wrap--></div>
            <footer></footer>
    </body>
</html>
