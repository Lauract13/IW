<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="starter-template">
	<h1>Registro</h1>

    <form action="/newUser" method="post">               
        <fieldset>
            <legend>Please Login</legend>
            <label for="name">Nombre</label>
            <input type="text" id="username" name="name"/> 
            <label for="surname">Apellidos</label>
            <input type="text" id="username" name="surname"/>
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email"/>        
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
            <label for="ucm">¿UCM?</label>
            <div class="form-check">
            	<input type="radio" name="radio" checked> <span class="label-text">Sí</span>
            	<label for="ucm">Código UCM</label>
            	<input type="text" id="ucm" name="Código"/>
            	<input type="radio" name="radio" checked> <span class="label-text">No</span>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            <div class="form-actions">
                <button type="submit" class="btn">Register</button>
            </div>
        </fieldset>
    </form>

	<%@ include file="../jspf/authinfo.jspf"%>		
</div>

<%@ include file="../jspf/footer.jspf"%>
