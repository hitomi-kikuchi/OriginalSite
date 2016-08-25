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
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>TCW TopPage</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <span class="header-left">
                    <% if(login){ %>
                    <%= TCWHelper.getInstance().logout() %>
                    <% } %>
                </span>
            </header>
            <div id="contents">
                <center>
                <h1>— Total Coordinate due to Weather —</h1>
                <div class="frame top in">
                    <% if(login) { %>
                    <div class="login">
                        ようこそ <a href="Mydata"><%= udb.getName() %></a> さん
                    </div>
                    <form action="choice.jsp">
                        <input class="btn" type="submit" value="Choice">
                    </form>
                    <form action="History">
                        <input class="btn" type="submit" value="History">
                    </form>
                    <% }else { %>
                    <form action="Choice" method="POST">
                        <div>
                            <label for="name">NAME:</label>
                            <input type="text" name="name">
                        </div>
                        <div>
                            <label for="pass">PASS:</label>
                            <input type="password" name="pass" placeholder=" 4文字の英数字">
                        </div>
                        <input class="btn" type="submit" name="login" value="LOGIN">　
                        <a href="Registration">新規登録</a> 
                    </form>
                    <% } %>
                <!--/.frame--></div>
                </center>
            <!--/#contens--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
