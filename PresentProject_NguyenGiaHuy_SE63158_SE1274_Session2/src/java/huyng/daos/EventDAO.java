/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.daos;

import huyng.conn.MyConnection;
import huyng.dtos.EventDTO;
import huyng.dtos.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Chuối
 */
public class EventDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public ArrayList<EventDTO> searchEventLikeByName(String name) throws Exception {
        ArrayList<EventDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Eventid , Eventname , fromdate , todate , rewardId from tbl_Events Where eventname LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new EventDTO(rs.getString("eventid"), rs.getString("eventname"), rs.getDate("fromdate"), rs.getDate("todate"), rs.getString("RewardId")));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public ArrayList<EventDTO> searchEventLikeByNameWithAvailableStatus(String name) throws Exception {
        ArrayList<EventDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Eventid , Eventname , fromdate , todate , rewardId from tbl_Events Where eventname LIKE ? and status = 'true'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new EventDTO(rs.getString("eventid"), rs.getString("eventname"), rs.getDate("fromdate"), rs.getDate("todate"), rs.getString("RewardId")));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    //return null if id not exist 
    public EventDTO getInfoEventById(String id) throws Exception {
        EventDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Eventname,place , details , fromdate , todate , rewardId , status from tbl_Events Where eventid = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("eventname");
                String place = rs.getString("Place");
                String details = rs.getString("details");
                Date fromDate = rs.getDate("fromdate");
                Date toDate = rs.getDate("todate");
                String rewardId = rs.getString("rewardId");
                boolean status = rs.getBoolean("status");
                dto = new EventDTO(id, name, place, details, rewardId, fromDate, toDate, status);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insertNewEvent(EventDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SET XACT_ABORT ON\n";
            sql += "BEGIN TRANSACTION\n";
            sql += "insert into tbl_Events (eventid , eventname , place , details , fromdate , todate , rewardid,status) values"
                    + " (?,?,?,?,?,?,?,?)\n";
            sql += "update tbl_Rewards set status = 'false' Where RewardID = ?\n";
            sql += "commit";
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fromDate = date.format(dto.getFromDate());
            String toDate = date.format(dto.getToDate());
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEventId());
            preStm.setString(2, dto.getEventName());
            preStm.setString(3, dto.getPlace());
            preStm.setString(4, dto.getDetails());
            preStm.setString(7, dto.getRewardId());
            preStm.setString(5, fromDate);
            preStm.setString(6, toDate);
            preStm.setString(8, "True");
            preStm.setString(9, dto.getRewardId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateEvent(EventDTO dto) throws Exception {
        boolean check = false;
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fromDate = date.format(dto.getFromDate());
            String toDate = date.format(dto.getToDate());
            conn = MyConnection.getMyConnection();
            String sql = "update tbl_Events set Eventname = ? , place = ? ,details = ? , fromdate = ? , todate = ? , status = ? Where Eventid = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEventName());
            preStm.setString(2, dto.getPlace());
            preStm.setString(3, dto.getDetails());
            preStm.setString(4, fromDate);
            preStm.setString(5, toDate);
            if (dto.isStatus()) {
                preStm.setString(6, "true");
            } else {
                preStm.setString(6, "false");
            }
            preStm.setString(7, dto.getEventId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateEventWithRewardId(EventDTO dto, String curRewardId) throws Exception {
        boolean check = false;
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fromDate = date.format(dto.getFromDate());
            String toDate = date.format(dto.getToDate());
            conn = MyConnection.getMyConnection();
            String sql = "SET XACT_ABORT ON\n";
            sql += "BEGIN TRANSACTION\n";
            sql += "update tbl_Events set Eventname = ? , place = ? ,details = ? , fromdate = ? , todate = ? ,RewardId = ?, status = ? Where Eventid = ?\n";
            sql += "update tbl_Rewards set status = 'false' where RewardId = ?\n";
            sql += "update tbl_Rewards set status = 'true' where RewardId = ?\n";
            sql += "commit";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getEventName());
            preStm.setString(2, dto.getPlace());
            preStm.setString(3, dto.getDetails());
            preStm.setString(4, fromDate);
            preStm.setString(5, toDate);
            preStm.setString(6, dto.getRewardId());
            if (dto.isStatus()) {
                preStm.setString(7, "true");
            } else {
                preStm.setString(7, "false");
            }
            preStm.setString(8, dto.getEventId());
            preStm.setString(9, dto.getRewardId());
            preStm.setString(10, curRewardId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteEvent(String id, String rewardId) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SET XACT_ABORT ON\n";
            sql += "BEGIN TRANSACTION\n";
            sql += "update tbl_Rewards set status = 'true' Where RewardId = ?\n"
                    + "delete from tbl_EventUser Where EventId = ?\n"
                    + "delete from tbl_EventUserReward Where Eventid = ?\n"
                    + "delete from tbl_Events Where Eventid = ?\n";
            sql += "Commit";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, rewardId);
            preStm.setString(2, id);
            preStm.setString(3, id);
            preStm.setString(4, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    //Get All Event of User joined with String
    public ArrayList<String> getAllEventOfUserJoined(int id) throws Exception {
        ArrayList<String> result = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select EventId from tbl_EventUser Where UserId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("EventId"));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    //Get All Event of User joined with UserDTO
    public ArrayList<EventDTO> getAllJoinedEventOfUser(int id, String name) throws Exception {
        ArrayList<EventDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select tbl_Events.EventID , EventName , FromDate , ToDate\n"
                    + "from tbl_EventUser , tbl_Events\n"
                    + "Where tbl_EventUser.EventID = tbl_Events.EventID and tbl_EventUser.UserID = ? and EventName LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            preStm.setString(2, "%" + name + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new EventDTO(rs.getString("EventId"), rs.getString("EventName"), rs.getDate("Fromdate"), rs.getDate("Todate"), null));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    //Delete user in event by eventid and userid
    public boolean unjoinEvent(String eventId, int userid) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Delete from tbl_EventUser Where EventId = ? and UserId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, eventId);
            preStm.setInt(2, userid);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    //Show all user join in Event
    public ArrayList<UserDTO> getAllUserInEvent(String eventid) throws Exception {
        ArrayList<UserDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select  tbl_Users.UserID, Fullname \n"
                    + "From tbl_Users , tbl_EventUser\n"
                    + "Where tbl_Users.UserID = tbl_EventUser.UserID and EventID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, eventid);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new UserDTO(rs.getString("Fullname"), rs.getInt("Userid")));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    //Get Reward for User On this Event
    public boolean getRewardForUserAndCloseEvent(String eventId, int userId, String rewardID) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SET XACT_ABORT ON\n";
            sql += "BEGIN TRANSACTION\n";
            sql += "insert into tbl_EventUserReward (Eventid , Userid , Rewardid) values (?,?,?)\n"
                    + "update tbl_Events set status = ? Where EventId = ?\n";
            sql += "commit";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, eventId);
            preStm.setInt(2, userId);
            preStm.setString(3, rewardID);
            preStm.setString(4, "false");
            preStm.setString(5, eventId);
            check = preStm.executeUpdate()>0;
        } finally {
            closeConnection();
        }
        return check;
    }
    //Delete User from this Event
    public boolean deleteUserFromEvent (String eventId , int userId) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Delete tbl_EventUser Where Eventid = ? and UserId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, eventId);
            preStm.setInt(2, userId);
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    //check User have Reward in this Event 
    public boolean checkRewardForUserInEvent (String eventId , int userId ) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select Rewardid From tbl_EventUserReward Where Eventid = ? and userid = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, eventId);
            preStm.setInt(2, userId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        }finally{
            closeConnection();
        }
        return check;
    }
}
