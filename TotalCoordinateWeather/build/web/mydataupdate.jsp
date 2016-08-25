<%-- 
    Document   : mydataupdate
    Created on : 2016/07/19, 16:02:00
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

        <title>TCW ユーザー情報更新page</title>
    </head>
    <body>
        <div id="wrap">
            <header></header>
            <div id="contents">
                <center>
                    <h1>- Mydata Update -</h1>
                    <div class="frame other in">
                        <form action="MydataUpdateResult" method="POST">
                            NAME: <input type="text" name="name" value="<%= udb.getName() %>">
                            <br>
                            PASS: <input type="text" name="pass" placeholder="4文字の英数字" maxlength="4" value="<%= udb.getPassword() %>">
                            <br>
                            AGE: <select name="age">
                                <option value="">年代を選択</option>
                                <% for(int i = 1; i <= 6; i++) { %>
                                <option value="<%=i%>" <% if(udb.getAge() == i){out.print("selected = selected");} %>><%= tcwh.exAgenum(i) %></option>
                                <% } %>
                            </select>
                            <br>
                            PLACE: <input type="text" name="place" value="<%= udb.getPlace() %>">
                            <br>
                            HAIR LENGTH: <select name="length">
                                <option value="">髪の長さを選択</option>
                                <% for(int i = 1; i <= 4; i++) { %>
                                <option value="<%=i%>"<% if(udb.getLength() == i){out.print("selected = selected");} %>><%= tcwh.exLengthnum(i) %></option>
                                <% } %>
                            </select>
                            <br>
                            <input id="btn" type="submit" name="register" value="Update">
                            <%--アクセスルートチェック--%>
                            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                        </form>
                    <!--/.frame--></div>
                </center>
            <!--/#contents--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
