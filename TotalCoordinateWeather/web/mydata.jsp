<%-- 
    Document   : mydata
    Created on : 2016/07/28, 13:32:22
    Author     : 1999itukinao
--%>
<%@page import="Model.TCWHelper"%>
<%@page import="Model.UserDataBeans"%>
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
        
        <!--css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mydata.css">
        
        <title>ユーザー情報管理 Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <%= tcwh.top() %>
                <%= tcwh.logout() %>
            </header>
                <div id="contents">
                    <center>
                        <h1>— My data —</h1>
                        <div id="frame">
                            NAME: <%= udb.getName() %><br>
                            PASS: <%= udb.getPassword() %><br>
                            AGE: <%= tcwh.exAgenum(udb.getAge()) %><br>
                            PLACE: <%= udb.getPlace() %><br>
                            HAIR LENGTH: <%= tcwh.exLengthnum(udb.getLength()) %>
                        <!--/#frame--></div>
                        <form action="MydataUpdate">
                            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                            <input class="submit-button"  type="submit" name="update" value="Update">
                        </form>
                        <form action="MydataDelete">
                            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                            <input class="submit-button" type="submit" name="delete" value="Delete">
                        </form>
                    </center>
                <!--/#contents--></div>
                            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
