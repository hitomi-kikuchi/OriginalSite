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
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">
        <link href="./css/lightbox.css" rel="stylesheet" media="all" type="text/css" >
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        
        <title>提案 Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <span class="header-left">
                    <%= tcwh.top() %>
                    <button type="button" onclick="location.href='choice.jsp'">Choice</button>
                    <%= tcwh.history() %>
                    <%= tcwh.logout() %>
                </span>
                <div class="header-right">
                    <p class="userdata" >ようこそ <a href="Mydata"><%= udb.getName() %></a> さん</p>
                </div>
            </header>
            <div id="contents">
                <center>
                    <h1>— Proposal —</h1>      
                    <table class="table weather">
                        <tbody>
                            <tr>
                                <td>
                                    <span class="bold"><%= hdb.getLocation() %></span>の天候情報<br>
                                    <%= tcwh.exItemnum(wearList.get(0).getItem()) %><br>
                                    <%= tcwh.exTastenum(wearList.get(0).getTaste()) %>
                                </td>
                                <td>
                                    <div class="icon">
                                        <img src="http://openweathermap.org/img/w/<%= hdb.getIcon() %>.png">
                                    <!--/.icon--></div>
                                    <div class="detail">
                                        <span class="temp_max"><%= hdb.getTemp_max() %></span>℃/
                                        <span class="temp_min"><%= hdb.getTemp_min() %></span>℃<br>
                                        湿度：<%= hdb.getHumidity() %>％<br>
                                        風速：<%= hdb.getSpeed() %>m/s<br>
                                    <!--/.detail--></div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                <br><br>
                                <% for(int i = 0; i < 3; i++) { %>
                                <a href="<%= wearList.get(i).getWearImg() %>" rel="lightbox">
                                    <img class="image" src="<%= wearList.get(i).getWearImg() %>">
                                </a>
                                <% } %>
                                <a href="<%= hair.getUrl() %>">
                                    <img class="image" src="./hair-img/<%= hair.getHairImg() %>" height="350px">
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
