<%-- 
    Document   : registrationcomplete
    Created on : 2016/07/19, 13:38:34
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>TCW 登録完了Page</title>
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
                        <h1>- Registration Complete- </h1>
                        <h4>登録しました</h4>
                    </center>
                <!--/#contents--></div>
                <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
