<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    <form action="/newUser" method="post" id="form-registro">               
        <fieldset>
            <legend>Por favor, rellene el formulario</legend>
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
  				<input id="Password" name="Email" type="password" placeholder="Password" class="form-control" required="">
            </div>
    		<div class="form-group">
    			<label for="UCM">¿Vinculado a la UCM?</label>
    			<div class="form-check">
				  <input class="form-check-input micheckbox" type="radio" name="vinc-ucm" id="inlineCheckbox1" value="option1">
				  <label class="form-check-label" for="inlineCheckbox1">Sí</label>
				  <input class="form-check-input micheckbox" type="radio" name="vinc-ucm" id="inlineCheckbox2" value="option2">
				  <label class="form-check-label" for="inlineCheckbox2">No</label>
				</div>
				<script type="text/javascript">
				  $(".micheckbox").on( 'change', function() {
					    if( $(this).is(':checked') ) {
					        if($(this).val() === "option1"){
					        	
					        }else{
					        	
					        }
					    } else {
					        // Hacer algo si el checkbox ha sido deseleccionado
					        alert("El checkbox con valor " + $(this).val() + " ha sido deseleccionado");
					    }
					});
				 </script>
    		</div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            <button type="submit" class="btn btn-reg2">Register</button>
        </fieldset>
    </form>
		
</div>

<%@ include file="../jspf/footer.jspf"%>
