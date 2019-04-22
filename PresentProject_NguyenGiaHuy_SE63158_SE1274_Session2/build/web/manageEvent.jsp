<%-- 
    Document   : adminHome
    Created on : Oct 12, 2018, 3:06:33 PM
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
            
            <c:redirect url="LogoutController"/>
        </c:if>
        <%@include file="left.jsp" %>
        <%@include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">assignment</i>
                            </div>
                            <h3 class="card-title">Event Manager</h3>
                            <form action="EventMainController" method="POST">
                                Event's name : <input type="text" name="txtEventSearchName">
                                <input type="submit" name="action" value="Search">
                            </form>
                            <div class="card-content">
                                <div class="table-responsive">
                                    <c:if test="${requestScope.INFO != null}">
                                        <c:if test="${not empty requestScope.INFO}" var="data">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">Count</th>
                                                        <th>Event's ID</th>
                                                        <th>Event's Name</th>
                                                        <th>From Date</th>
                                                        <th class="text-right">To Date</th>
                                                        <th class="text-right">Actions</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                                                        <tr>
                                                            <td class="text-center">${counter.count}</td>
                                                            <td>${dto.eventId}</td>
                                                            <td>${dto.eventName}</td>
                                                            <td>${dto.fromDate}</td>
                                                            <td class="text-right">${dto.toDate}</td>
                                                            <td class="td-actions text-right">
                                                                <c:url value="RewardGetAllListId" var="Edit">
                                                                    <c:param name="txtEventSearchName" value="${param.txtEventSearchName}"/>
                                                                    <c:param name="txtEventIdEdit" value="${dto.eventId}"/>
                                                                    <c:param name="actionOnRewardGetAllListId" value="Edit"/>
                                                                </c:url>
                                                                <a href="${Edit}">
                                                                    <button type="button" rel="tooltip" class="btn btn-success">
                                                                        <i class="material-icons">edit</i>
                                                                    </button>
                                                                </a>
                                                                <c:url value="EventMainController" var="Delete">
                                                                    <c:param name="txtEventId" value="${dto.eventId}"/>
                                                                    <c:param name="txtRewardId" value="${dto.rewardId}"/>
                                                                    <c:param value="${param.txtEventSearchName}" name="txtEventSearchName"/>
                                                                    <c:param name="action" value="Delete"/>
                                                                </c:url>
                                                                <a href="${Delete}">
                                                                    <button type="button" rel="tooltip" class="btn btn-danger">
                                                                        <i class="material-icons">close</i>
                                                                    </button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${data == false}">
                                            No result
                                        </c:if>
                                    </c:if>
                                    <div class="col-md-4 col-sm-4">
                                        <c:url value="RewardGetAllListId" var="Insert">
                                            <c:param value="${param.txtEventSearchName}" name="txtEventSearchName"/>
                                            <c:param name="actionOnRewardGetAllListId" value="insert"/>
                                        </c:url>
                                        <a href="${Insert}">
                                            <button class="btn btn-just-icon btn-round btn-dribbble">Add New
                                                <div class="ripple-container"></div></button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file="footer.jsp" %>
                    </body>
                    </html>
