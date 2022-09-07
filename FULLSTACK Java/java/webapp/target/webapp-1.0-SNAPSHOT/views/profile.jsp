<%-- 
    Document   : profile
    Created on : 26 dic. 2021, 16:35:52
    Author     : rpv15
--%>

<%@include file="./partials/header.jsp"%>
<%@include file="./partials/menu.jsp"%>
          
<div class="container">
    <h2>Mis datos</h2>
    
    <%
        if (user != null){
            out.println("Nombre: " + user.getName());
            out.println("<br>");
            out.println("Apellido: " + user.getLastname());
            out.println("<br>");
            out.println("Email: "  + user.getEmail());
            out.println("<br>");
            out.println("Username: " + user.getUsername());
            out.println("<br><br>");
            
            out.println("<button class='btn btn-primary' type='button'>Cambiar Email</button>");
            out.println("<button class='btn btn-primary' type='button'>Cambiar Contraseña</button>");
        }
        else{
            out.println("Error");
        }
    %>
   
</div>
    

<%@include file="./partials/footer.jsp"%>
