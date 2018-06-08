<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    <form action="/admin/newAdmin" method="POST" id="form-registro">               
        <fieldset>
            <legend>Crear admin</legend>
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
  				<input id="Dni" name="Dni" type="text" placeholder="DNI" class="form-control custom-input" required="">
           		<c:if test="${not empty errorDni}"><p class="error">${errorDni}</p></c:if>
            </div>
            <div class="form-group custom-form-group">
  				<input id="Workplace" name="Workplace" type="text" placeholder="Lugar de trabajo" class="form-control custom-input" required="">
           		<c:if test="${not empty errorWorkplace}"><p class="error">${errorWorkplace}</p></c:if>
            </div>
            <div class="form-group custom-form-group">
  				<input id="Job" name="Job" type="text" placeholder="Puesto de trabajo" class="form-control custom-input" required="">
           		<c:if test="${not empty errorJob}"><p class="error">${errorJob}</p></c:if>
            </div>
            <div class="form-group custom-form-group">
  				<input id="Password" name="Password" type="password" placeholder="Password" class="form-control custom-input" required="">
            	<c:if test="${not empty errorPassword}"><p class="error">${errorPassword}</p></c:if>
            </div>
    		
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<div class="centrar">
    			<input type="submit" value="Crear administrador" class="btn submit-registro">
    		</div>
                       
        </fieldset>
    </form>
		
</div>
<%@ include file="../jspf/footer.jspf"%>