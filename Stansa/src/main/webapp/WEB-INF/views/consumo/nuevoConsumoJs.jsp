<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var consumoJSONArray  = arrayJsonDetalle;
var index = 1;
var dataSedeCliente=[];
var dataInsumo=[];
var filaSerie = 0;
var filaIp = 0;
var btnSerie = '<a class="green" href="#" onclick="abrirSerie(this)"> <i class="icon-align-justify bigger-130"></i></a>';
var btnIp = '<a class="info" href="#" onclick="abrirIp(this)"> <i class="icon-align-justify bigger-130"></i></a>';

$(document).ready(function() {
	tabla="#tablaConsumoDetalle";
	claseColumna=["idProducto","descripcionProducto","cantidad"];
	inicializarStyleTablaDetalle();
	
	if('<c:out value="${accion}"/>'!=""){	
		$("#codigoGenerado").html("N° "+$("#idConsumo").val());
		var i=0;
		<c:forEach var="jbean" items="${listaConsumoDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}",
		             	"${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.insumo.insumo}"+" - "+"${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.descripcion}",
		                "${jbean.cantidad}","KG"];
			agregarDetalle(data); 
			consumoJSONArray[i].idDetalle="${jbean.id.idConsumoDetalle}";
			consumoJSONArray[i].idUnidadMineraInsumoPresentacion="${jbean.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}";
			consumoJSONArray[i].cantidad="${jbean.cantidad}";
			consumoJSONArray[i].pesoNeto="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.pesoNeto}";
			consumoJSONArray[i].descripcionPresentacion="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.descripcion}";
			consumoJSONArray[i].unidadMedidaPresentacion="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.idUnidadMedidaPresentacion}";
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

} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarProducto("")){			 	
		 	var data = [$("#idProducto").val(),$("#idProducto option:selected").text(),
		 	            $("#cantidad").val(),btnSerie,btnIp];
		 	agregarDetalle(data);
		 	var fila = consumoJSONArray.length-1;
		 	consumoJSONArray[fila].idProducto=$("#idProducto").val();
			consumoJSONArray[fila].cantidad=$("#cantidad").val();
			consumoJSONArray[fila].descripcionProducto=$("#idProducto option:selected").text();
			consumoJSONArray[fila].numeroSerie="";
			consumoJSONArray[fila].numeroIp="";
		 	$("#divModalDetalleForm").modal("hide");
	 }
});

