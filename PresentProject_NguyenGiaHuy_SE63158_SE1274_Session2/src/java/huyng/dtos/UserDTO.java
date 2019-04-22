/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Chuối
 */
public class UserDTO implements Serializable{
    private String username , password , fullname , role;
    private boolean gender;
    private Date birthday;
    private int id;


    public UserDTO() {
    }

    public UserDTO(String fullname, int id) {
        this.fullname = fullname;
        this.id = id;
    }

    public UserDTO(String username, String password, String fullname, Date birthday, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.birthday = birthday;
        this.role = role;
    }

    public UserDTO(int id, String username, String fullname, String role, Date birthday) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.birthday = birthday;
    }

    public UserDTO(int id, String username, String fullname, String role, boolean gender, Date birthday) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.gender = gender;
        this.birthday = birthday;
    }
    
    

    public UserDTO( String username , String fullname, Date birthday, String role, boolean gender) {
        this.username = username;
        this.fullname = fullname;
        this.birthday = birthday;
        this.role = role;
        this.gender = gender;
    }

    public UserDTO(int id, String fullname, boolean gender) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + ", role=" + role + ", gender=" + gender + ", birthday=" + birthday + '}';
    }
    
}
