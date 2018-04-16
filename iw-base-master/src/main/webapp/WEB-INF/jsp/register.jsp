<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="starter-template">
	<h1>Registro</h1>

    <form action="/newUser" method="post">               
        <fieldset>
            <legend>Por favor, rellene el formulario</legend>
            <div class="form-group">
 				<label class="col-md-4 control-label" for="Nombre">Nombre y Apellidos</label>  
  				<div class="col-md-5">
  				<input id="Nombre" name="Nombre" type="text" placeholder="Nombre" class="form-control input-md" required="">
  				</div>
            </div>
            <div class="form-group">
 				<label class="col-md-4 control-label" for="Telefono">Teléfono</label>  
  				<div class="col-md-5">
  				<input id="Telefono" name="Telefono" type="tel" placeholder="Telefono" class="form-control input-md" required="">
  				</div>
            </div>
            <div class="form-group">
 				<label class="col-md-4 control-label" for="Direccion">Dirección</label>  
  				<div class="col-md-5">
  				<input id="Direccion" name="Direccion" type="text" placeholder="Direccion" class="form-control input-md" required="">
  				</div>
            </div>
            <div class="form-group">
 				<label class="col-md-4 control-label" for="Email">Email</label>  
  				<div class="col-md-5">
  				<input id="Email" name="Email" type="email" placeholder="Email" class="form-control input-md" required="">
  				</div>
            </div>
            <div class="form-group">
 				<label class="col-md-4 control-label" for="Password">Contraseña</label>  
  				<div class="col-md-5">
  				<input id="Password" name="Email" type="password" placeholder="Password" class="form-control input-md" required="">
  				</div>
            </div>
    		<div class="form-group">
    			<label class="col-md-4 control-label" for="UCM">¿Vinculado a la UCM?</label> 
    			<div class="form-check form-check-inline">
				  <input class="form-check-input micheckbox" type="checkbox" id="inlineCheckbox1" value="option1">
				  <label class="form-check-label" for="inlineCheckbox1">Sí</label>

				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input micheckbox" type="checkbox" id="inlineCheckbox2" value="option2">
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
            
            <div class="form-actions">
                <button type="submit" class="btn">Register</button>
            </div>
        </fieldset>
    </form>
		
</div>

<%@ include file="../jspf/footer.jspf"%>
