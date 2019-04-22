/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.controllers;

import huyng.beans.EventBean;
import huyng.dtos.EventDTO;
import huyng.dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chuối
 */
public class UserHomeEventSearchController extends HttpServlet {

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
        try {
            String name = request.getParameter("txtEventSearchName");
            EventBean bean = new EventBean();
            bean.setTxtEventSearchName(name);
            ArrayList<EventDTO> list = bean.searchEventLikeByNameWithAvailableStatus(); //List All Event
            HttpSession session = request.getSession();
            UserDTO dto = (UserDTO) session.getAttribute("USER");
            bean.setUserId(dto.getId());
            ArrayList<String> listEventOfUser = bean.getAllEventOfUserJoined(); //Eventid Of User Joined
            HashMap<String,EventDTO> newList = new HashMap<>();
            //Delete Event have been joined
            for (EventDTO e : list) {
                newList.put(e.getEventId(), e);
            }
            for (String event : listEventOfUser) {
                newList.remove(event);
            }
            //Create new list Event that user can join
            ArrayList<EventDTO> list1 = new ArrayList<>();
            for (EventDTO value : newList.values()) {
                list1.add(value);
            }
            request.setAttribute("INFO", list1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("userHome.jsp").forward(request, response);
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
