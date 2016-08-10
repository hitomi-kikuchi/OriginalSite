<%-- 
    Document   : history
    Created on : 2016/07/28, 17:57:01
    Author     : 1999itukinao
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    TCWHelper tcwh = TCWHelper.getInstance();
    ArrayList<HistoryDataBeans> hdbList = (ArrayList)hs.getAttribute("historydata");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/history.css">
        <!--jQuery>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="js/proposal.js"></script-->

        <title>履歴 Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <%= tcwh.top() %>
                <%= tcwh.logout() %>
            </header>
                <div id="contents">
                    <center>
                        <h1>History</h1>
                        <div id="main">
                            <table class="history">
                                <tdody>
                                    <% for(int i = 0; i < hdbList.size(); i++) { %>
                                    <tr>
                                        <td>
                                            <%= hdbList.get(i).getYear() %><br>
                                            <span class="bold"><%= hdbList.get(i).getMonth() %>/<%= hdbList.get(i).getDay() %></span><br>
                                            (<%= hdbList.get(i).getWeek() %>)
                                        </td>
                                        <td>
                                            <span class="bold"><%= hdbList.get(i).getLocation() %></span><br>
                                            <%= tcwh.exItemnum(hdbList.get(i).getItem()) %><br>
                                            <%= tcwh.exTastenum(hdbList.get(i).getTaste()) %>
                                        </td>
                                        <td>
                                            <div class="icon">
                                                <img src="http://openweathermap.org/img/w/<%= hdbList.get(i).getIcon() %>.png">
                                            <!--/.icon--></div>
                                            <div class="detail">
                                                <span class="temp_max"><%= hdbList.get(i).getTemp_max() %></span>℃/
                                                <span class="temp_min"><%= hdbList.get(i).getTemp_min() %></span>℃<br>
                                                湿度：<%= hdbList.get(i).getHumidity() %>％<br>
                                                風速<%= hdbList.get(i).getSpeed() %>m/s<br>
                                            <!--/.detail--></div>
                                        </td>
                                        <td>
                                            <% if(hdbList.get(i).getComment() == null) { %>
                                            <a href="Comment?ID=<%= hdbList.get(i).getHistoryID() %>">ひと言を書き込む</a>
                                            <% }else { %>
                                            <%= hdbList.get(i).getComment() %>
                                            <% } %>
                                        </td>
                                    </tr>
                                    <% } %>
                                </tdody>
                            </table>
                        <!--/#main--></div>
                   </center>
                <!--dontents--></div>
                   <footer></footer>
       <!--wrap--></div>
    </body>
</html>
            
