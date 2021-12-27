<%-- 
    Document   : register
    Created on : 26 dic. 2021, 18:00:38
    Author     : rpv15
--%>

<%@include file="./partials/header.jsp"%>
                
    <div class="container">

        <span class="border border-white">
            <h2>Registration</h2>
        </span>

        <form method="POST" action="../user/createUser">
            <div class="row">
                <div class="col-6">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Ingrese su nombre" required="true">
                </div>
                <div class="col-6">
                    <label for="lasname">Lastname</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Ingrese su apellido" required="true">
                </div>              
            </div>
            <br>
            <div class="row">
                <div class="col-6">
                    <label for="username">Username</label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Ingrese su nombre de usuario" required="true">
                </div>
                <div class="col-6">
                    <label for="email">Email</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Ingrese su email" required="true">
                </div>              
            </div>
            <br>
            <div class="row">
                <div class="col-6">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña" required="true">
                </div>
                <br>
                <div class="col-6">
                  <label for="password2">Repeat Password</label>
                  <input type="password" class="form-control" id="password2" name="password2" placeholder="Ingrese nuevamente su contraseña" required="true">
                </div>
            </div>                
            <br>
            <button type="submit" class="btn btn-primary">Sign Up</button> 
            <a href="/index.jsp" type="button" class="btn btn-link">Log In</a>
        </form>  
    </div>  
    <br><br>
<%@include file="./partials/footer.jsp"%>
