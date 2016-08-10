<%-- 
    Document   : proposal
    Created on : 2016/07/28, 16:35:51
    Author     : 1999itukinao
--%>
<%@page import="java.util.*"%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    TCWHelper tcwh = TCWHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");
    ArrayList<ProposalDataBeans> wearList = (ArrayList)hs.getAttribute("weardata");
    ProposalDataBeans hair = (ProposalDataBeans)hs.getAttribute("hairdata");
    HistoryDataBeans hdb = (HistoryDataBeans)hs.getAttribute("weatherdata");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--css-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/proposal.css">
        <link href="./css/lightbox.css" rel="stylesheet" media="all" type="text/css" >
        <!--jQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="js/proposal.js" type="text/javascript"></script>
        
        <title>提案 Page</title>
    </head>
    <body>
        <div id="wrap">
        <header>
            <%= tcwh.top() %>
            <button type="button" onclick="location.href='choice.jsp'">Choice</button>
            <%= tcwh.history() %>
            <%= tcwh.logout() %>
            <span class="header-right">
                ようこそ <a href="Mydata"><%= udb.getName() %></a> さん
            </span>
        </header>
            <div id="contents">
                <center>
                    <h1>— Proposal —</h1>      
                    <table class="weather">
                        <tbody>
                            <tr>
                                <th>Choice</th>
                                <th>Temp</th>
                                <th>icon</th>
                                <th></th>
                            </tr>
                            <tr>
                                <td>
                                    <span class="location"><%= hdb.getLocation() %></span>の天候情報<br>
                                    <%= tcwh.exItemnum(wearList.get(0).getItem()) %><br>
                                    <%= tcwh.exTastenum(wearList.get(0).getTaste()) %>
                                </td>
                                <td>
                                    <span class="temp_max"><%= hdb.getTemp_max() %></span>℃/
                                    <span class="temp_min"><%= hdb.getTemp_min() %></span>℃<br>
                                </td>
                                <td>
                                    <img src="http://openweathermap.org/img/w/<%= hdb.getIcon() %>.png"><br>
                                </td>
                                <td>
                                    湿度：<%= hdb.getHumidity() %>％<br>
                                    風速：<%= hdb.getSpeed() %>m/s
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                <br><br>
                                <% for(int i = 0; i < 3; i++) { %>
                                <a href="<%= wearList.get(i).getWearImg() %>" rel="lightbox">
                                    <img class="popup" src="<%= wearList.get(i).getWearImg() %>">
                                </a>
                                <% } %>
                                <a href="<%= hair.getUrl() %>" rel="lightbox">
                                    <img src="./hair-img/<%= hair.getHairImg() %>" height="350px">
                                </a>
                                <br><br>       
                </center>
            <!--/#contents--></div>
            <footer></footer>
        <!--/#wrap--></div>
                                <script src="js/lightbox.js" type="text/javascript"></script>
                                <script>
                                    lightbox.option({
                                    'fitImagesInViewport' : true,
                                    'wrapAround': true
                                    });
                                </script>
    </body>
</html>
