<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    <form action="" method="post" id="form-registro">
        <fieldset class="form-group">
            <legend>Asigna un equipo a un jugador</legend>
            <div class="form-group custom-form-group">
	            <!-- <label for="Email">Email</label> -->
	            <input type="text" id="username" name="Email" class="form-control custom-input" placeholder="Email del usuario" required=""/>
	            <c:if test="${not empty errorEmail}"><p class="error">${errorEmail}</p></c:if>
	        </div>        
	        <div class="form-group custom-form-group">
	            <!-- <label for="password">Contraseña</label> -->
	            <input type="text" id="equipo" name="Equipo" class="form-control custom-input" placeholder="Nombre del equipo" required=""/>
	            <c:if test="${not empty errorEquipo}"><p class="error">${errorEquipo}</p></c:if>
	        </div>
            <c:if test="${not empty error}"><p class="error">${error}</p></c:if>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="centrar">
           		<button type="submit" class="btn btn-reservar">Asignar</button>
           	</div>
        </fieldset>
    </form>
    

			
</div>

<%@ include file="../jspf/footer.jspf"%>
