<%-- 
    Document   : commentcomplete
    Created on : 2016/08/07, 18:16:41
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    TCWHelper tcwh = TCWHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>コメント記入完了 Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <span class="header-left">
                    <%= tcwh.top() %>
                    <%= tcwh.history() %>
                    <%= tcwh.logout() %>
                </span>
            </header>
                <div id="contents">
                    <center>
                        <h1>- CommentComplete -</h1>
                        <h4>書き込みました</h4>
                    </center>
                <!--/#contents--></div>
                <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
