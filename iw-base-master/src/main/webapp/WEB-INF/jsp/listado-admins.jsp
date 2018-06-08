<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="crear-pista"><a href="#" class="link-crear-pista"><span class="glyphicon glyphicon-plus"></span> CREAR ADMIN</a></div>
    	<p>Aún no hay ningún administrador creado.</p>
		<ul class="list-group pistas">
	         	<li class="list-group-item">
	         		<span class="titulo-pista">Pepito</span>
	         		<p class="descripcion-pista">45371696X</p>
					<a href="#" class="link-borrar-pista"><span class="glyphicon glyphicon-remove"></span> Dar de baja</a>
				</li>
				<li class="list-group-item">
	         		<span class="titulo-pista">Pepito</span>
	         		<p class="descripcion-pista">45371696X</p>
					<a href="#" class="link-borrar-pista"><span class="glyphicon glyphicon-remove"></span> Dar de baja</a>
				</li>
		</ul>
		
</div>

<%@ include file="../jspf/footer.jspf"%>