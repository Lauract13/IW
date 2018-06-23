<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
		<h3>Reservas</h3>
		<c:if test="${empty list}"><p>No hay ninguna reserva.</p></c:if>
		<ul class="list-group pistas">
			<c:forEach items="${list}" var="r">
	         	<li class="list-group-item">
	         		<img class="img-pista" src="/court/photo/${r.idCourt}"/><span class="titulo-pista">${r.nameCourt}</span>
	         		<c:if test="${r.isWeekend}">
		         		<form id="borrar-reserva-form" action="/reserve/delete" method="POST">
		         			<input type="hidden" name="id" value="${r.id}">
	         				<input type="submit" value="Anular" class="link-masinfo-pista baja-reserva">
	         			</form>
	         		</c:if>
	         		<br/><span>by <strong>${r.user}</strong></span>
	         		<hr class="division-reserva"/>
					<div class="info-reserva">
						<span class="fecha-reserva">${r.date}</span><br/>
						<h4>Horas</h4>
						<ul>
							<c:forEach items="${r.horas}" var="h">
								<li>
									<span class="hora-reseva">${h.cad}</span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</li>
	      	</c:forEach>
		</ul>
</div>

<%@ include file="../jspf/footer.jspf"%>