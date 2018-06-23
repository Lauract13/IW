<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="crear-pista"><a href="/court/crear-pista" class="link-crear-pista"><span class="glyphicon glyphicon-plus"></span> CREAR PISTA</a></div>
    	<c:if test="${empty list}"><p>Aún no hay ninguna pista creada.</p></c:if>
		<ul class="list-group pistas">
			<c:forEach items="${list}" var="court">
	         	<li class="list-group-item">
	         		<img class="img-pista" src="/court/photo/${court.id}"/>
	         		<span class="titulo-pista">${court.name}, ${court.price}€/hora</span>
	         		<a href="/reserve/reserva/${court.id}" class="link-masinfo-pista">Reservar</a>
	         		<p class="descripcion-pista">${court.description}</p>
					<p>${court.dir} · ${court.phone}</p>
					<form method="post" action="/court/deleteCourt/${court.id}" id="borrar-pista-form">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<a href="/court/editar-pista/${court.id}" class="link-editar-pista"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
						<input type="hidden" value="${court.id}" id="id-pista" name="id-pista">
						<input type="submit" value="Borrar" class="baja">
					</form>
				</li>
	      	</c:forEach>
		</ul>
		
</div>

<%@ include file="../jspf/footer.jspf"%>