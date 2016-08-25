<%-- 
    Document   : mydataupdateresult
    Created on : 2016/07/19, 15:43:01
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    TCWHelper tcwh = new TCWHelper();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>TCW ユーザー情報更新結果page</title>
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
                        <h1>- Update Result -</h1>
                        <div class="frame other in">
                            NAME: <%= udb.getName() %><br>
                            PASS: <%= udb.getPassword() %><br>
                            AGE: <%= tcwh.exAgenum(udb.getAge()) %><br>
                            PLACE: <%= udb.getPlace() %><br>
                            LENGTH: <%= tcwh.exLengthnum(udb.getLength()) %>
                        <!--/.frame--></div>
                        <p>以上の内容で更新しました。</p>
                    </center>
                </div>
            <footer></footer>
        </div>
    </body>
</html>
