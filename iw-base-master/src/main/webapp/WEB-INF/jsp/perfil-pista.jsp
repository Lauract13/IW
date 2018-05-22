<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="perfil">
    		<div class="cabecera-perfil"><img src="${s}/img/futbol.jpg" class="foto-perfil"/><span class="nombre-perfil">Pista futbol, 20€/hora</span></div>
    		<div class="info-pista">
    			<h4>Descripción</h4>
		  		<p>Texto de descripción...</p>
		  		<h4>Info</h4>
		  		<p>dirección · 666777888</p>
	  		</div>
		  	<div class="div-modificar"><input type="button" id="datepicker" class="btn btn-modificar" value="Reservar"/></div>
		</div>
</div>

<%@ include file="../jspf/footer.jspf"%>