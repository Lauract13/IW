<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    <form action="/login" method="post" id="form-registro">               
        <fieldset class="form-group">
            <legend>Inicio de sesión</legend>
            <div class="form-group">
	            <label for="Email">Email</label>
	            <input type="text" id="username" name="Email" class="form-control"/>
	        </div>        
	        <div class="form-group">
	            <label for="password">Contraseña</label>
	            <input type="password" id="password" name="Password" class="form-control"/>
	        </div>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            <button type="submit" class="btn btn-login">Iniciar sesión</button><a href="/register" class="btn btn-registro">Registro</a>
        </fieldset>
        <%@ include file="../jspf/authinfo.jspf"%>
    </form>
    

			
</div>

<%@ include file="../jspf/footer.jspf"%>
