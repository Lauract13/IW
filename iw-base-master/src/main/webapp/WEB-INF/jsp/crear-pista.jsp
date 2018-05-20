<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
	<form action="newCourt" method="POST" id="form-registro">               
        <fieldset>
            <legend>Crear pista</legend>
            <div class="form-group">
 				<label for="Nombre">Nombre</label>  
  				<input id="Nombre" name="Nombre" type="text" placeholder="" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Precio">Precio (€/hora)</label>  
  				<input id="Precio" name="Precio" type="text" placeholder="" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Direccion">Dirección</label>  
  				<input id="Direccion" name="Direccion" type="text" placeholder="" class="form-control" required="">
            </div>
            <div class="form-group">
 				<label for="Telefono">Teléfono</label>  
  				<input id="Telefono" name="Telefono" type="tel" placeholder="" class="form-control" required="">
            </div>
            
            <div class="form-group">
           		<label for="Descripcion">Descripción</label> 
            	<textarea id="Descripcion" name="Descripcion" cols="40" rows="5" class="form-control"></textarea>    
            </div>
             <div class="form-group">
           		<label for="Extras">Extras</label> 
            	<textarea id="Extras" name="Extras" cols="40" rows="5" class="form-control"></textarea>    
            </div>
            <div class="form-group">
			    <label for="Imagen">Imágen</label>
			    <input type="file" name="file" class="form-control-file" id="Imagen" aria-describedby="fileHelp">
			    <small id="fileHelp" class="form-text text-muted"></small>
			</div>
            <div class="centrar">
            	<input type="submit" value="Crear" class="btn btn-login">
            </div>        
        </fieldset>
    </form> 	
</div>

<%@ include file="../jspf/footer.jspf"%>