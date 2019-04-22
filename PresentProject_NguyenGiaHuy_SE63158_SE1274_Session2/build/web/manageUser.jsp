<%-- 
    Document   : manageUser
    Created on : Oct 12, 2018, 6:17:37 PM
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">assignment</i>
                            </div>
                            <h3 class="card-title">User Manager</h3>
                            <form action="MainController" method="POST">
                                User's Fullname : <input type="text" name="txtSearchUsername">
                                <input type="submit" name="action" value="Search User">
                            </form>
                            <div class="card-content">
                                <div class="table-responsive">
                                    <c:if test="${requestScope.INFO != null}">
                                        <c:if test="${not empty requestScope.INFO}" var="data">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">Count</th>
                                                        <th>User's ID</th>
                                                        <th>Fullname</th>
                                                        <th>Gender</th>
                                                        <th class="text-right">Edit</th>
                                                        <th class="text-right">Delete</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                                                        <tr>
                                                            <td class="text-center">${counter.count}</td>
                                                            <td>${dto.id}</td>
                                                            <td>${dto.fullname}</td>
                                                            <c:if test="${dto.gender == true}">
                                                                <td>Male</td>
                                                            </c:if>
                                                            <c:if test="${dto.gender == false}">
                                                                <td>Female</td>
                                                            </c:if>
|                                                            <td class="text-right">
                                                                <c:url value="MainController" var="Edit">
                                                                    <c:param name="txtSearchUsername" value="${param.txtSearchUsername}"/>
                                                                    <c:param name="txtSearchId" value="${dto.id}"/>
                                                                    <c:param name="action" value="Edit User"/>
                                                                </c:url>
                                                                <a href="${Edit}">Edit</a>
                                                            </td>
                                                            <td class="td-actions text-right">
                                                                <form action="MainController" method="POST">
                                                                    <input type="submit" value="Delete"/>
                                                                    <input type="hidden" name="action" value="Delete User"/>
                                                                    <input type="hidden" name="txtSearchUsername" value="${param.txtSearchUsername}"/>
                                                                    <input type="hidden" value="${dto.id}" name="txtID"/>
                                                                </form>
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
                                        <c:url value="addNewUser.jsp" var="Insert">
                                            <c:param value="${param.txtEventSearchName}" name="txtEventSearchName"/>
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
