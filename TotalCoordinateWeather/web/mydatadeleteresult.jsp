<%-- 
    Document   : mydatadeleteresult
    Created on : 2016/07/28, 15:22:40
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    TCWHelper tcwh = TCWHelper.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>ユーザー情報削除完了 Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <span class="header-left">
                    <%= tcwh.top() %>
                    <%= tcwh.logout() %>
                </span>
            </header>
                <div id="contents">
                    <center>
                        <h1>- Delete Complete -</h1>
                        <p>削除しました</p>
                    </center>
                <!--/#contents--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
