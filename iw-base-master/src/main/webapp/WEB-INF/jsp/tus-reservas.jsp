<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
		<h3>Tus reservas</h3>
		<ul class="list-group pistas">
			<li class="list-group-item">
				<img class="img-pista" src="${s}/img/rugby.jpg"/><span class="titulo-pista">Pista rugby</span><a href="#" class="link-masinfo-pista"><span class="glyphicon glyphicon-pencil"></span> Editar</a><a href="#" class="link-masinfo-pista cancelar"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
				<hr class="division-reserva"/>
				<div class="info-reserva">
				<span class="fecha-reserva">14/06/2018</span><br/>
				<span class="hora-reseva">10:35 - 11:35</span>
				</div>
			</li>
			<li class="list-group-item">
				<img class="img-pista" src="${s}/img/tenis.jpg"/><span class="titulo-pista">Pista tenis</span><a href="#" class="link-masinfo-pista"><span class="glyphicon glyphicon-pencil"></span> Editar</a><a href="#" class="link-masinfo-pista cancelar"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
				<hr class="division-reserva"/>
				<div class="info-reserva">
				<span class="fecha-reserva">30/05/2018</span><br/>
				<span class="hora-reseva">11:00 - 11:30</span>
				</div>
			</li>
		</ul>
</div>

<%@ include file="../jspf/footer.jspf"%>