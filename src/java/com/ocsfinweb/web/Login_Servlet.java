/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocsfinweb.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ocsfinweb.dao.OCSFINWEBLOGINDAO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MAXWELLPAYNE
 */
@WebServlet(name = "Login_Servlet", urlPatterns = {"/Login.do"})
public class Login_Servlet extends HttpServlet {
    OCSFINWEBLOGINDAO ocsfinweblogindao = new OCSFINWEBLOGINDAO();
    

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException 
    {
        String username=request.getParameter("username_textfield").toUpperCase();
        String password = request.getParameter("password_textfield");
        
        try
        {
            boolean authenticated = ocsfinweblogindao.authenticateldap(username, password);
            if(authenticated==true)
            {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("password", password);
                response.sendRedirect("/OCSFINWEB/index.jsp?msg=You have logged in successfully as "+username);
            
            }
            else
            {
                response.sendRedirect("/OCSFINWEB/login.jsp?errmsg=Wrong Username or Password. Please try again.");
            }
        
        }
        catch(Exception ex)
        {
            throw new ServletException(ex);
        
        }
        
        
        //processRequest(request, response);
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
