<%-- 
    Document   : registrationconfirm
    Created on : 2016/07/19, 11:39:20
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%@page import="java.util.*"%>
<%
    HttpSession hs = request.getSession();
    TCWHelper tcwh = TCWHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>TCW 新規登録確認page</title>
    </head>
    <body>
        <div id="wrap">
            <header></header>
            <div id="contents">
                <center>
                    <% if(chkList.size() == 0) { %>
                    <h1>- Registrotion Confirm -</h1>
                    <div class="frame other">
                        NAME: <%= udb.getName() %><br>
                        PASS: <%= udb.getPassword() %><br>
                        AGE: <%= tcwh.exAgenum(udb.getAge()) %><br>
                        PLACE: <%= udb.getPlace() %><br>
                        HAIR LENGTH: <%= tcwh.exLengthnum(udb.getLength()) %>
                    <!--/.frame--></div>
                    <p>以上の内容で登録します。よろしいですか？</p>
                    <form action="RegistrationComplete" method="POST">
                        <input class="btn" type="submit" name="yes" value="YES">
                        <%--アクセスルートチェック--%>
                        <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                    </form>
                    <form action="Registration" method="POST">
                        <input class="btn" type="submit" name="no" value="NO">
                        <input type="hidden" name="mode" value="REINPUT">
                    </form>
                    <% }else { %>
                    <h1>Not input!!</h1>
                    <div class="frame other">
                        <%= tcwh.chkinput(chkList) %>
                    <!--/.frame--></div>
                    <form action="Registration" method="POST">
                        <input class="btn" type="submit" name="no" value="登録画面へ戻る">
                        <input type="hidden" name="mode" value="REINPUT">
                    </form>
                    <% } %>
                </center>
            <!--/#contens--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
