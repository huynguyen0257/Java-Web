/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.beans;

import huyng.daos.UserDAO;
import huyng.dtos.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Chuối
 */
public class HuyNGBean implements Serializable{
    private String username , password ,search , eventId ;
    private UserDTO dto;
    private int id;

    public HuyNGBean() {
    }

    public UserDTO getDto() {
        return dto;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String checkLogin() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.checkLogin(username, password);
    }
    public ArrayList<UserDTO> searchLikeByFullname() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.searchLikeByName(search);
    }
    public void getInfoUserById ()throws Exception{
        UserDAO dao = new UserDAO();
        dto = dao.getInfoUserById(Integer.parseInt(search));
    }
    public boolean updateUser() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.updateUser(dto);
    }
    public boolean updateUserWithPassword() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.updateUserWithPassword(dto);
    }
    public boolean deleteUserById() throws Exception{
        UserDAO dao = new UserDAO();
        return dao.deleteUserById(id);
    }
    public boolean insertUser()throws Exception{
        UserDAO dao = new UserDAO();
        return dao.isertUser(dto);
    }
    public void getIdAndFullnameOfUser() throws Exception{
        UserDAO dao = new UserDAO();
        dto = dao.getIdAndFullnameOfUser(username, password);
    }
    public boolean userJoinInEvent () throws Exception{
        UserDAO dao = new UserDAO();
        return dao.userJoinInEvent(eventId, id);
    }
}
