/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyng.beans;

import huyng.daos.EventDAO;
import huyng.dtos.EventDTO;
import huyng.dtos.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Chuối
 */
public class EventBean implements Serializable {

    private String txtEventSearchName, txtEventId, rewardId, curRewardId;
    int userId;
    private EventDTO dto;

    public EventBean() {
    }

    public EventDTO getDto() {
        return dto;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getCurRewardId() {
        return curRewardId;
    }

    public void setCurRewardId(String curRewardId) {
        this.curRewardId = curRewardId;
    }

    public void setDto(EventDTO dto) {
        this.dto = dto;
    }

    public void setTxtEventId(String txtEventId) {
        this.txtEventId = txtEventId;
    }

    public void setTxtEventSearchName(String txtEventSearchName) {
        this.txtEventSearchName = txtEventSearchName;
    }

    public ArrayList<EventDTO> searchEventLikeByName() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.searchEventLikeByName(txtEventSearchName);
    }
    public ArrayList<EventDTO> searchEventLikeByNameWithAvailableStatus() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.searchEventLikeByNameWithAvailableStatus(txtEventSearchName);
    }

    public void getInfoEventById() throws Exception {
        EventDAO dao = new EventDAO();
        dto = dao.getInfoEventById(txtEventId);
    }

    public boolean updateEvent() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.updateEvent(dto);
    }

    public boolean updateEventWithRewardId() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.updateEventWithRewardId(dto, curRewardId);
    }

    public boolean insertEvent() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.insertNewEvent(dto);
    }

    public boolean deleteEventById() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.deleteEvent(txtEventId, rewardId);
    }

    public ArrayList<String> getAllEventOfUserJoined() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.getAllEventOfUserJoined(userId);
    }

    public ArrayList<EventDTO> getAllJoinedEventOfUser() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.getAllJoinedEventOfUser(userId, txtEventSearchName);
    }

    public boolean unjoinEvent() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.unjoinEvent(txtEventId, userId);
    }

    public ArrayList<UserDTO> getAllUserInEvent() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.getAllUserInEvent(txtEventId);
    }

    public boolean getRewardForUserAndCloseEvent() throws Exception {
        EventDAO dao = new EventDAO();
        return dao.getRewardForUserAndCloseEvent(txtEventId, userId, curRewardId);

    }
    public boolean deleteUserFromEvent() throws Exception{
        EventDAO dao = new EventDAO();
        return dao.deleteUserFromEvent(txtEventId, userId);
    }
    public boolean checkRewardForUserInEvent() throws Exception{
        EventDAO dao = new EventDAO();
        return dao.checkRewardForUserInEvent(txtEventId, userId);
    }
}
