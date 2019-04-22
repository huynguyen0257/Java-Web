<%-- 
    Document   : editUser
    Created on : Oct 13, 2018, 3:46:16 PM
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
        <c:if test="${sessionScope.ROLE == null}" var="checkRole">
            <c:url value="LogoutController" var="failRole">
                
            </c:url>
            <c:redirect url="${failRole}"/>
        </c:if>
        <c:if test="${param.editProfileInUserSide != null}">
            <%@include file="leftUser.jsp" %>
        </c:if>
        <c:if test="${param.editProfileInUserSide == null}">
            <%@include file="left.jsp" %>
        </c:if>
        <%@include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <form id="TypeValidation" class="form-horizontal" action="LeftMainController" method="POST">
                                <div class="card-header card-header-text" data-background-color="rose">
                                    <h4 class="card-title">User's Information and Edit</h4>
                                </div>
                                <div class="card-content">
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">UserID</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="text" name="txtID" readonly="true" value="${requestScope.DTO.id}${param.txtID}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Username</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="text" name="txtUsername" value="${requestScope.DTO.username}${param.txtUsername}"/>
                                                <font color="red">${requestScope.INVALID.usernameError}</font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Fullname</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="text" name="txtFullname" value="${requestScope.DTO.fullname}${param.txtFullname}"/> 
                                                <font color="red">${requestScope.INVALID.fullnameError}</font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Password</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="password" name="txtPassword"/> 
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Gender</label>
                                        <div class="col-sm-7">
                                            <div class="form-group is-empty">
                                                <div class="radio">
                                                    <label>
                                                        <input name="genderCheckbox" type="radio" value="Male"
                                                               <c:if test="${requestScope.DTO.gender == true || requestScope.gender == true}" >
                                                                   checked="true"
                                                               </c:if>
                                                               ><span class="circle"></span><span class="check"></span> Male
                                                    </label>
                                                </div>
                                                <div class="radio">
                                                    <label>
                                                        <input name="genderCheckbox" type="radio" value="Female"
                                                               <c:if test="${requestScope.DTO.gender == false || requestScope.gender == false}">
                                                                   checked="true"
                                                               </c:if>
                                                               ><span class="circle"></span><span class="check"></span> Female
                                                    </label>
                                                </div>
                                                <font color="red">${requestScope.INVALID.genderError}</font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Birthday</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control datepicker" type="date" name="txtBirthday" value="${requestScope.DTO.birthday}${param.txtBirthday}"/>
                                                <font color="red">${requestScope.INVALID.birthdayError}</font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Role</label>
                                        <div class="col-sm-7">
                                            <div class="form-group is-empty">
                                                <div class="radio">
                                                    <label>
                                                        <input name="roleCheckbox" type="radio" value="Admin"
                                                               <c:if test="${requestScope.DTO.role == 'admin' || requestScope.role == true}" >
                                                                   checked="true"
                                                               </c:if>
                                                               ><span class="circle"></span><span class="check"></span> Admin
                                                    </label>
                                                </div>
                                                <div class="radio">
                                                    <label>
                                                        <input name="roleCheckbox" type="radio" value="User"
                                                               <c:if test="${requestScope.DTO.role == 'user' || requestScope.role == false}">
                                                                   checked="true"
                                                               </c:if>
                                                               ><span class="circle"></span><span class="check"></span> User
                                                    </label>
                                                </div>
                                                <font color="red">${requestScope.INVALID.roleError}</font>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer text-center">
                                    <input type="hidden" name="editProfileInUserSide" value="${param.editProfileInUserSide}"/>
                                    <button type="submit" class="btn btn-rose btn-fill" name="action" value="Update Profile">Update Profile</button>
                                    <button type="submit" class="btn btn-rose btn-fill" name="action" value="Back To Manage User">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