function agregarDetalle(data){
	var mercaderiaJSON = {
		    idDetalle:'',idProducto:'',cantidad:'',descripcionProducto:'',
		    indicadorBD: INDICADOR_NUEVO};
	consumoJSONArray.push(mercaderiaJSON);
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarProducto("editar")){	
		 setearCampo("idProducto",$("#idProducto").val());
		 setearCampo("descripcionProducto",$("#idProducto option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
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
		$("#cantidad").val(consumoJSONArray[index].cantidad);
		filaIndexDetalle = index;

		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarProducto(flag){
	var rpta=true;
	var cantidad = parseFloat($("#cantidad").val());
	var idProducto = $("#idProducto").val();
	var indexEditar = 0;

	for (var i = 0; i < consumoJSONArray.length; i++) {
		var _idProducto = consumoJSONArray[i].idProducto;
		if(flag!="editar"){
			if(_idProducto==idProducto){
				alertify.error("Ya existe el Producto.");
				rpta=false;
			}
		}else{
			if(i!=filaIndexDetalle){
				if(_idProducto==idProducto){
					alertify.error("Ya existe el Producto.");
					rpta=false;
				}
			}
		}
		
	}
	
	if(cantidad==0){
		alertify.error("La cantidad debe ser mayor a 0.");
		rpta=false;
	}

	return rpta;
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardar").click(function(){

	var data = $("#formMercaderia").serializeObject();
	data.index = index;
	data.consumoJSONArray = JSON.stringify(consumoJSONArray);
		
	if(fnValidarGuardarMercaderia()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			showLoading();
			$.ajax({
				type : 'post',
				data: data,
				url : '${pageContext.request.contextPath}/ingresarMercaderia/guardarMercaderia.htm',
				success : function(data) {
					hideLoading();
					if(data!=""){	
						index = actualizarDetalleGrabar(index);						
						$("#idMercaderia").val(data);	
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
	if(!validarCamposRequeridos("formMercaderia")){
		return false;
	}else if(consumoJSONArray.length==0){
		alertify.error("Mínimo debe registrar un detalle");
		return false;
	}else{
		return true;
	}
}

function getProveedorDescripcion(){
	var rucProveedor = $("#rucProveedor").val();
	if(rucProveedor!=""){	
		showLoading();
			$.ajax({
				type : 'post',
				data: {'rucProveedor': rucProveedor},
				url : '${pageContext.request.contextPath}/ajax/getProveedorDescripcion.htm',
				success : function(data) {	
					hideLoading();
					if(data==""){
						alertify.error("No existe proveedor.");
						$("#rucProveedor").val("");
						$("#descripcionProveedor").val("");
					}else{
						$("#descripcionProveedor").val(data);
					}
					
				}
			});
	}else{
		$("#rucProveedor").val("");
		$("#descripcionProveedor").val("");
	}
		
}

function abrirSerie(bloque){
	filaSerie = $(bloque).closest("tr").index();
	var tamanio = consumoJSONArray[filaSerie].cantidad;
	var cadenaHtml="";
	for (var i = 0; i < tamanio; i++) {
		cadenaHtml = cadenaHtml + '<div class="control-group"><label class="control-label">Serie '+(i+1)+'</label><div class="controls"><input type="text" id="idSerie'+(i+1)+'" class="inputInsumo"></div></div>';
	}
	$("#bodySerie").html(cadenaHtml);
	
	var numeroSerie=consumoJSONArray[filaSerie].numeroSerie;
	var cantidad = consumoJSONArray[filaSerie].cantidad;
	for (var i = 0; i < cantidad; i++) {
		$("#idSerie"+(i+1)).val(numeroSerie.split(";")[i]);
	}
	
	$("#divSerie").modal("show");
}

$("#btnAgregarSerieDetalle").click(function(){
	var numeroSerie="";
	var tamanio = consumoJSONArray[filaSerie].cantidad;
	for (var i = 0; i < tamanio; i++) {
		numeroSerie = numeroSerie + $("#idSerie"+(i+1)).val()+";"
	}
	consumoJSONArray[filaSerie].numeroSerie = numeroSerie;
	$("#divSerie").modal("hide");
});

function abrirIp(bloque){
	filaIp = $(bloque).closest("tr").index();
	var tamanio = consumoJSONArray[filaSerie].cantidad;
	var cadenaHtml="";
	for (var i = 0; i < tamanio; i++) {
		cadenaHtml = cadenaHtml + '<div class="control-group"><label class="control-label">Ip '+(i+1)+'</label><div class="controls"><input type="text" id="idIp'+(i+1)+'" class="inputInsumo"></div></div>';
	}
	$("#bodyIp").html(cadenaHtml);
	
	var numeroIp=consumoJSONArray[filaSerie].numeroIp;
	var cantidad = consumoJSONArray[filaIp].cantidad;
	for (var i = 0; i < cantidad; i++) {
		$("#idIp"+(i+1)).val(numeroIp.split(";")[i]);
	}
	
	$("#divIp").modal("show");
}

$("#btnAgregarIpDetalle").click(function(){
	var numeroIp="";
	var tamanio = consumoJSONArray[filaIp].cantidad;
	for (var i = 0; i < tamanio; i++) {
		numeroIp = numeroIp + $("#idIp"+(i+1)).val()+";"
	}
	consumoJSONArray[filaIp].numeroIp = numeroIp;
	$("#divIp").modal("hide");
});

$("#idSedeCliente").change(function(){
	if($(this).val().trim()!=""){
		for (var i = 0; i < dataSedeCliente.length; i++) {
			if(dataSedeCliente[i].id==$(this).val()){
				$("#tipoContrato").val(dataSedeCliente[i].tipoContrato);
				break;
			}
		}
		
	}
});

</script>