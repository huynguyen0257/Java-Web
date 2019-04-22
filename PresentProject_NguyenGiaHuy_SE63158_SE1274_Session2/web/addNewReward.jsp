<%-- 
    Document   : addNewReward
    Created on : Oct 23, 2018, 10:11:12 AM
    Author     : Chuối
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">contacts</i>
                            </div>
                            <div class="card-content">
                                <h4 class="card-title">Edit Reward's Info</h4>
                                <form class="form-horizontal" action="RewardMainController" method="POST">
                                    <div class="row">
                                        <label class="col-md-3 label-on-left">Reward's Id :</label><font color="red">${requestScope.INVALID.rewardIdError}</font>
                                        <div class="col-md-9">
                                            <div class="form-group label-floating is-empty">
                                                <label class="control-label"></label>
                                                <input name="txtRewardId"class="form-control" type="text" value="${param.txtRewardId}">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-md-3 label-on-left">Reward's Name :</label><font color="red">${requestScope.INVALID.rewardNameError}</font>
                                        <div class="col-md-9">
                                            <div class="form-group label-floating is-empty">
                                                <label class="control-label"></label>
                                                <input name="txtRewardName"class="form-control" type="text" value="${param.txtRewardName}">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-md-3 label-on-left">Reward's Value :</label><font color="red">${requestScope.INVALID.rewardValueError}</font>
                                        <div class="col-md-9">
                                            <div class="form-group label-floating is-empty">
                                                <label class="control-label"></label>
                                                <input name="txtRewardValue"class="form-control" type="text" value="${param.txtRewardValue}">
                                                <span class="material-input"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-md-3"></label>
                                        <div class="col-md-9">
                                            <div class="form-group form-button">
                                                <input type="hidden" name="txtRewardSearchName" value="${param.txtRewardSearchName}"/>
                                                <button type="submit" class="btn btn-rose btn-fill" name="action" value="Insert">Insert</button>
                                                <button type="submit" class="btn btn-rose btn-fill" name="action" value="Back To Manage Reward">Cancel</button>
                                            </div>
                                        </div>
                                    </div>
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
