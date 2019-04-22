<%-- 
    Document   : manageReward
    Created on : Oct 22, 2018, 10:24:24 AM
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">assignment</i>
                            </div>
                            <h3 class="card-title">List of Reward</h3>
                            <form action="RewardMainController" method="POST">
                                <input type="text" name="txtRewardSearchName" value="${param.txtRewardSearchName}"/>
                                <input type="submit" name="action" value="Search Reward"/>
                            </form>
                            <div class="card-content">
                                <div class="table-responsive">
                                    <font color="red">${requestScope.ERROR}</font>
                                    <c:if test="${requestScope.INFO != null}">
                                        <c:if test="${not empty requestScope.INFO}" var="data">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th class="text-center">1</th>
                                                <th>Reward's Id</th>
                                                <th>Reward's Name</th>
                                                <th class="text-right">Value</th>
                                                <th class="text-right">Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                                            <tr>
                                                <td class="text-center">${counter.count}</td>
                                                <td>${dto.rewardId}</td>
                                                <td>${dto.rewardName}</td>
                                                <td class="text-right">${dto.value}đ</td>
                                                <td class="td-actions text-right">
                                                    <c:url value="RewardMainController" var="Edit">
                                                        <c:param name="action" value="Edit"/>
                                                        <c:param name="txtRewardSearchName" value="${param.txtRewardSearchName}"/>
                                                        <c:param name="rewardId" value="${dto.rewardId}"/>
                                                    </c:url>
                                                    <a href="${Edit}">
                                                    <button title="" class="btn btn-success btn-round" type="button" rel="tooltip" data-original-title="">
                                                        <i class="material-icons">edit</i>
                                                    </button>
                                                    </a>
                                                    <c:url value="RewardMainController" var="Delete">
                                                        <c:param name="action" value="Delete"/>
                                                        <c:param name="txtRewardSearchName" value="${param.txtRewardSearchName}"/>
                                                        <c:param name="rewardId" value="${dto.rewardId}"/>
                                                    </c:url>
                                                    <a href="${Delete}">
                                                    <button title="" class="btn btn-danger btn-round" type="button" rel="tooltip" data-original-title="">
                                                        <i class="material-icons">close</i>
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
                                    <div class="col-md-4 col-sm-4">
                                        <c:url value="addNewReward.jsp" var="Insert">
                                            <c:param name="txtRewardSearchName" value="${param.txtRewardSearchName}"/>
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
