/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.controllers;

import huyng.beans.EventBean;
import huyng.dtos.EventDTO;
import huyng.dtos.EventErrorObject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chuối
 */
public class EventUpdateController extends HttpServlet {

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
        EventErrorObject errorObj = new EventErrorObject();
        String url = "error.jsp";
        try {
            String eventId = request.getParameter("txtEventId");
            String eventName = request.getParameter("txtEventName");

            //Format date
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = request.getParameter("txtFromDate");
            String date2 = request.getParameter("txtToDate");
            Date date = new Date();
            Date fromDate = null, toDate = null;
            boolean valid = true;
            try {
                fromDate = format.parse(date1);
            } catch (Exception e) {
                valid = false;
                errorObj.setFromDateError("*Please choose FromDate!");
            }
            try {
                toDate = format.parse(date2);
            } catch (Exception e) {
                valid = false;
                errorObj.setToDateError("*Please choose ToDate!");
            }
            if (toDate != null) {
                if (toDate.compareTo(date) <= 0) {
                    errorObj.setToDateError("*Todate is not greater than current date");
                    valid = false;
                }
            }
            if (fromDate != null && toDate != null && toDate.compareTo(date) >= 0) {
                if (fromDate.compareTo(toDate) >= 0) {
                    errorObj.setToDateError("*Todate is must greater than Fromday date");
                    valid = false;
                }
            }
            String place = request.getParameter("txtPlace");
            String rewardId = request.getParameter("listReward");
            String details = request.getParameter("txtDetails");
            String statusStr = request.getParameter("statusCheckbox");
            boolean status;
            if (statusStr.equalsIgnoreCase("Opening")) {
                status = true;
                request.setAttribute("status", "true");
            } else {
                status = false;
                request.setAttribute("status", "false");
            }
            if (eventId.length() == 0) {
                errorObj.setEventIdError("*Id can not be blank!");
                valid = false;
            }
            if (eventName.length() == 0) {
                errorObj.setEventNameError("*Name can not be blank!");
                valid = false;
            }
            if (place.length() == 0) {
                errorObj.setPlaceError("*Place can not be blank!");
                valid = false;
            }
            if (rewardId.length() == 0) {
                errorObj.setRewardIdError("*Reward can not be blank!");
                valid = false;
            }
            if (valid) {
                EventBean bean = new EventBean();
                String curReward = request.getParameter("txtCurRewardId");
                if (rewardId.equalsIgnoreCase(curReward)) {
                    bean.setDto(new EventDTO(eventId, eventName, place, details, fromDate, toDate, status));
                    boolean check = bean.updateEvent();
                    if (check) {
                        url = "EventSearchController";
                    } else {
                        request.setAttribute("ERROR", "Update fails!");
                    }
                } else {
                    bean.setDto(new EventDTO(eventId, eventName, place, details, rewardId, fromDate, toDate, status));
                    bean.setCurRewardId(curReward);
                    boolean check = bean.updateEventWithRewardId();
                    if (check) {
                        url = "EventSearchController";
                    } else {
                        request.setAttribute("ERROR", "Update fails!");
                    }
                }
            } else {
                url = "RewardGetAllListId";
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
