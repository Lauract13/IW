<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>BookingFloor UCM</title>

    <!-- Bootstrap -->
    <link href="${s}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${s}/css/starter-template.css" rel="stylesheet">
</head>
 	
<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://cijulenlinea.ucr.ac.cr/dev-users/">
                <img src="http://placehold.it/200x50&text=LOGO" alt="LOGO">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                </a>
            </li>            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li><a href="#"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#"><i class="fa fa-fw fa-search"></i>Servicios</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-fw fa-star"></i>Reservas</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
                	<h1>Mis reservas</h1>
                	<div class="booking">
                		<div>
                   			<img src="https://www.ucm.es/data/cont/media/www/pag-2258/_DSC1963c.jpg" alt="Voleibol" class="img-thumbnail">
                   		</div>
                   		<div>
                   			<a href="#">Pista Voleibol - Paraninfo Sur</a>
                   			<div class="booking">
                   				<p>12/04/2018</p>
                   				<p>17:30-19:30</p>
                   			</div>
                   		</div>
                	</div>
                	
                	<div class="booking">
                		<div>
                   			<img src="https://www.ucm.es/data/cont/media/www/pag-2258/Pista%202.jpg" alt="Padel iluminada" class="img-thumbnail">
                   		</div>
                   		<div>
                   			<a href="#">Pista Padel iluminada - Paraninfo Sur</a>
                   			<div class="booking">
                   				<p>03/04/2018</p>
                   				<p>17:30-19:30</p>
                   			</div>
                   		</div>
                	</div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->
 	
 	
 	
 	
<!-- <%@ include file="../jspf/authinfo.jspf"%>	-->

<%@ include file="../jspf/footer.jspf"%>
