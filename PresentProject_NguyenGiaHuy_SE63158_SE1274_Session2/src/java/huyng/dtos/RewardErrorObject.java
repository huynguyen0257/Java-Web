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
public class RewardErrorObject implements Serializable{
    private String rewardIdError , rewardNameError , rewardValueError;

    public RewardErrorObject() {
    }

    public String getRewardIdError() {
        return rewardIdError;
    }

    public void setRewardIdError(String rewardIdError) {
        this.rewardIdError = rewardIdError;
    }

    public String getRewardNameError() {
        return rewardNameError;
    }

    public void setRewardNameError(String rewardNameError) {
        this.rewardNameError = rewardNameError;
    }

    public String getRewardValueError() {
        return rewardValueError;
    }

    public void setRewardValueError(String rewardValueError) {
        this.rewardValueError = rewardValueError;
    }
    
}
