<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="crear-pista"><a href="/court/crear-pista" class="link-crear-pista"><span class="glyphicon glyphicon-plus"></span> CREAR PISTA</a></div>
		<ul class="list-group pistas">
			<c:forEach items="${list}" var="court">
	         	<li class="list-group-item">
	         		<img class="img-pista" src="${s}/img/futbol.jpg"/>
	         		<span class="titulo-pista">${court.name}, ${court.price}€/hora</span>
	         		<p class="descripcion-pista">${court.description}</p>
					<p>${court.dir} · ${court.phone}</p>
					<a href="/court/editar-pista/${court.id}" class="link-editar-pista"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
					<a href="/court/deleteCourt/${court.id}" class="link-borrar-pista"><span class="glyphicon glyphicon-remove"></span> Borrar</a>
				</li>
	      	</c:forEach>
		</ul>
		
</div>

<%@ include file="../jspf/footer.jspf"%>