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
public class RewardInsertController extends HttpServlet {

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
        RewardErrorObject errorObj = new RewardErrorObject();
        String url = "error.jsp";
        try {
            String rewardId = request.getParameter("txtRewardId");
            String rewardName = request.getParameter("txtRewardName");
            String regex = "R[0-9]{3}";
            float value = 0;
            boolean valid = true;
            try{
                value = Float.parseFloat(request.getParameter("txtRewardValue"));
                if(value<=0)
                    errorObj.setRewardValueError("*Value must be > 0");
            }catch(Exception e){
                errorObj.setRewardValueError("*Value must be number!");
            }
            if(rewardId.length()==0){
                valid = false;
                errorObj.setRewardIdError("*Id can not be blank!");
            }else if(!rewardId.matches(regex)){
                valid = false;
                errorObj.setRewardIdError("*Id must have format [Rxxx] With x is number");
            }
            if(rewardName.length()==0){
                valid = false;
                errorObj.setRewardNameError("*Name can not be blank!");
            }
            if(valid){
                RewardBean bean = new RewardBean();
                bean.setDto(new RewardDTO(rewardId, rewardName, value, true));
                if(bean.insertReward()){
                    url = "RewardSearchController";
                }else{
                    request.setAttribute("ERROR", "Insert fails!");
                }
            }else{
                url = "addNewReward.jsp";
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate key")){
                errorObj.setRewardIdError("This id have been existed!");
                url = "addNewReward.jsp";
                request.setAttribute("INVALID", errorObj);
            }else{
                e.printStackTrace();
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
