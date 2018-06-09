var c = 1;

$( document ).ready(function() { 
    navBar();
	anadirFecha();
	datepickerFunction();
	mostrarHoras();
	
	try {
		$("#inlineCheckbox1").click(function() {
			displayCodUcmInput();
		});
		$("#inlineCheckbox2").click(function() {
			hideCodUcmInput();
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
		$(h).empty();
		horasDisponibles(fecha, h);	
	});
}

function horasDisponibles(f, h){
	$.ajax({
        type: "GET",
        url: "/reserve/booking",
        data: {date: f},
        success: function(data, statusText, jqXHR){
        	var cad = '<div class="celda-horario">';
        	data.forEach(element => {
        		var hour = element.hour;
        		
        		if(element.reserved == 1){
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
	        '<label for="datepicker">Fecha ' + c + ':</label> <input type="text" name="datepicker" id="datepicker' + c + '" autocomplete="off" class="datepicker">' +
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
	console.log(clase);
	$(clase).on( 'click', function() {
	    if( $(this).is(':checked') ){
	        countH++;
	    } else {
	        countH--;
	    }
	    $(h).val(countH);
	    console.log(countH);
	});
	
}