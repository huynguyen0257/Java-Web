/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chuối
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCHUSER = "SearchUserController";
    private static final String EDITUSER = "EditUserController";
    private static final String UPDATEUSER = "UpdateUserController";
    private static final String DELETEUSER = "DeleteUserController";
    private static final String INSERTUSER = "InsertUserController";
    private static final String CREATE = "UserCreateController";
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
        String url = ERROR;
        try{
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("Login"))
                url = LOGIN;
            else if (action.equalsIgnoreCase("Search User"))
                url = SEARCHUSER;
            else if (action.equalsIgnoreCase("Edit User"))
                url = EDITUSER;
            else if (action.equalsIgnoreCase("Update User"))
                url = UPDATEUSER;
            else if (action.equalsIgnoreCase("Back To Manage User"))
                url = SEARCHUSER;
            else if (action.equalsIgnoreCase("Delete User"))
                url = DELETEUSER;
            else if (action.equalsIgnoreCase("Add New User"))
                url = INSERTUSER;
            else if (action.equalsIgnoreCase("Create"))
                url = CREATE;
            else{
                request.setAttribute("ERROR", "This action dose not support!");
            }
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
