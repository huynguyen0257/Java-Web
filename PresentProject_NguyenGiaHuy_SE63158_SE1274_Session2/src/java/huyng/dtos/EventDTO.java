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
public class EventDTO implements Serializable{
    private String eventId , eventName , place , details , rewardId;
    private Date fromDate , toDate;
    private boolean status , statusOfUserGetReward;

    public EventDTO() {
    }

    public EventDTO(String eventId, String eventName, String Place, String Details, String rewardId, Date fromDate, Date toDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.place = Place;
        this.details = Details;
        this.rewardId = rewardId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public EventDTO(String eventId, String eventName, String place, String details, Date fromDate, Date toDate, boolean status) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.place = place;
        this.details = details;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
    }

    public EventDTO(String eventId, String eventName, String place, String details, String rewardId, Date fromDate, Date toDate, boolean status) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.place = place;
        this.details = details;
        this.rewardId = rewardId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
    }
    

    public EventDTO(String eventId, String eventName, Date fromDate, Date toDate , String rewardId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.rewardId = rewardId;
    }

    public String getEventId() {
        return eventId;
    }

    public boolean isStatusOfUserGetReward() {
        return statusOfUserGetReward;
    }

    public void setStatusOfUserGetReward(boolean statusOfUserGetReward) {
        this.statusOfUserGetReward = statusOfUserGetReward;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String Place) {
        this.place = Place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String Details) {
        this.details = Details;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
    @Override
    public String toString() {
        return "EventDTO{" + "eventId=" + eventId + ", eventName=" + eventName + ", place=" + place + ", details=" + details + ", rewardId=" + rewardId + ", fromDate=" + fromDate + ", toDate=" + toDate + '}';
    }
}
