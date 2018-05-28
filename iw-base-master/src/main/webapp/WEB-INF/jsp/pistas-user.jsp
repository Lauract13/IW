<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
		<h3>Pistas disponibles</h3>
		<ul class="list-group pistas">
			<c:forEach items="${list}" var="court">
	         	<li class="list-group-item">
	         		<img class="img-pista" src="${s}/img/futbol.jpg"/>
	         		<span class="titulo-pista">${court.name}, ${court.price}€/hora</span>
	         		<a href="/court/perfil-pista/${court.id}" class="link-masinfo-pista"><span class="glyphicon glyphicon-zoom-in"></span> Más info</a>
	         		<p class="descripcion-pista">${court.description}</p>				
				</li>
	      	</c:forEach>
		</ul>
</div>

<%@ include file="../jspf/footer.jspf"%>