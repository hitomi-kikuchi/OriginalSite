<%-- 
    Document   : mydatadelete
    Created on : 2016/07/28, 15:16:20
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");
    TCWHelper tcwh = TCWHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrap">
            <header></header>
            <div id="contents">
                <center>
                    <h1>- Delete -</h1>
                    <div class="frame other">
                        NAME: <%= udb.getName() %><br>
                        PASS: <%= udb.getPassword() %><br>
                        AGE: <%= tcwh.exAgenum(udb.getAge()) %><br>
                        PLACE: <%= udb.getPlace() %><br>
                        HAIR LENGTH: <%= tcwh.exLengthnum(udb.getLength()) %>
                    <!--/.frame--></div>
                    <p>削除します。よろしいですか？</p>
                    <form action="MydataDeleteResult?id=<%= udb.getUserID()%>" method="POST">
                        <%--アクセスルートチェック--%>
                        <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                        <input class="btn" type="submit" name="yes" value="YES">
                    </form>
                    <form action="top.jsp" method="get">
                        <input class="btn" type="submit" name="no" value="NO">
                    </form>
                </center>
            <!--/#contents--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
