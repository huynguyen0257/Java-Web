/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.controllers;

import huyng.beans.HuyNGBean;
import huyng.dtos.UserDTO;
import huyng.dtos.UserErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UserCreateController extends HttpServlet {

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
            String password = request.getParameter("txtPassword");
            String confirmPassword = request.getParameter("txtConfirmPassword");
            String username = request.getParameter("txtUsername");
            String fullname = request.getParameter("txtFullname");
            String gender = request.getParameter("genderCheckbox");
            Date birthday = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            boolean valid = true;
            UserErrorObject errorObj = new UserErrorObject();
            if (username.trim().length() == 0) {
                valid = false;
                errorObj.setUsernameError("*Username can not be blank!");
            }
            if (password.trim().length() == 0) {
                valid = false;
                errorObj.setPasswordError("*Password can not be blank!");
            }
            if (confirmPassword.trim().length() == 0) {
                valid = false;
                errorObj.setConfirmPasswordError("*Please input for Confirm Password!");
            }
            if (password.length() != 0 && confirmPassword.length() != 0) {
                if (!password.equals(confirmPassword)) {
                    valid = false;
                    errorObj.setConfirmPasswordError("*Confirm password does not match with Password!");
                }
            }
            if (gender == null) {
                valid = false;
                errorObj.setGenderError("*Please choose gender!");
            } else {
                if (gender.equalsIgnoreCase("Male")) {
                    request.setAttribute("gender", true);
                } else {
                    request.setAttribute("gender", false);
                }
            }
            if (fullname.trim().length() == 0) {
                valid = false;
                errorObj.setFullnameError("*Fullname can not be blank!");
            }
            //check valid Birthday
            try {
                birthday = format.parse(request.getParameter("txtBirthday"));
            } catch (Exception e) {
                valid = false;
                errorObj.setBirthdayError("*Birthdate must be select with format yyyy-DD-mm!");
            }
            Date date = new Date();
            String dateStr = format.format(date);
            if (birthday == null) {
                valid = false;
                errorObj.setBirthdayError("*Please choose birthday");
            } else {
                String[] yearCur = dateStr.split("-");
                String[] year = request.getParameter("txtBirthday").split("-");
                if ((Integer.parseInt(yearCur[0]) - Integer.parseInt(year[0])) < 18) {
                    valid = false;
                    errorObj.setBirthdayError("*Age must be greater than 18");
                }
            }
//            System.out.println(dateStr);
//            System.out.println(request.getParameter("txtBirthday"));
//            System.out.println(birthday);
            if (valid) {
                HuyNGBean bean = new HuyNGBean();
                UserDTO dto = new UserDTO(username, password, fullname, birthday, "user");
                if (gender.equalsIgnoreCase("Male")) {
                    dto.setGender(true);
                } else {
                    dto.setGender(false);
                }
                bean.setDto(dto);
                if (bean.insertUser()) {
                    url = "login.jsp";
                    request.setAttribute("SUCCESS", "Log up successful!");
                } else {
                    request.setAttribute("ERROR", "Create fail!");
                }
            } else {
                url = "register.jsp";
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
