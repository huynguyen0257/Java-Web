<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="http://demos.creative-tim.com/material-dashboard-pro/assets/img/apple-icon.png" />
        <link rel="icon" type="image/png" href="http://demos.creative-tim.com/material-dashboard-pro/assets/img/favicon.png" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <!-- Canonical SEO -->
        <link rel="canonical" href="https://www.creative-tim.com/product/material-dashboard-pro" />
        <!--  Social tags      -->
        <meta name="keywords" content="material dashboard, bootstrap material admin, bootstrap material dashboard, material design admin, material design, creative tim, html dashboard, html css dashboard, web dashboard, freebie, free bootstrap dashboard, css3 dashboard, bootstrap admin, bootstrap dashboard, frontend, responsive bootstrap dashboard, premiu material design admin">
        <meta name="description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
        <!-- Schema.org markup for Google+ -->
        <meta itemprop="name" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template">
        <meta itemprop="description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
        <meta itemprop="image" content="http://s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg">
        <!-- Twitter Card data -->
        <meta name="twitter:card" content="summary_large_image">
        <meta name="twitter:site" content="@creativetim">
        <meta name="twitter:title" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template">
        <meta name="twitter:description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
        <meta name="twitter:creator" content="@creativetim">
        <meta name="twitter:image" content="http://s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg">
        <!-- Open Graph data -->
        <meta property="fb:app_id" content="655968634437471">
        <meta property="og:title" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template" />
        <meta property="og:type" content="article" />
        <meta property="og:url" content="http://www.creative-tim.com/product/material-dashboard-pro" />
        <meta property="og:image" content="http://s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg" />
        <meta property="og:description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design." />
        <meta property="og:site_name" content="Creative Tim" />
        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <!--  Material Dashboard CSS    -->
        <link href="assets/css/material-dashboard.css" rel="stylesheet" />
        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />
        <!--     Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons" />
    </head>

    <body>
        <div class="wrapper">
            <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="assets/img/sidebar-1.jpg">
                <!--
            Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
            Tip 2: you can also add an image using data-image tag
            Tip 3: you can change the color of the sidebar with data-background-color="white | black"
                -->
                <div class="logo">
                    <a href="http://www.creative-tim.com" class="simple-text">
                        Creative Tim
                    </a>
                </div>
                <div class="logo logo-mini">
                    <a href="http://www.creative-tim.com" class="simple-text">
                        Ct
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <div class="user">
                        <div class="photo">
                            <img src="assets/img/faces/avatar.jpg" />
                        </div>
                        <div class="info">
                            <a data-toggle="collapse" href="dashboard.html#collapseExample" class="collapsed">
                                ${sessionScope.USER.fullname}
                                <b class="caret"></b>
                            </a>
                            <div class="collapse" id="collapseExample">
                                <ul class="nav">
                                    <li>
                                        <c:url value="LeftMainController" var="Profile">
                                            <c:param name="action" value="Profile"/>
                                            <c:param name="editProfileInUserSide" value="Userhome"/>
                                        </c:url>
                                        <a href="${Profile}">My Profile</a>
                                    </li>
                                    <c:url value="LeftMainController" var="Logout">
                                        <c:param name="action" value="Logout"/>
                                    </c:url>
                                    <li>
                                        <a href="${Logout}">Logout</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>