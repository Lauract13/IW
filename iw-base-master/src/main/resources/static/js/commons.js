$( document ).ready(function() {
    console.log( "ready!" );
    var pathname = window.location.pathname;
	$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');
});