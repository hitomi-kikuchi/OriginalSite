<%-- 
    Document   : choice
    Created on : 2016/07/22, 15:49:41
    Author     : 1999itukinao
--%>
<%@page import="Model.*"%>
<%
    HttpSession hs = request.getSession();
    TCWHelper tcwh = TCWHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");
    ProposalDataBeans pdb = (ProposalDataBeans)hs.getAttribute("season");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tcw.css">
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="js/tcw.js"></script>

        <title>条件選択Page</title>
    </head>
    <body>
        <div id="wrap">
            <header>
                <span class="header-left">
                    <%= tcwh.top() %>
                    <%= tcwh.history() %>
                    <%= tcwh.logout() %>
                </span>
                <span class="header-right">
                    <p class="userdata" >ようこそ <a href="Mydata"><%= udb.getName() %></a> さん</p>
                </span>
            </header>
                <div id="contents">
                    <center>
                        <h1>— Choice —</h1>
                        <div class="frame other in">
                            <form action="Proposal" method="POST">
                                <div>
                                    <label for="item">ITEM:</label>
                                    <select name="item">
                                        <option value="0">おまかせ</option>
                                        <%--冬(12月～3月)の時のみアウターを表示--%>
                                        <% if(pdb.getSeason() == 1) { %>
                                        <optgroup label="アウター">
                                            <% for(int i = 1; i <= 12; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>
                                        <% } %>
                                        <optgroup label="トップス">
                                            <% for(int i = 13; i <= 20; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>
                                        <optgroup label="ワンピース">
                                            <% for(int i = 21; i <= 26; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>
                                        <optgroup label="ボトムス">
                                            <% for(int i = 27; i <= 31; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>
                                        <optgroup label="シューズ">
                                            <% for(int i = 32; i <= 38; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>
                                        <optgroup label="レッグウェア">
                                            <% for(int i = 39; i <= 42; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>
                                        <optgroup label="バック">
                                            <% for(int i = 43; i <= 49; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>  
                                        <optgroup label="帽子">
                                            <% for(int i =50; i <= 53; i++) { %>
                                            <option value="<%=i%>"><%=tcwh.exItemnum(i)%></option>
                                            <% } %>
                                        </optgroup>  
                                    </select>
                                </div>
                                <div>
                                    <label for="taste">TASTE:</label>
                                    <select name="taste">
                                        <% for(int i = 0; i < 5; i++) { %>
                                        <option value="<%=i%>"><%=tcwh.exTastenum(i)%></option>
                                        <% } %>
                                    </select>
                                </div>
                                <div>
                                    <label for="place">PLACE:</label>
                                    <input type="text" name="place" placeholder=" <%= udb.getPlace() %>"><br>
                                    <font size="1">何も記入しなければ登録地になります。</font>
                                </div>
                                    <input class="btn" type="submit" name="bottom" value="ENTRY">
                            </form>
                        <!--/.frame--></div>
                    </center>
                <!--/#contents--></div>
            <footer></footer>
        <!--/#wrap--></div>
    </body>
</html>
