<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="crear-pista"><a href="/admin/crear-admin" class="link-crear-pista"><span class="glyphicon glyphicon-plus"></span> CREAR ADMIN</a></div>
    	<c:if test="${empty listAdmins}"><p>Aún no hay ningun admin creado.</p></c:if>
		<ul class="list-group pistas">
			<c:forEach items="${listAdmins}" var="admin">
	         	<li class="list-group-item">
	         		<span class="titulo-pista">${admin.login}</span>
	         		<p class="descripcion-pista">${admin.dni}</p>
	         		<form method="POST" action="/admin/deleteAdmin" id="borrar-admin-form">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" value="${admin.login}" id="id-admin" name="Nombre">
						<!-- <a href="/admin/deleteAdmin" class="link-borrar-pista" id="borrar-admin"><span class="glyphicon glyphicon-remove"></span> Dar de baja</a> -->
						<input type="submit" value="Dar de baja">
					</form>
				</li>
				
				
			</c:forEach>
		</ul>
		
</div>

<%@ include file="../jspf/footer.jspf"%>