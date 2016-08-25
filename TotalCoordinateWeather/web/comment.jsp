<%-- 
    Document   : comment
    Created on : 2016/08/07, 16:42:21
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    HistoryDataBeans hdb = (HistoryDataBeans)request.getAttribute("comment");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">

        
        <title>コメント記入 Page</title>
    </head>
    <body>
        <header></header>
        <div id="contents">
            <center>
                <h1>- Comment- </h1>
                <div class="daialy">
                    <h5><%= hdb.getYear() %>/<%= hdb.getMonth() %>/<%= hdb.getDay() %>(<%= hdb.getWeek() %>)のHistoryにひと言を書き込む</h5>
                </div>
                <form action="CommentComplete?ID=<%= hdb.getHistoryID() %>" method="POST">
                    <textArea name="comment"></textArea><br>
                    <input class="btn" type="submit" value="WRITE">
                </form>
            </center>
        <!--/#wrap--></div>
        <footer></footer>
    </body>
</html>
