<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
		<div class="reserva">
			<h3>Reserva de ${t.nameCourt}</h3>
			
			<form action="/reserve/nuevaReserva" method="post" id="form-reserva">
				<div class="reserva-celda">
					<div class="centrar">
						<h2>Fecha: ${t.date}</h2>
					</div>
			    	<div class="horario">
			    		<% int i = 9; %>
			    		<div class="celda-horario">
			    		<c:forEach items="${t.horas}" var="h">	
			    			<c:choose>
								<c:when test="${h.reserved == 1}">
									<div><input type="checkbox" name="franja-horaria" value="${h.hour}" id="franja-${h.hour}-<%= i + 1 %>" checked> <label for="franja-${h.hour}-<%= i + 1 %>"> ${h.hour}:00 — <%= i + 1 %>:00</label></div>
								</c:when>
								<c:otherwise>
									<div><input type="checkbox" name="franja-horaria" value="${h.hour}" id="franja-${h.hour}-<%= i + 1 %>"> <label for="franja-${h.hour}-<%= i + 1 %>"> ${h.hour}:00 — <%= i + 1 %>:00</label></div>
								</c:otherwise>
							</c:choose>					
							
							<% if(i == 11 || i == 14 || i == 17){ %>
								</div>
								<div class="celda-horario">
							<%} %>
							<% i++; %>
						</c:forEach>
						</div>
			    	</div>
		    	</div>
		    	<!--  <input type="hidden" name="countH" value=""> -->
		    	<div class="centrar">
		    		<button type="submit" class="btn btn-reservar">Guardar cambios</button>
		    	</div>
		    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    	<input type="hidden" name="id" value="${t.id}"/>
		    </form>
	    </div>
</div>

<%@ include file="../jspf/footer.jspf"%>