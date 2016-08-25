<%-- 
    Document   : registration
    Created on : 2016/07/15, 10:47:54
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    TCWHelper tcwh = new TCWHelper();
    
    UserDataBeans udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        <title>TCW 新規会員登録page</title>
    </head>
    <body>
        <div id="wrap">
            <header></header>
            <div id="contents">
                <center>
                    <h1 >- User Registration -</h1>
                    <div class="frame other in">
                        <form action="RegistrationConfirm" method="POST">
                            <label for="name">NAME:</label>
                            <input type="text" name="name" value="<% if(reinput){out.print(udb.getName());} %>">
                            <br>
                            <label for="pass">PASS:</label>
                            <input type="password" name="pass" placeholder="4文字の英数字" maxlength="4" <% if(reinput){out.print(udb.getPassword());} %>>
                            <br>
                            <label for="age">AGE:</label>
                            <select name="age">
                                <option value="">年代を選択</option>
                                <% for(int i = 1; i <= 6; i++) { %>
                                <option value="<%=i%>"<% if(reinput && udb.getAge() == i){out.print("selected = selected");} %>><%= tcwh.exAgenum(i) %></option>
                                <% } %>
                            </select>
                            <br>
                            <label for="place">PLACE:</label>
                            <input type="text" name="place" value="<% if(reinput){out.print(udb.getPlace());} %>">
                            <br>
                            <label for="length">HAIR LENGTH:</label>
                            <select name="length">
                                <option value="">髪の長さを選択</option>
                                <% for(int i = 1; i <= 4; i++) { %>
                                <option value="<%=i%>"<% if(reinput && udb.getLength() == i){out.print("selected = selected");} %>><%= tcwh.exLengthnum(i) %></option>
                                <% } %>
                            </select>
                            <br>
                            <%--アクセスルートチェック--%>
                            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                            <input class="btn" type="submit" name="register" value="ENTRY">
                        </form>
                    <!--/.frame--></div>
                </center>
            <!--/#contents--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
