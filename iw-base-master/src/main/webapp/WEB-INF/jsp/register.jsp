<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    <form action="/newUser" method="POST" id="form-registro">               
        <fieldset>
            <legend>Registro</legend>
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
 				<label for="Email">Email</label>  
  				<input id="Email" name="Email" type="email" placeholder="Email" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Password">Contraseña</label>  
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
            
            <input type="submit" value="Regístrate" class="btn btn-login">
        </fieldset>
    </form>
		
</div>

<%@ include file="../jspf/footer.jspf"%>
