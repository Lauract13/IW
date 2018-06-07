$( document ).ready(function() {
    console.log( "ready!" );
    
    navBar();
	anadirFecha();
	datepickerFunction();
});

function navBar() {
	var pathname = window.location.pathname;
	$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');
}

function datepickerFunction() {
	$( ".datepicker" ).datepicker({
        altFormat: "dd-mm-yy",
        dateFormat: "dd-mm-yy",
        beforeShowDay:
             function(dt)
             {
                return [dt.getDay() == 0 || dt.getDay() == 6, ""];
             }
	});             // The function returns the product of p1 and p2
}

function anadirFecha() {
	$("#anadir-fecha").click(function(){
		count++;
	    $("#nuevas-fechas").append('<div class="reserva-celda"><div class="centrar nueva-reserva">' +
	        '<label for="datepicker">Fecha ' + (count+1) + ':</label> <input type="text" name="datepicker" id="datepicker' + count + '" autocomplete="off" class="datepicker">' +
	        '</div>' +
	        '<div class="horario">' + 
	            '<div class="celda-horario">' +
	                '<div><input type="checkbox" name="franja-horaria" id="franja-9-10-' + count + '" value="9"> <label for="franja-9-10-' + count + '"> 09:00 — 10:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-10-11-' + count + '" value="10"> <label for="franja-10-11-' + count + '"> 10:00 — 11:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-11-12-' + count + '" value="11"> <label for="franja-11-12-' + count + '"> 11:00 — 12:00</label></div>' + 
	            '</div>' + 
	            '<div class="celda-horario">' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-12-13-' + count + '" value="12"> <label for="franja-12-13-' + count + '"> 12:00 — 13:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-13-14-' + count + '" value="13"> <label for="franja-13-14-' + count + '"> 13:00 — 14:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-14-15-' + count + '" value="14"> <label for="franja-14-15-' + count + '"> 14:00 — 15:00</label></div>' + 
	            '</div>' + 
	            '<div class="celda-horario">' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-15-16-' + count + '" value="15"> <label for="franja-15-16-' + count + '"> 15:00 — 16:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-16-17-' + count + '" value="16"> <label for="franja-16-17-' + count + '"> 16:00 — 17:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-17-18-' + count + '" value="17"> <label for="franja-17-18-' + count + '"> 17:00 — 18:00</label></div>' + 
	            '</div>' + 
	            '<div class="celda-horario">' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-18-19-' + count + '" value="18"> <label for="franja-18-19-' + count + '"> 18:00 — 19:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-19-20-' + count + '" value="19"> <label for="franja-19-20-' + count + '"> 19:00 — 20:00</label></div>' + 
	                '<div><input type="checkbox" name="franja-horaria" id="franja-20-21-' + count + '" value="20"> <label for="franja-20-21-' + count + '"> 20:00 — 21:00</label></div>' + 
	            '</div>' + 
	        '</div></div>');
	    
	    datepickerFunction();
	    //document.getElementById('#datepicker' + count).focus();
	    //window.location.hash = '#datepicker' + count;
	});
}