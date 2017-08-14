<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function() {
	
	$("#btnArchivo").click(function(){

		var fd = new FormData();
 		var file = $('input[name=cargaRegistro]')[0].files[0];
 		fd.append('file1', file);
		fd.append('prueba1', "aaaaaa");

		 if(fnValidarArchivo()){
// 			alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
// 					function(){
				showLoading();
				$.ajax({
					type : 'POST',
					data: fd,
					processData: false,
					contentType: false,
					url : '${pageContext.request.contextPath}/cargaRegistroMFP/obtenerArchivo.htm',
					success : function(data) {
						hideLoading();
// 						if(data!=""){	
// 							index = actualizarDetalleGrabar(index);						
// 							$("#idConsumo").val(data);	
// 							$("#codigoGenerado").html("N° "+data);
// 							mensajeTransaccion("guardar");											
// 						}else{
// 							mensajeTransaccion("error");
// 						}
						
					}
				});
// 							  },
// 					function(){});
		}
	});


} );

function fnValidarArchivo(){
	return true;
}

</script>