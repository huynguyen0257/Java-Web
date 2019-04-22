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
        <c:if test="${sessionScope.ROLE == null || sessionScope.ROLE=='admin' }" var="checkRole">
            <c:url value="LogoutController" var="failRole">
                
            </c:url>
            <c:redirect url="${failRole}"/>
        </c:if>
        <%@include file="leftUser.jsp" %>
        <%@include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">assignment</i>
                            </div>
                            <h3 class="card-title">A list of ongoing Events</h3>
                            <form action="UserHomeMainController" method="POST">
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
                                                                <c:url value="UserHomeMainController" var="Edit">
                                                                    <c:param name="txtEventIdEdit" value="${dto.eventId}"/>
                                                                    <c:param value="${param.txtEventSearchName}" name="txtEventSearchName"/>
                                                                    <c:param name="action" value="Edit"/>
                                                                </c:url>
                                                                <a href="${Edit}">
                                                                    <button type="button" rel="tooltip" class="btn btn-info">
                                                                        <i class="material-icons">person</i>
                                                                    </button>
                                                                </a>
                                                                <c:url value="UserHomeMainController" var="Join">
                                                                    <c:param name="txtEventId" value="${dto.eventId}"/>
                                                                    <c:param value="${param.txtEventSearchName}" name="txtEventSearchName"/>
                                                                    <c:param name="action" value="Join"/>
                                                                </c:url>
                                                                <a href="${Join}">
                                                                    <button type="button" rel="tooltip" class="btn btn-success">
                                                                        <i class="material-icons">edit</i>
                                                                    </button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${data = false}">
                                            No result
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">assignment</i>
                            </div>
                            <h3 class="card-title">A list of Event that User Joined</h3>
                            <form action="UserHomeMainController" method="POST">
                                Event's name : <input type="text" name="txtJoinedEventSearchName">
                                <input type="submit" name="action" value="Search Event">
                            </form>
                            <div class="card-content">
                                <div class="table-responsive">
                                    <c:if test="${requestScope.INFOJOINEDEVENT != null}">
                                        <c:if test="${not empty requestScope.INFOJOINEDEVENT}" var="data">
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
                                                    <c:forEach items="${requestScope.INFOJOINEDEVENT}" var="dto" varStatus="counter">
                                                        <tr>
                                                            <td class="text-center">${counter.count}</td>
                                                            <td>${dto.eventId}</td>
                                                            <td>${dto.eventName}</td>
                                                            <td>${dto.fromDate}</td>
                                                            <td class="text-right">${dto.toDate}</td>
                                                            <td class="td-actions text-right">
                                                                <c:if test="${dto.statusOfUserGetReward == true}">
                                                                    <font color="green">You win this Event</font>
                                                                </c:if>
                                                                <c:if test="${dto.statusOfUserGetReward == false}">
                                                                    <c:url value="UserHomeMainController" var="Edit">
                                                                        <c:param name="txtEventIdEdit" value="${dto.eventId}"/>
                                                                        <c:param name="action" value="Edit"/>
                                                                        <c:param name="txtJoinedEventSearchName" value="${param.txtJoinedEventSearchName}"/>
                                                                        <c:param name="viewJoinEvent" value="view"/>
                                                                    </c:url>
                                                                    <a href="${Edit}">
                                                                        <button type="button" rel="tooltip" class="btn btn-info">
                                                                            <i class="material-icons">person</i>
                                                                        </button>
                                                                    </a>
                                                                    <c:url value="UserHomeMainController" var="UnJoin">
                                                                        <c:param name="txtEventId" value="${dto.eventId}"/>
                                                                        <c:param name="txtJoinedEventSearchName" value="${param.txtJoinedEventSearchName}"/>
                                                                        <c:param name="action" value="UnJoin"/>
                                                                    </c:url>
                                                                    <a href="${UnJoin}">
                                                                        <button type="button" rel="tooltip" class="btn btn-danger">
                                                                            <i class="material-icons">close</i>
                                                                        </button>
                                                                    </a>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${data = false}">
                                            No result
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
