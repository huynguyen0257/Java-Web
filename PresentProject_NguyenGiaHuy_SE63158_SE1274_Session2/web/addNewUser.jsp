<%-- 
    Document   : addNewUser
    Created on : Oct 13, 2018, 8:46:07 PM
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
                            <form id="TypeValidation" class="form-horizontal" action="MainController" method="POST">
                                <div class="card-header card-header-text" data-background-color="rose">
                                    <h4 class="card-title">Form add new User to FBK</h4>
                                </div>
                                <div class="card-content">
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Username</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="text" name="txtUsername" value="${param.txtUsername}"/>
                                                <font color="red">${requestScope.INVALID.usernameError}</font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Password</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="password" name="txtPassword" value="${param.txtPassword}"/>
                                                <font color="red">${requestScope.INVALID.passwordError}</font>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label class="col-sm-2 label-on-left">Fullname</label>
                                        <div class="col-sm-7">
                                            <div class="form-group label-floating">
                                                <label class="control-label"></label>
                                                <input class="form-control" type="text" name="txtFullname" value="${param.txtFullname}"/> 
                                                <font color="red">${requestScope.INVALID.fullnameError}</font>
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
                                                               <c:if test="${requestScope.gender == true}" >
                                                                   checked="true"
                                                               </c:if>
                                                               ><span class="circle"></span><span class="check"></span> Male
                                                    </label>
                                                </div>
                                                <div class="radio">
                                                    <label>
                                                        <input name="genderCheckbox" type="radio" value="Female"
                                                               <c:if test="${requestScope.gender == false}">
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
                                                <input class="form-control datepicker" type="date" name="txtBirthday" value="${param.txtBirthday}"/>
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
                                                               <c:if test="${requestScope.role == true}" >
                                                                   checked="true"
                                                               </c:if>
                                                               ><span class="circle"></span><span class="check"></span> Admin
                                                    </label>
                                                </div>
                                                <div class="radio">
                                                    <label>
                                                        <input name="roleCheckbox" type="radio" value="User"
                                                               <c:if test="${requestScope.role == false}">
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
                                    <input type="hidden" name="txtSearchUsername" value="${param.txtSearchUsername}"/>
                                    <button type="submit" class="btn btn-rose btn-fill" name="action" value="Add New User">Add</button>
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
