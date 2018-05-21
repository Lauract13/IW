<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
		<h3>Pistas disponibles</h3>
		<ul class="list-group pistas">
			<li class="list-group-item">
				<img class="img-pista" src="${s}/img/rugby.jpg"/><span class="titulo-pista">Pista rugby, 12€/hora</span><a href="/court/perfil-pista" class="link-masinfo-pista"><span class="glyphicon glyphicon-zoom-in"></span> Más info</a>
				<p class="descripcion-pista">Mauris a lobortis augue, vel hendrerit mi. Sed tincidunt libero et diam pellentesque, vel lobortis augue porta.</p>
			</li>
			<li class="list-group-item">
				<img class="img-pista" src="${s}/img/tenis.jpg"/><span class="titulo-pista">Pista tenis, 10€/hora</span><a href="/court/perfil-pista" class="link-masinfo-pista"><span class="glyphicon glyphicon-zoom-in"></span> Más info</a>
				<p class="descripcion-pista">Mauris a lobortis augue, vel hendrerit mi. Sed tincidunt libero et diam pellentesque, vel lobortis augue porta. Fusce dictum purus vitae pulvinar euismod.</p>
			</li>
		</ul>
</div>

<%@ include file="../jspf/footer.jspf"%>