/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.AccountDAO;
import database.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.User;

/**
 *
 * @author rpv15
 */
@WebServlet(name = "UserController", urlPatterns = {"/user/*"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getPathInfo();            
            HttpSession session = request.getSession();            
            UserDAO userDAO = new UserDAO();  
            
            switch (action) {
                case "/login":  
                    String userName = request.getParameter("username");
                    String pass = request.getParameter("password");
                    boolean login = userDAO.login(userName, pass);
                    if (login) {  
                        User user = userDAO.getUserByUserName(userName);                        
                        session.setAttribute("user", user);
                        response.sendRedirect("/views/home.jsp");
                    } else {
                        session.setAttribute("error", "errorLogin");
                        response.sendRedirect("/views/error.jsp");
                    }   
                    break;
                case "/createUser":
                    userName = request.getParameter("username");
                    pass = request.getParameter("password");
                    String name = request.getParameter("name");
                    String lastname = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String repass = request.getParameter("password2");
                    UserDAO newUser = new UserDAO();
                    boolean isCreated = newUser.createUser(userName, pass, name, lastname, email, repass);
                    
                    if (isCreated) {
                        User user = userDAO.getUserByUserName(userName);                        
                        session.setAttribute("user", user);
                        response.sendRedirect("/views/home.jsp");
                    } else {
                        session.setAttribute("error", "errorRegister");
                        response.sendRedirect("/views/error.jsp");
                    }
                    break;
                case "/logout":
                    session.setAttribute("isLogin", false);
                    response.sendRedirect("/");
                    break;
                case "/profile":
                    response.sendRedirect("/views/profile.jsp");
                    break;
                case "/accounts":

                    AccountDAO accountDao = new AccountDAO();
                    List<Account> accounts = new ArrayList<>();
                    User user = (User) session.getAttribute("user");
                    accounts = accountDao.getAccounts(user.getIduser());
                    session.setAttribute("accounts", accounts);
                    response.sendRedirect("/views/accounts.jsp");
                    break;
                case "/home":
                    response.sendRedirect("/views/home.jsp");
                    break;
                default:                     
                    break;
            
            }

            
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
