/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocsfinweb.web;

import com.google.gson.Gson;
import com.ocsfinweb.dao.OCSFINWEBDAO_QEWS;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MAXWELLPAYNE
 */
@WebServlet(name = "FinanceWeb_Servlet", urlPatterns = {"/FinanceWeb.do"})
public class FinanceWeb_Servlet extends HttpServlet {
    OCSFINWEBDAO_QEWS qewsdao = new OCSFINWEBDAO_QEWS();

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
            out.println("<title>Servlet FinanceWeb_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinanceWeb_Servlet at " + request.getContextPath() + "</h1>");
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
        Gson gson = new Gson();
        PrintWriter write = response.getWriter();
        HttpSession sess = request.getSession();
         try
        {
           
             if(request.getParameter("param").equals("budgetholders"))            
            {
                String param = request.getParameter("param");
                String username = sess.getAttribute("username").toString();
                String password = sess.getAttribute("password").toString();
                Object qewsresponse_my = qewsdao.budgetholders(username, password);
                //String jsnmsg = gson.toJson(qewsresponse_my);
                //write.println(jsnmsg);
                /**/request.setAttribute("mydetails", qewsresponse_my);
                RequestDispatcher dispatch = request.getRequestDispatcher("Pages/viewxml.jsp");
                dispatch.forward(request, response);
            
            }
           
        
        }
        catch(Exception ex)
        {
            throw new ServletException(ex);
        
        }
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
        //processRequest(request, response);
        Gson gson = new Gson();
        PrintWriter write = response.getWriter();
        HttpSession sess = request.getSession();
         try
        {
           
             if(!request.getParameter("param").isEmpty())            
            {
                String param = request.getParameter("param");
                String username = sess.getAttribute("username").toString();
                String password = sess.getAttribute("password").toString();
                Object qewsresponse_my = qewsdao.getmainproj(param,username,password);
                String jsnmsg = gson.toJson(qewsresponse_my);
                write.println(jsnmsg);
                /*request.setAttribute("mydetails", qewsresponse_my);
                RequestDispatcher dispatch = request.getRequestDispatcher("Pages/viewxml.jsp");
                dispatch.forward(request, response);*/
            
            }
           
        
        }
        catch(Exception ex)
        {
            throw new ServletException(ex);
        
        }
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
