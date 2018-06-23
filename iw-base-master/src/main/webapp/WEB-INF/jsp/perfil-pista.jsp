<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="perfil">
    		<div class="cabecera-perfil"><img src="/court/photo/${court.id}" class="foto-perfil"/><span class="nombre-perfil">${court.name}, ${court.price}€/hora</span></div>
    		<div class="info-pista">
    			<h4>Descripción</h4>
		  		<p>${court.description}</p>
		  		<h4>Info</h4>
		  		<p>${court.dir} · ${court.phone}</p>
		  		<h4>Extras</h4>
		  		<p>${court.extras}</p>
	  		</div>
		  	<div class="div-modificar"><a href="/reserve/reserva/${court.id}" class="btn btn-modificar">Reservar</a></div>
		</div>
</div>

<%@ include file="../jspf/footer.jspf"%>