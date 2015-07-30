/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocsfinweb.web;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ocsfinweb.dao.OCSFINWEBDAO_QEWS;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MAXWELLPAYNE
 */
@WebServlet(name = "StaffStatement_Servlet", urlPatterns = {"/MyStaffStatement.do"})
public class StaffStatement_Servlet extends HttpServlet {

    OCSFINWEBDAO_QEWS qewsdao = new OCSFINWEBDAO_QEWS();
    //ServletConfig servletconfig = new ServletConfig();
    //String status = ServletConfig.class.; 
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
            out.println("<title>Servlet StaffStatement_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffStatement_Servlet at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException 
    {
        //processRequest(request, response);
        Gson gson = new Gson();
        PrintWriter write = response.getWriter();
        HttpSession sess = request.getSession();
         try
        {
            if(request.getParameter("param").equals("mystatement"))
            {
                String username = sess.getAttribute("username").toString();
                String password = sess.getAttribute("password").toString();
                Object qewsresponse_my = qewsdao.mystatement(username,password);
                String jsnmsg = gson.toJson(qewsresponse_my);
                write.println(jsnmsg);
                /*request.setAttribute("mystaffstatement", qewsresponse_my);
                RequestDispatcher dispatch = request.getRequestDispatcher("Pages/StaffStatement.jsp");
                dispatch.forward(request, response);*/
            
            }             
           
        
        }
        catch(Exception ex)
        {
            throw new ServletException(ex);
        
        }
        /*try
        {
            
            Object qewsresponse_my = qewsdao.mystatement(); 
            request.setAttribute("mystaffstatement", qewsresponse_my);
            RequestDispatcher dispatch = request.getRequestDispatcher("Pages/StaffStatement.jsp");
            dispatch.forward(request, response);
        
        }
        catch(Exception ex)
        {
            throw new ServletException(ex);
        
        }*/
        
        
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
        //processRequest(request, response);
        Gson gson = new Gson();
        PrintWriter write = response.getWriter();
        HttpSession sess = request.getSession();
         try
        {
            if(request.getParameter("param").equals("mystatement"))
            {
                String username = sess.getAttribute("username").toString();
                String password = sess.getAttribute("password").toString();
                Object qewsresponse_my = qewsdao.mystatement(username,password);
                String jsnmsg = gson.toJson(qewsresponse_my);
                write.println(jsnmsg);
                /*request.setAttribute("mystaffstatement", qewsresponse_my);
                RequestDispatcher dispatch = request.getRequestDispatcher("Pages/StaffStatement.jsp");
                dispatch.forward(request, response);*/
            
            }
            if(request.getParameter("param").equals("mydetails"))            
            {
                String username = sess.getAttribute("username").toString();
                String password = sess.getAttribute("password").toString();
                Object qewsresponse_my = qewsdao.mydetails(username,password);
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
