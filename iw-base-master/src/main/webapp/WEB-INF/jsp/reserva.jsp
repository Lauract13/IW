<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
		<div class="reserva">
			<h3>Reserva para el día 21/05/2018</h3>
	    	<div class="horario">
	    		<div class="celda-horario">
	    			<div><input type="checkbox" name="franja-horaria" id="franja-9-10"> <label for="franja-9-10"> 09:00 — 10:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-10-11"> <label for="franja-10-11"> 10:00 — 11:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-11-12"> <label for="franja-11-12"> 11:00 — 12:00</label></div>
	    		</div>
	    		<div class="celda-horario">
	    			<div><input type="checkbox" name="franja-horaria" id="franja-12-13"> <label for="franja-12-13"> 12:00 — 13:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-13-14"> <label for="franja-13-14"> 13:00 — 14:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-14-15"> <label for="franja-14-15"> 14:00 — 15:00</label></div>
	    		</div>
	    		<div class="celda-horario">
	    			<div><input type="checkbox" name="franja-horaria" id="franja-15-16"> <label for="franja-15-16"> 15:00 — 16:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-16-17"> <label for="franja-16-17"> 16:00 — 17:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-17-18"> <label for="franja-17-18"> 17:00 — 18:00</label></div>
	    		</div>
	    		<div class="celda-horario">
	    			<div><input type="checkbox" name="franja-horaria" id="franja-18-19"> <label for="franja-18-19"> 18:00 — 19:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-19-20"> <label for="franja-19-20"> 19:00 — 20:00</label></div>
	    			<div><input type="checkbox" name="franja-horaria" id="franja-20-21"> <label for="franja-20-21"> 20:00 — 21:00</label></div>
	    		</div>
	    	</div>
	    	<div class="centrar">
	    		<button type="submit" class="btn btn-reservar">Reservar</button>
	    	</div>
	    </div>
</div>

<%@ include file="../jspf/footer.jspf"%>