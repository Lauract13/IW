<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
    	<div class="crear-pista"><a href="/court/crear-pista" class="link-crear-pista"><span class="glyphicon glyphicon-plus"></span> CREAR PISTA</a></div>
		<ul class="list-group pistas">
			<li class="list-group-item"><img class="img-pista" src="${s}/img/rugby.jpg"/><span class="titulo-pista">Pista rugby, 12€/hora</span><p class="descripcion-pista">
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ullamcorper consectetur lobortis. Praesent et orci sollicitudin, dignissim magna a, convallis odio. Aenean eget tristique lorem. Nam ex sem, lobortis a tortor feugiat, euismod lobortis ante. Aenean sagittis nulla lectus, imperdiet lacinia mi rhoncus non. </p><p>direccion · 666777888</p><a href="#" class="link-editar-pista"><span class="glyphicon glyphicon-pencil"></span> Editar</a>  <a href="#" class="link-borrar-pista"><span class="glyphicon glyphicon-remove"></span> Borrar</a></li>
			<li class="list-group-item"><img class="img-pista" src="${s}/img/tenis.jpg"/><span class="titulo-pista">Pista tenis, 10€/hora</span><p class="descripcion-pista">Mauris a lobortis augue, vel hendrerit mi. Sed tincidunt libero et diam pellentesque, vel lobortis augue porta. Fusce dictum purus vitae pulvinar euismod. Pellentesque leo eros, imperdiet eget luctus eu, hendrerit quis mauris. Fusce gravida eros libero. Quisque pharetra magna tempor, bibendum orci quis, luctus ipsum. Suspendisse potenti. Integer molestie est nisl. In hac habitasse platea dictumst. Phasellus metus ligula, eleifend vitae tellus laoreet, sodales malesuada ipsum.</p><p>direccion · 666777888</p><a href="#" class="link-editar-pista"><span class="glyphicon glyphicon-pencil"></span> Editar</a>  <a href="#" class="link-borrar-pista"><span class="glyphicon glyphicon-remove"></span> Borrar</a></li>
		</ul>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</div>
<%@ include file="../jspf/authinfo.jspf"%>
<%@ include file="../jspf/footer.jspf"%>