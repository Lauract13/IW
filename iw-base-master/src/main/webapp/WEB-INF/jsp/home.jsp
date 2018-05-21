<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>

<div class="container">
	<h3>Inicio</h3>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		    <li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
		    	<img class="img-caroussel" src="https://www.ucm.es/data/cont/media/www/pag-2257/_B220282c.jpg" alt="Futbol">
		    </div>
		
		    <div class="item">
		    	<img class="img-caroussel" src="https://www.ucm.es/data/cont/media/www/pag-2259/DSC00277c.jpg" alt="Piscina">
		    </div>
		
		    <div class="item">
		    	<img class="img-caroussel" src="https://www.ucm.es/data/cont/media/www/pag-10366/_DSC1876c.jpg" alt="Rugby">
		    </div>
		    
		 	<div class="item">
		    	<img class="img-caroussel" src="https://www.ucm.es/data/cont/media/www/pag-2258/_DSC1945c.jpg" alt="Tenis">
		    </div>
		  </div>
		
		  <!-- Left and right controls -->
		  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		  	<span class="glyphicon glyphicon-chevron-left"></span>
		  	<span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#myCarousel" data-slide="next">
		  	<span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
	</div>
    

			
</div>

<%@ include file="../jspf/footer.jspf"%>
