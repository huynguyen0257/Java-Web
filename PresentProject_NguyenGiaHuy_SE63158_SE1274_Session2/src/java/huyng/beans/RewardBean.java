/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.beans;

import huyng.daos.RewardDAO;
import huyng.dtos.RewardDTO;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Chuối
 */
public class RewardBean implements Serializable{
    private String searchName, rewardId;
    private RewardDTO dto ;

    public RewardBean() {
    }

    public RewardDTO getDto() {
        return dto;
    }

    public void setDto(RewardDTO dto) {
        this.dto = dto;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
    public ArrayList<RewardDTO> searchRewardLikeByName() throws Exception{
        RewardDAO dao = new RewardDAO();
        return dao.searchRewardLikeByName(searchName);
    }
    public void getInfoRewardById () throws Exception{
        RewardDAO dao = new RewardDAO();
        dto = dao.getInfoRewardById(rewardId);
    }
    public boolean updateReward () throws Exception{
        RewardDAO dao = new RewardDAO();
        return dao.updateReward(dto);
    }
    public boolean deleteRewardById() throws Exception{
        RewardDAO dao = new RewardDAO();
        return dao.deleteRewardById(rewardId);
    }
    public boolean insertReward() throws Exception{
        RewardDAO dao = new RewardDAO();
        return dao.insertReward(dto);
    }
    public ArrayList<String> getAllIdOfReward() throws Exception{
        RewardDAO dao = new RewardDAO();
        return dao.getAllIdOfReward();
    }
}
