<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var consumoJSONArray  = arrayJsonDetalle;
var index = 1;
var dataSedeCliente=[];
var dataInsumo=[];

$(document).ready(function() {
	tabla="#tablaConsumoDetalle";
	claseColumna=["idProducto","descripcionProducto","numeroSerie","numeroIp"];
	inicializarStyleTablaDetalle();
	
	if('<c:out value="${accion}"/>'!=""){	
		$("#codigoGenerado").html("N° "+$("#idConsumo").val());
		var i=0;
		<c:forEach var="jbean" items="${listaConsumoDetalle}">		
		var data = ["${jbean.producto.idProducto}",
	             	"${jbean.producto.descripcion}","${jbean.numeroSerie}","${jbean.numeroIp}"];
		agregarDetalle(data); 
		consumoJSONArray[i].idDetalle="${jbean.id.idConsumoDetalle}";
		consumoJSONArray[i].idProducto="${jbean.producto.idProducto}";
		consumoJSONArray[i].descripcionProducto="${jbean.producto.descripcion}";
		consumoJSONArray[i].numeroSerie="${jbean.numeroSerie}";
		consumoJSONArray[i].numeroIp="${jbean.numeroIp}";
		consumoJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaConsumoDetalle.get(listaConsumoDetalle.size()-1).id.idConsumoDetalle+1}";
		
		if('<c:out value="${accion}"/>'=="CONSULTAR"){
			bloquearCamposConsultar();		
		}
	}
	
	dataSedeCliente = [{id:" ",text:"Seleccionar", tipoContrato:""}];
	<c:forEach var="item" items="${listaSedeCliente}">
		var obj = {id:"${item.idSedeCliente}",text:"${item.cliente.nombre} - ${item.zona.descripcion}",
				tipoContrato:"${item.tipoContrato.tipoContrato}"}
		dataSedeCliente.push(obj);
	</c:forEach>
	
	$("#idSedeCliente").select2({
	  data: dataSedeCliente
	});
	
	dataInsumo = [{id:" ",text:"Seleccionar"}];
	<c:forEach var="item" items="${listaProducto}">
			var obj = {id:"${item.idProducto}",text:"${item.descripcion}"}
			dataInsumo.push(obj);
	</c:forEach>
	
	$("#idProducto").select2({
		  data: dataInsumo
	});
	
	var idSedeCliente ="${consumo.sedeCliente.idSedeCliente}";
 	if(idSedeCliente.trim()!=""){
 		$("#idSedeCliente").val(idSedeCliente).trigger('change');
 	}

} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarProducto("")){			 	
		 	var data = [$("#idProducto").val(),$("#idProducto option:selected").text(),
		 	            $("#numeroSerie").val(),$("#numeroIp").val()];
		 	agregarDetalle(data);
		 	var fila = consumoJSONArray.length-1;
		 	consumoJSONArray[fila].idProducto=$("#idProducto").val();
			consumoJSONArray[fila].cantidad="1";
			consumoJSONArray[fila].descripcionProducto=$("#idProducto option:selected").text();
			consumoJSONArray[fila].numeroSerie=$("#numeroSerie").val();
			consumoJSONArray[fila].numeroIp=$("#numeroIp").val();
		 	$("#divModalDetalleForm").modal("hide");
	 }
});

function agregarDetalle(data){
	var mercaderiaJSON = {
		    idDetalle:'',idProducto:'',cantidad:'',descripcionProducto:'',numeroSerie:'',numeroIp:'',
		    indicadorBD: INDICADOR_NUEVO};
	consumoJSONArray.push(mercaderiaJSON);
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarProducto("editar")){	
		 setearCampo("idProducto",$("#idProducto").val());
		 setearCampo("descripcionProducto",$("#idProducto option:selected").text());
		 setearCampo("numeroSerie",$("#numeroSerie").val());
		 setearCampo("numeroIp",$("#numeroIp").val());
		 cambiarIndicadorModificado();	 
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaMercaderiaDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var index = checkDetalle.closest("tr").index();

		$("#idProducto").val(consumoJSONArray[index].idProducto).trigger('change');
		$("#numeroSerie").val(consumoJSONArray[index].numeroSerie);
		$("#numeroIp").val(consumoJSONArray[index].numeroIp);
		filaIndexDetalle = index;

		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarProducto(flag){
	var rpta=true;
	var idProducto = $("#idProducto").val();
	var indexEditar = 0;

// 	for (var i = 0; i < consumoJSONArray.length; i++) {
// 		var _idProducto = consumoJSONArray[i].idProducto;
// 		if(flag!="editar"){
// 			if(_idProducto==idProducto){
// 				alertify.error("Ya existe el Producto.");
// 				rpta=false;
// 			}
// 		}else{
// 			if(i!=filaIndexDetalle){
// 				if(_idProducto==idProducto){
// 					alertify.error("Ya existe el Producto.");
// 					rpta=false;
// 				}
// 			}
// 		}
		
// 	}

	return rpta;
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardar").click(function(){

	var data = $("#formConsumo").serializeObject();
	data.index = index;
	data.consumoJSONArray = JSON.stringify(consumoJSONArray);
		
	if(fnValidarGuardarMercaderia()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			showLoading();
			$.ajax({
				type : 'post',
				data: data,
				url : '${pageContext.request.contextPath}/registrarConsumo/guardarConsumo.htm',
				success : function(data) {
					hideLoading();
					if(data!=""){	
						index = actualizarDetalleGrabar(index);						
						$("#idConsumo").val(data);	
						$("#codigoGenerado").html("N° "+data);
						mensajeTransaccion("guardar");											
					}else{
						mensajeTransaccion("error");
					}
					
				}
			});
						  },
				function(){});
	}
});

function fnValidarGuardarMercaderia(){
	if(!validarCamposRequeridos("formConsumo")){
		return false;
	}else if(consumoJSONArray.length==0){
		alertify.error("Mínimo debe registrar un detalle");
		return false;
	}else{
		return true;
	}
}

$("#idSedeCliente").change(function(){
	if($(this).val().trim()!=""){
		for (var i = 0; i < dataSedeCliente.length; i++) {
			if(dataSedeCliente[i].id==$(this).val()){
				$("#tipoContrato").val(dataSedeCliente[i].tipoContrato);
				break;
			}
		}
		
	}else{
		$("#tipoContrato").val("");
	}
	
});

</script>