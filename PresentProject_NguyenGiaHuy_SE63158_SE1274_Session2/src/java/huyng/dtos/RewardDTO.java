/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.dtos;

import java.io.Serializable;

/**
 *
 * @author Chuối
 */
public class RewardDTO implements Serializable{
    private String rewardId , rewardName;
    private float value;
    private boolean status;

    public RewardDTO() {
    }

    public RewardDTO(String rewardId, String rewardName, float value, boolean status) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.value = value;
        this.status = status;
    }

    public RewardDTO(String rewardId, String rewardName, float value) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.value = value;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RewardDTO{" + "rewardId=" + rewardId + ", rewardName=" + rewardName + ", value=" + value + ", status=" + status + '}';
    }
}
