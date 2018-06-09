<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<c:choose>
	<c:when test="${sessionScope['user'] == null}">
		<%@ include file="../jspf/header-2.jspf"%>
	</c:when>
	<c:otherwise>
		<%@ include file="../jspf/header.jspf"%>
	</c:otherwise>
</c:choose>

<div class="container">
    <h2>Error</h2>
</div>

<%@ include file="../jspf/footer.jspf"%>
