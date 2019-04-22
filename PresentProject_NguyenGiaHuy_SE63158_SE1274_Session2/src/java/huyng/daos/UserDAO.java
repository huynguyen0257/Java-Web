/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.daos;

import huyng.conn.MyConnection;
import huyng.dtos.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chuối
 */
public class UserDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    private void closeConnection() throws Exception{
        if( rs != null ) rs.close();
        if( preStm != null ) preStm.close();
        if( conn !=null ) conn.close();
    }
    public String checkLogin(String username , String passwork) throws Exception{
        String role = "failed";
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select Role From tbl_Users Where Username = ? and Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, passwork);
            rs = preStm.executeQuery();
            if (rs.next()) {                
                role = rs.getString("Role");
            }
        }finally{
            closeConnection();
        }
        return role;
    }
    public UserDTO getIdAndFullnameOfUser(String username , String passwork) throws Exception{
        UserDTO dto = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select UserId , fullname from tbl_Users Where Username = ? and Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, passwork);
            rs = preStm.executeQuery();
            if(rs.next()){
                dto = new UserDTO();
                dto.setId(rs.getInt("UserId"));
                dto.setFullname(rs.getString("Fullname"));
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public ArrayList<UserDTO> searchLikeByName (String search) throws Exception{
        ArrayList<UserDTO> result = new ArrayList<>();
        boolean gender;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select UserID , Fullname , Gender From tbl_Users Where Fullname LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {                
                gender = rs.getBoolean("Gender");
                result.add(new UserDTO(rs.getInt("UserID"), rs.getString("Fullname"), gender));
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public UserDTO getInfoUserById (int id) throws Exception{
        UserDTO dto = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select Username , Fullname , Gender , Birthday , Role From tbl_Users Where UserID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                boolean genden = rs.getBoolean("Gender");
                Date birthday = rs.getDate("Birthday");
                String role = rs.getString("Role");
                dto = new UserDTO(id, username, fullname, role, genden, birthday);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean updateUser (UserDTO dto) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = date.format(dto.getBirthday());
            String sql = "Update tbl_Users set Username = ?, Fullname = ? , gender = ? , Birthday = ? , Role = ? Where UserID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getGender()+"");
            preStm.setString(4, birthday);
            preStm.setString(5, dto.getRole());
            preStm.setInt(6, dto.getId());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean updateUserWithPassword (UserDTO dto) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = date.format(dto.getBirthday());
            String sql = "Update tbl_Users set Username = ?,Password = ?, Fullname = ? , gender = ? , Birthday = ? , Role = ? Where UserID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getGender()+"");
            preStm.setString(5, birthday);
            preStm.setString(6, dto.getRole());
            preStm.setInt(7, dto.getId());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean deleteUserById (int id) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "delete from tbl_Users Where UserID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return  check;
    }
    public boolean isertUser (UserDTO dto) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = date.format(dto.getBirthday());
            String sql = "insert into tbl_Users(Username , password , fullname , gender , birthday , role) values (?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getGender()+"");
            preStm.setString(5, birthday);
            preStm.setString(6, dto.getRole());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean userJoinInEvent(String eventId , int userId) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "insert into tbl_EventUser (eventId , userId) values (?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, eventId);
            preStm.setInt(2, userId);
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
}
