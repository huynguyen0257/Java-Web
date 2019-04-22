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
public class UserHomeMainController extends HttpServlet {
    private static final String SEARCH = "UserHomeEventSearchController";
    private static final String EDIT = "UserHomeEventEditController";
    private static final String CANCEL = "UserHomeEventSearchController";
    private static final String JOIN = "UserHomeJoinEventController";
    private static final String SEARCH_EVENT = "UserHomeSearchJoinedEventController";
    private static final String UNJOIN = "UserHomeUnJoinJoinedEventController";
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
        String url = "error.jsp";
        try {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("Search"))
                url = SEARCH;
            else if(action.equalsIgnoreCase("Edit"))
                url = EDIT;
            else if(action.equalsIgnoreCase("Back To User Home")){
                String viewJoinEvent = request.getParameter("viewJoinEvent");
                if(viewJoinEvent!=null){
                    url = "UserHomeSearchJoinedEventController";
                }else
                    url = CANCEL;
            }
            else if(action.equalsIgnoreCase("Join"))
                url = JOIN;
            else if (action.equalsIgnoreCase("Search Event"))
                url = SEARCH_EVENT;
            else if (action.equalsIgnoreCase("UnJoin"))
                url = UNJOIN;
            else
                request.setAttribute("ERROR", "Action does not support!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
//            System.out.println("url = " +url);
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
