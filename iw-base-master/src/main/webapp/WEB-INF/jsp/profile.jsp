<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="perfil">
    		<div class="cabecera-perfil"><img src="${s}/img/unknown-user.jpg" class="foto-perfil"/><span class="nombre-perfil">Pedro Morell Prats</span></div>
    		<div class="celda-perfil">
		  		<span class="entrada-perfil">e-mail: </span>
		  		<span>pedromorellprats@gmail.com</span>
	  		</div>
	  		<div class="celda-perfil">
		  		<span class="entrada-perfil">teléfono: </span>
		  		<span>666777888</span>
		  	</div>
		  	<div class="celda-perfil">
		  		<span class="entrada-perfil">dirección: </span>
		  		<span>Calle ejemplo, 1, 1ºA</span>
		  	</div>
		  	<div class="div-modificar"><a href="/perfil" class="btn btn-modificar">Modificar perfil</a></div>
		</div>
</div>

<%@ include file="../jspf/footer.jspf"%>