<%-- 
    Document   : home
    Created on : 26 dic. 2021, 19:51:45
    Author     : rpv15
--%>

<%@page import="model.User"%>
<%@include file="./partials/header.jsp"%>
<%@include file="./partials/menu.jsp"%>
    
    <div class="container">
        <h1 class="text-center">BIENVENIDO/A 
        <%
            out.println(" "+ user.getName() + " " + user.getLastname());
        %>
        !</h1>
        <img src="/imgs/user.png" class="rounded mx-auto d-block" width="800">
    </div>    

<%@include file="./partials/footer.jsp"%>