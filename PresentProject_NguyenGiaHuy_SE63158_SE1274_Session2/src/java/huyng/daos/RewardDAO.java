/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.daos;

import huyng.conn.MyConnection;
import huyng.dtos.RewardDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chuối
 */
public class RewardDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    private void closeConnection() throws Exception{
        if( rs != null ) rs.close();
        if( preStm != null ) preStm.close();
        if( conn !=null ) conn.close();
    }

    public RewardDAO() {
    }
    
    public ArrayList<RewardDTO> searchRewardLikeByName (String name) throws Exception{
        ArrayList<RewardDTO> result = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select rewardId , rewardName , Rewardvalue from tbl_Rewards Where rewardname LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+name+"%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {                
                result.add(new RewardDTO(rs.getString("rewardid"), rs.getString("rewardname"), rs.getFloat("Rewardvalue")));
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public RewardDTO getInfoRewardById (String id) throws Exception{
        RewardDTO dto = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select rewardname , Rewardvalue , Status from tbl_Rewards Where Rewardid = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                dto = new RewardDTO(id, rs.getString("rewardname"), rs.getFloat("Rewardvalue"),rs.getBoolean("Status"));
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean insertReward (RewardDTO dto) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "insert into tbl_Rewards(rewardid , rewardname , Rewardvalue,Status) values (?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRewardId());
            preStm.setString(2, dto.getRewardName());
            preStm.setFloat(3, dto.getValue());
            preStm.setString(4, "True");
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean updateReward (RewardDTO dto) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Update tbl_Rewards set rewardname = ? , Rewardvalue = ? , status = ? Where rewardid = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRewardName());
            preStm.setFloat(2, dto.getValue());
            if(dto.isStatus()) preStm.setString(3, "True");
            else preStm.setString(3, "False");
            preStm.setString(4, dto.getRewardId());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean deleteRewardById (String id) throws Exception{
        boolean check = false;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Delete from tbl_Rewards Where rewardid = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    public ArrayList<String> getAllIdOfReward () throws Exception{
        ArrayList<String> result = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "Select RewardID From tbl_Rewards where status = 'true'";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {                
                result.add(rs.getString("RewardID"));
            }
        }finally{
            closeConnection();
        }
        return result;
    }
}
