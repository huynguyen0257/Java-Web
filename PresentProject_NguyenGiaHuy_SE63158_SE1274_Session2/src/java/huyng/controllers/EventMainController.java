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
public class EventMainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SEARCH = "EventSearchController";
//    private static final String EDIT = "RewardGetAllListId";
    private static final String UPDATE = "EventUpdateController";
    private static final String INSERT = "EventInsertController";
    private static final String DELETE = "EventDeleteController";
    private static final String GETREWARD = "EventGetRewardController";
    private static final String DELETEUSER = "EventDeleteUserController";
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
            if(action.equalsIgnoreCase("Search"))
                url = SEARCH;
//            else if(action.equalsIgnoreCase("Edit"))
//                url = EDIT;
            else if(action.equalsIgnoreCase("Update"))
                url = UPDATE;
            else if(action.equalsIgnoreCase("Back To Manage Event"))
                url = SEARCH;
            else if (action.equalsIgnoreCase("Insert"))
                url = INSERT;
            else if (action.equalsIgnoreCase("Delete"))
                url = DELETE;
            else if (action.equalsIgnoreCase("User get reward"))
                url = GETREWARD;
            else if (action.equalsIgnoreCase("Delete User from Event"))
                url = DELETEUSER;
            else
                request.setAttribute("ERROR", "Action do not support!");
        }finally{
//            System.out.println(url);
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
