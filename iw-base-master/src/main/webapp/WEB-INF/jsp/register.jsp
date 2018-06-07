<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header-2.jspf"%>

<div class="container">
    <form action="/newUser" method="POST" id="form-registro">               
        <fieldset>
            <legend>Registro</legend>
            <div class="form-group custom-form-group">
  				<input id="Nombre" name="Nombre" type="text" placeholder="Nombre" class="form-control custom-input" required="">
            	<c:if test="${not empty errorNombre}"><p class="error">${errorNombre}</p></c:if>
            	
            </div>
            <div class="form-group custom-form-group">
  				<input id="Telefono" name="Telefono" type="number" placeholder="Teléfono" class="form-control custom-input" required="">
            	<c:if test="${not empty errorTelefono}"><p class="error">${errorTelefono}</p></c:if>
            	
            </div>
            <div class="form-group custom-form-group">
  				<input id="Direccion" name="Direccion" type="text" placeholder="Dirección" class="form-control custom-input" required="">
            	<c:if test="${not empty errorDireccion}"><p class="error">${errorDireccion}</p></c:if>
           
            </div>
            <div class="form-group custom-form-group">
  				<input id="Email" name="Email" type="email" placeholder="Email" class="form-control custom-input" required="">
           		<c:if test="${not empty errorEmail}"><p class="error">${errorEmail}</p></c:if>
          
            </div>
            <div class="form-group custom-form-group">
  				<input id="Password" name="Password" type="password" placeholder="Password" class="form-control custom-input" required="">
            	<c:if test="${not empty errorPassword}"><p class="error">${errorPassword}</p></c:if>
            </div>
    		<div class="form-group">
    			<label for="UCM">¿Vinculado a la UCM?</label>
    			<div class="form-check">
				  <input class="form-check-input micheckbox" type="radio" name="UCM" id="inlineCheckbox1" value="option1" required>
				  <label class="form-check-label" for="inlineCheckbox1">Sí</label>
				  <input class="form-check-input micheckbox" type="radio" name="UCM" id="inlineCheckbox2" value="option2" required>
				  <label class="form-check-label" for="inlineCheckbox2">No</label>
				</div>
    		</div>
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<div class="centrar">
    			<input type="submit" value="Registrarse" class="btn submit-registro">
    		</div>
                       
        </fieldset>
    </form>
		
</div>
<%@ include file="../jspf/footer.jspf"%>