var c = 1;
var horas = 0;
var horas_aux = 0;

$( document ).ready(function() { 
    navBar();
	anadirFecha();
	datepickerFunction();
	mostrarHoras();
	horas = $("#horasR").val();
	horas_aux = horas;
	if( $.trim($('#horario1').html()) != "" ) {
		horas = horas_aux;
		$("#muestra-horas").text("");
		$("#muestra-horas").text('Horas reservadas: ' + horas);
	}
	
	try {
		$("#inlineCheckbox1").click(function() {
			displayCodUcmInput();
			$("#CodUcm").attr("required",true);
			$("#checkbox-player1").attr("required",true);
			$("#checkbox-player2").attr("required",true);
		});
		$("#inlineCheckbox2").click(function() {
			hideCodUcmInput();
			$("#CodUcm").attr("required",false);
			$("#checkbox-player1").attr("required",false);
			$("#checkbox-player2").attr("required",false);
		});
	} catch {
		
	}
	
	$( ".inactive" ).prev().attr("disabled", true);
	try {
		document.getElementById("borrar-pista").onclick = function() {
		    document.getElementById("borrar-pista-form").submit();
		}
	} catch {
		
	}
	try {
		document.getElementById("borrar-admin").onclick = function() {
		    document.getElementById("borrar-admin-form").submit();
		}
	} catch {
		
	}
	try {
		document.getElementById("borrar-reserva").onclick = function() {
		    document.getElementById("borrar-reserva-form").submit();
		}
	} catch {
		
	}
});

function displayCodUcmInput() {
    var x = document.getElementById("input-cod-ucm");
    x.style.display = "block";
}
function hideCodUcmInput() {
    var x = document.getElementById("input-cod-ucm");
    x.style.display = "none";
}

function navBar() {
	var pathname = window.location.pathname;
	$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');
}

function datepickerFunction() {
	$( ".datepicker" ).datepicker({
        altFormat: "dd-mm-yy",
        dateFormat: "dd-mm-yy",
        minDate: 0
	});
	$( ".datepicker-weekend" ).datepicker({
        altFormat: "dd-mm-yy",
        dateFormat: "dd-mm-yy",
        minDate: 0,
        beforeShowDay:
             function(dt)
             {
                return [dt.getDay() == 0 || dt.getDay() == 6, ""];
             }
	});
}

function mostrarHoras(){
	var id = '#datepicker' + c;
	var h = '#horario' + c;
	
	$(id).change('input',function(e){
		var fecha = $(id).val();
		if( $.trim($(h).html()) != "" ) {
			horas = horas_aux;
			$("#muestra-horas").text("");
			$("#muestra-horas").text('Horas reservadas: ' + horas);
		}
		$(h).empty();
		horasDisponibles(fecha, h);	
	});
}

function horasDisponibles(f, h){
	var idC = $("#idCourt").val();
	$.ajax({
        type: "GET",
        url: "/reserve/booking",
        data: {date: f, court: idC},
        success: function(data, statusText, jqXHR){
        	horas_aux = horas;
        	if(data.length == 0){
        		$(h).append(
        	            '<div class="celda-horario">' +
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="9" id="franja-9-10-' + c + '"> <label for="franja-9-10-' + c + '"> 09:00 — 10:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="10" id="franja-10-11-' + c + '"> <label for="franja-10-11-' + c + '"> 10:00 — 11:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="11" id="franja-11-12-' + c + '"> <label for="franja-11-12-' + c + '"> 11:00 — 12:00</label></div>' + 
        	            '</div>' + 
        	            '<div class="celda-horario">' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="12" id="franja-12-13-' + c + '"> <label for="franja-12-13-' + c + '"> 12:00 — 13:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="13" id="franja-13-14-' + c + '"> <label for="franja-13-14-' + c + '"> 13:00 — 14:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="14" id="franja-14-15-' + c + '"> <label for="franja-14-15-' + c + '"> 14:00 — 15:00</label></div>' + 
        	            '</div>' + 
        	            '<div class="celda-horario">' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="15" id="franja-15-16-' + c + '"> <label for="franja-15-16-' + c + '"> 15:00 — 16:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="16" id="franja-16-17-' + c + '"> <label for="franja-16-17-' + c + '"> 16:00 — 17:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="17" id="franja-17-18-' + c + '"> <label for="franja-17-18-' + c + '"> 17:00 — 18:00</label></div>' + 
        	            '</div>' + 
        	            '<div class="celda-horario">' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="18" id="franja-18-19-' + c + '"> <label for="franja-18-19-' + c + '"> 18:00 — 19:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="19" id="franja-19-20-' + c + '"> <label for="franja-19-20-' + c + '"> 19:00 — 20:00</label></div>' + 
        	                '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="20" id="franja-20-21-' + c + '"> <label for="franja-20-21-' + c + '"> 20:00 — 21:00</label></div>' + 
        	            '</div>');
        	}else{
	        	var cad = '<div class="celda-horario">';
	        	data.forEach(element => {
	        		var hour = element.hour;
	        		if(element.reserved == 2){
	        			cad += '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="' + hour + '" id="franja-' + hour + '-' + (hour + 1) + '-' + c + '" disabled><label class="inactive" for="franja-' + hour + '-' + (hour + 1) + '-' + c + '"> ' + hour + ':00 — ' + (hour + 1) + ':00</label></div>';
	        		}else{
	        			cad += '<div><input type="checkbox" name="franja-horaria" class="franja-' + c + '" value="' + hour + '" id="franja-' + hour + '-' + (hour + 1) + '-' + c + '"><label for="franja-' + hour + '-' + (hour + 1) + '-' + c + '"> ' + hour + ':00 — ' + (hour + 1) + ':00</label></div>';
	        		}
	        		
	        		if(hour == 11 ||hour == 14 || hour == 17){
	        			cad += '</div><div class="celda-horario">';
	        		}
	        		
	        	});  
	        	cad += '</div>';
	        	$(h).append(cad);
        	}
        	countHours();
        },
        error: function(jqXHR, statusText, errorThrown) {
            alert("Error obteniendo historial");
        }
    });
}

function anadirFecha() {
	$("#anadir-fecha").click(function(){
		c++;
	    $("#nuevas-fechas").append('<div class="reserva-celda"><div class="centrar nueva-reserva">' +
	        '<label for="datepicker">Fecha ' + c + ':</label> <input type="text" name="datepicker" id="datepicker' + c + '" autocomplete="off" class="' + claseDatepicker + '">' +
	        '</div>'  + '<input type="hidden" name="countH" id="countH-' + c + '" value="">' +
	        '<div class="horario" id="horario' + c + '"></div></div>');
	    datepickerFunction();
	    mostrarHoras();
	});
}

function countHours(){
	var countH = 0;
	var clase = '.franja-' + c;
	var h = "#countH-" + c;	
	$(clase).on( 'click', function() {
	    if( $(this).is(':checked') ){
	        countH++;
	        
	        if(horas != -1)
	        	horas++;
	        	
	    } else {
	        countH--;
	        
	        if(horas != -1)
	        	horas--;
	    }
	    $(h).val(countH);
	    $("#muestra-horas").text("");
	    
	    if(horas > 18){
	    	$("#muestra-horas").text('Ya has reservado todas las horas disponibles');
	    }else{
	    	$("#muestra-horas").text('Horas reservadas: ' + horas);
	    }
	});
	
}