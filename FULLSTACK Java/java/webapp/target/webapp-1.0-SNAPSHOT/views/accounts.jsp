<%-- 
    Document   : accounts
    Created on : 26 dic. 2021, 23:28:29
    Author     : rpv15
--%>


<%@page import="model.Account"%>
<%@page import="java.util.List"%>
<%@include file="./partials/header.jsp"%>
<%@include file="./partials/menu.jsp"%>
    
<div class="container">
    <h2>Accounts</h2>
    <p>Datos de mis cuentas</p>
    
    <%
        List<Account> accounts = (List<Account>) session.getAttribute("accounts");
        if (accounts.size()>0){
            for (int i=0 ; i < accounts.size(); i++){
                out.println("<div class='card' style='width: 18rem; border-color: black; '>");
                out.println("<div class='card-body' style='background-color:  #9ccdec ;' >");
                
                out.println("Account Number: " + accounts.get(i).getAccountNumber());
                out.println("<br>");
                out.println("Type: " + accounts.get(i).getType());
                out.println("<br>");
                out.println("Balance: " + accounts.get(i).getBalance());
                out.println("<br>");
                out.println("Currency: " + accounts.get(i).getCurrency());
                out.println("<br><br>");
                out.println("<a href='#' class='btn btn-primary''>Ver movimientos</a>");
                out.println("<br>");
                                
                out.println("</div>");
                out.println("</div>");
                out.println("<br>");
            }
                        
         }
        else{
            out.println("Empty list");
        }
        
    %>
    
</div>

<br><br>
    
<%@include file="./partials/footer.jsp"%>
