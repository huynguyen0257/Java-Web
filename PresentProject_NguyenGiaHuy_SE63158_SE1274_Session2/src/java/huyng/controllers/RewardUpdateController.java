/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.controllers;

import huyng.beans.RewardBean;
import huyng.dtos.RewardDTO;
import huyng.dtos.RewardErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chuối
 */
public class RewardUpdateController extends HttpServlet {

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
        RewardErrorObject errorObj = new RewardErrorObject();
        try {
            String rewardId = request.getParameter("txtRewardId");
            String rewardName = request.getParameter("txtRewardName");
            float value = 0;
            boolean valid = true;
            boolean status;
            String statusStr = request.getParameter("statusCheckbox");
//            System.out.println(status);
            if(statusStr.equalsIgnoreCase("Availability")){
                status = true;
                request.setAttribute("status", true);
            }
            else {
                status = false;
                request.setAttribute("status", false);
            }
            try{
                value = Float.parseFloat(request.getParameter("txtRewardValue"));
                if(value<=0)
                    errorObj.setRewardValueError("*Value must be > 0");
            }catch(Exception e){
                errorObj.setRewardValueError("*Value must be number!");
                valid = false;
            }
            if(rewardName.length()==0){
                valid = false;
                errorObj.setRewardNameError("*Name can not be blank!");
            }
            System.out.println(valid);
            if(valid){
                RewardBean bean = new RewardBean();
                bean.setDto(new RewardDTO(rewardId, rewardName, value, status));
                if(bean.updateReward()){
                    url = "RewardSearchController";
                }else{
                    request.setAttribute("ERROR", "Update fail!");
                }
            }else{
                url = "editReward.jsp";
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
