<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    <form action="/user/uploadUser" method="POST" id="form-modificar">               
        <fieldset>
            <legend>Editar perfil</legend>
            <div class="form-group">
 				<label for="Nombre">Nombre y Apellidos</label>  
  				<input id="Nombre" name="Nombre" type="text" placeholder="Nombre" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Telefono">Teléfono</label>  
  				<input id="Telefono" name="Telefono" type="tel" placeholder="Telefono" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Direccion">Dirección</label>  
  				<input id="Direccion" name="Direccion" type="text" placeholder="Direccion" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="OldPassword">Contraseña antigua</label>  
  				<input id="OldPassword" name="OldPassword" type="password" placeholder="Password" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Password">Nueva contraseña</label>  
  				<input id="Password" name="Password" type="password" placeholder="Password" class="form-control" required="">
            </div>
    		<div class="form-group">
    			<label for="UCM">¿Vinculado a la UCM?</label>
    			<div class="form-check">
				  <input class="form-check-input micheckbox" type="radio" name="UCM" id="inlineCheckbox1" value="option1">
				  <label class="form-check-label" for="inlineCheckbox1">Sí</label>
				  <input class="form-check-input micheckbox" type="radio" name="UCM" id="inlineCheckbox2" value="option2">
				  <label class="form-check-label" for="inlineCheckbox2">No</label>
				</div>
    		</div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            <input type="submit" value="Guardar cambios" class="btn btn-reg2">
        </fieldset>
    </form>
		
</div>

<%@ include file="../jspf/footer.jspf"%>
