<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<% int count = 1; %>

<script type="text/javascript">  
    var count = "<%=count%>";
</script>
<div class="container">
		<div class="reserva">
			<h3>Reservar pista Pista1</h3>
			
			<form action="/reserve/nuevaReserva" method="post" id="form-reserva">
				<div class="reserva-celda">
					<div class="centrar">
						<label for="datepicker<%= count%>">Fecha <%= count %>:</label>
						<% String claseDatepicker = "datepicker-weekend";%>
						<c:if test="${isPlayer}">
							<% claseDatepicker = "datepicker";%>
						</c:if>
						<input type="text" name="datepicker" id="datepicker<%= count%>" class="<%=claseDatepicker %>" autocomplete="off">
						<script type="text/javascript">  
    						var claseDatepicker = "<%=claseDatepicker%>";
						</script>
					</div>
					<input type="hidden" name="countH" id="countH-<%= count%>" value="">
			    	<div class="horario" id="horario<%= count%>">

			    	</div>
		    	</div>
		    	<div id="nuevas-fechas"></div>
		    	<div class="centrar margen-arriba"><a class="link-crear-pista" id="anadir-fecha"><span class="glyphicon glyphicon-plus"></span> AÑADIR FECHA</a></div>
		    	<div class="centrar">
		    		<button type="submit" class="btn btn-reservar">Reservar</button>
		    	</div>
		    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    	<input type="hidden" name="idCourt" value="${idCourt}"/>
		    </form>
	    </div>
</div>

<%@ include file="../jspf/footer.jspf"%>