<%-- 
    Document   : editEvent
    Created on : Oct 19, 2018, 3:32:23 PM
    Author     : Chuối
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.ROLE == null || sessionScope.ROLE=='user'}" var="checkRole">
            <c:url value="LogoutController" var="failRole">
                
            </c:url>
            <c:redirect url="${failRole}"/>
        </c:if>
        <%@include file="left.jsp" %>
        <%@include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">perm_identity</i>
                            </div>
                            <div class="card-content">
                                <h4 class="card-title">New Event -
                                    <small class="category">Complete your event</small>
                                </h4>
                                <form action="EventMainController" method="POST">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group label-floating is-empty">
                                                <label>Event's ID</label><font color="red">${requestScope.INVALID.eventIdError}</font>
                                                <input class="form-control" type="text" value="${param.txtEventId}" name="txtEventId">
                                                <span class="material-input"></span></div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group label-floating is-empty">
                                                <label>Event's Name</label><font color="red">${requestScope.INVALID.eventNameError}</font>
                                                <input class="form-control" type="text" value="${param.txtEventName}" name="txtEventName">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group label-floating is-empty">
                                                <label>From Date</label><font color="red">${requestScope.INVALID.fromDateError}</font>
                                                <input class="form-control" type="date" value="${param.txtFromDate}" name="txtFromDate">
                                                <span class="material-input"></span></div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group label-floating is-empty">
                                                <label>To Date</label><font color="red">${requestScope.INVALID.toDateError}</font>
                                                <input class="form-control" type="date" value="${param.txtToDate}" name="txtToDate">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group label-floating is-empty">
                                                <label>Place</label><font color="red">${requestScope.INVALID.placeError}</font>
                                                <input class="form-control" type="text" value="${param.txtPlace}" name="txtPlace">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group label-floating is-empty">
                                                <label>Reward's Id :</label><font color="red">${requestScope.INVALID.rewardIdError}</font>
                                                <select name="listReward">
                                                    <c:if test="${not empty requestScope.LISTREWARD}" var="data">
                                                        <c:forEach items="${requestScope.LISTREWARD}" var="id">
                                                            <option value="${id}">${id}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${data == false}">
                                                        <option value="">Please Create new Reward</option>
                                                    </c:if>
                                                </select>
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Details</label><font color="red">${requestScope.INVALID.detailsError}</font>
                                                <div class="form-group label-floating is-empty">
                                                    <textarea class="form-control" rows="5" name="txtDetails">${param.txtDetails}</textarea>
                                                    <span class="material-input"></span></div>
                                            </div>
                                        </div>
                                    </div>
    <!--                                    <a href="${Update}"><button class="btn btn-rose pull-right" type="submit">Update Event</button></a>-->
                                    <div class="card-footer text-center">
                                        <input type="hidden" name="txtEventSearchName" value="${param.txtEventSearchName}"/>
                                        <input type="hidden" name="actionOnRewardGetAllListId" value="insert"/>
                                        <button type="submit" class="btn btn-rose btn-fill pull-right" name="action" value="Back To Manage Event">Cancel</button>
                                        <button type="submit" class="btn btn-rose btn-fill pull-right" name="action" value="Insert">Add</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
