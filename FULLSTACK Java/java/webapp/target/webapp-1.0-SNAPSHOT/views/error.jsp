<%-- 
    Document   : login
    Created on : 26 dic. 2021, 16:40:07
    Author     : rpv15
--%>

<%@include file="./partials/header.jsp"%>

<div class="container text-center">
    <br>
    <% 
        String error = (String) session.getAttribute("error"); 

        if (error == "errorLogin"){
            out.println(""+
                    "<div class='alert alert-danger' role='alert'>" +
                    "An error occurred while logging in. Try again"+
                  "</div>"
                    + "");
        } 
        if (error == "errorRegister"){
            out.println(""+
                    "<div class='alert alert-danger' role='alert'>" +
                    "An error occurred while registering. Try again"+
                  "</div>"
                    + "");
        }        
    %>    
    
    <img src="/imgs/error.jpg" class="rounded mx-auto d-block" width="800">
</div>
                
    

<%@include file="./partials/footer.jsp"%>
