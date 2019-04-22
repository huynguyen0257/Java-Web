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
public class EventErrorObject implements Serializable{
    private String eventIdError , eventNameError , placeError , detailsError , rewardIdError , fromDateError , toDateError;

    public EventErrorObject() {
    }

    public String getEventIdError() {
        return eventIdError;
    }

    public void setEventIdError(String eventIdError) {
        this.eventIdError = eventIdError;
    }

    public String getEventNameError() {
        return eventNameError;
    }

    public void setEventNameError(String eventNameError) {
        this.eventNameError = eventNameError;
    }

    public String getPlaceError() {
        return placeError;
    }

    public void setPlaceError(String placeError) {
        this.placeError = placeError;
    }

    public String getDetailsError() {
        return detailsError;
    }

    public void setDetailsError(String detailsError) {
        this.detailsError = detailsError;
    }

    public String getRewardIdError() {
        return rewardIdError;
    }

    public void setRewardIdError(String rewardIdError) {
        this.rewardIdError = rewardIdError;
    }

    public String getFromDateError() {
        return fromDateError;
    }

    public void setFromDateError(String fromDateError) {
        this.fromDateError = fromDateError;
    }

    public String getToDateError() {
        return toDateError;
    }

    public void setToDateError(String toDateError) {
        this.toDateError = toDateError;
    }
    
}
