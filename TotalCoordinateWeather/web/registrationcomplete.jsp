<%-- 
    Document   : registrationcomplete
    Created on : 2016/07/19, 13:38:34
    Author     : 1999itukinao
--%>
<%@page import="Model.TCWHelper"%>
<%@page import="Model.UserDataBeans"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/commentcomplete.css">

        <title>TCW 登録完了Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <ul>
                    <li><%= TCWHelper.getInstance().top() %></li>
                </ul>
            </header>
                <div id="contents">
                    <center>
                        <h1>Registration Complete</h1>
                        <p>登録しました</p>
                    </center>
                <!--/#contents--></div>
                <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
