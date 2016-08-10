<%-- 
    Document   : top
    Created on : 2016/07/15, 10:36:45
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    
    UserDataBeans udb = null;
    boolean login = false;
    if(hs.getAttribute("userdata") != null) {
        login = true;
        udb  = (UserDataBeans)hs.getAttribute("userdata");
    }   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">

        <title>TCW TopPage</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <% if(login){ %>
                <%= TCWHelper.getInstance().logout() %>
                <% } %>
            </header>
            <div id="contents">
                <center>
                <h1>— Total Coordinate due to Weather —</h1>
                <div id="frame">
                    <% if(login) { %>
                    <div id="mydata">
                        ようこそ <a href="Mydata"><%= udb.getName() %></a> さん
                    </div>
                    <form action="choice.jsp">
                        <input class="submit-button" type="submit" value="Choice">
                    </form>
                    <form action="History">
                        <input class="submit-button" type="submit" value="History">
                    </form>
                    <% }else { %>
                    <form action="Choice" method="POST">
                        NAME: <input type="text" name="name" ><br>
                        PASS: <input type="password" name="pass" placeholder="4文字の英数字"><br><br>
                        <input class="submit-button" type="submit" name="login" value="LOGIN">　
                        <a href="Registration">新規登録</a> 
                    </form>
                    <% } %>
                <!-- /#main --></div>
                </center>
            <!--/#contens--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
