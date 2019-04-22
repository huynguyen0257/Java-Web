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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chuối
 */
public class LeftUpdateProfileController extends HttpServlet {

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
            String id = request.getParameter("txtID");
            String username = request.getParameter("txtUsername");
            String fullname = request.getParameter("txtFullname");
            String gender = request.getParameter("genderCheckbox");
            String password = request.getParameter("txtPassword");
            Date birthday = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String role = request.getParameter("roleCheckbox");
            boolean valid = true;
            UserErrorObject errorObj = new UserErrorObject();
            if (username.trim().length() == 0) {
                valid = false;
                errorObj.setUsernameError("*Username can not be blank!");
            }
            if (fullname.trim().length() == 0) {
                valid = false;
                errorObj.setFullnameError("*Fullname can not be blank!");
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

            //check valid Birthday
            try {
                birthday = format.parse(request.getParameter("txtBirthday"));
            } catch (Exception e) {
                valid = false;
                errorObj.setBirthdayError("*Please choose birthday");
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
            if (role == null) {
                valid = false;
                errorObj.setRoleError("*Please choose role!");
            } else {
                if (role.equalsIgnoreCase("Admin")) {
                    request.setAttribute("role", true);
                } else {
                    request.setAttribute("role", false);
                }
            }
            if (valid) {
                HuyNGBean bean = new HuyNGBean();
                UserDTO dto = new UserDTO(Integer.parseInt(id), username, fullname, role.toLowerCase(), birthday);
                if (gender.equalsIgnoreCase("Male")) {
                    dto.setGender(true);
                } else {
                    dto.setGender(false);
                }
                String userhome = request.getParameter("editProfileInUserSide");
                if (password.length() == 0) {
                    bean.setDto(dto);
                    HttpSession session = request.getSession();
                    UserDTO userDTO = (UserDTO)session.getAttribute("USER");
                    userDTO.setFullname(fullname);
                    session.setAttribute("USER", userDTO);
                    boolean check = bean.updateUser();
                    if (check) {
                        if (userhome.equals("Userhome")) {
                            url = "userHome.jsp";
                        } else {
                            url = "manageEvent.jsp";
                        }
                    } else {
                        request.setAttribute("ERROR", "Update fail");
                    }
                } else {
                    dto.setPassword(password);
                    bean.setDto(dto);
                    HttpSession session = request.getSession();
                    UserDTO userDTO = (UserDTO)session.getAttribute("USER");
                    userDTO.setFullname(fullname);
                    session.setAttribute("USER", userDTO);
                    boolean check = bean.updateUserWithPassword();
                    if (check) {
                        if (userhome.equals("Userhome")) {
                            url = "userHome.jsp";
                        } else {
                            url = "manageEvent.jsp";
                        }
                    } else {
                        request.setAttribute("ERROR", "Update fail");
                    }
                }
            } else {
                url = "profile.jsp";
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
