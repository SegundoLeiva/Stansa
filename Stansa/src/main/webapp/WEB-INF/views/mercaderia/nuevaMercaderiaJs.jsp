<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = arrayJsonDetalle;
var index = 1;
var dataInsumo=[];
var filaSerie = 0;
var btnSerie = '<a class="green" href="#" onclick="abrirSerie(this)"> <i class="icon-align-justify bigger-130"></i></a>';

$(document).ready(function() {
	tabla="#tablaMercaderiaDetalle";
	claseColumna=["idProducto","descripcionProducto","cantidad"];
	inicializarStyleTablaDetalle();
	
	var accion = '<c:out value="${accion}"/>';
	if(accion=="CONSULTAR" || accion=="EDITAR"){
		$("#codigoGenerado").html("N° "+$("#idMercaderia").val());
		var i=0;
		<c:forEach var="jbean" items="${listaMercaderiaDetalle}">		
		 	var data = ["${jbean.producto.idProducto}",
		             	"${jbean.producto.descripcion}",
		             	"${jbean.cantidad}",btnSerie];
			agregarDetalle(data); 
			mercaderiaJSONArray[i].idDetalle="${jbean.id.idMercaderiaDetalle}";
			mercaderiaJSONArray[i].idProducto="${jbean.producto.idProducto}";
			mercaderiaJSONArray[i].cantidad="${jbean.cantidad}";
			mercaderiaJSONArray[i].descripcionProducto="${jbean.producto.descripcion}";
			mercaderiaJSONArray[i].numeroSerie="${jbean.numeroSerie}";
			mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaMercaderiaDetalle.get(listaMercaderiaDetalle.size()-1).id.idMercaderiaDetalle+1}";
		
		
	}
	if(accion=="CONSULTAR"){
		bloquearCamposConsultar();
	}
	
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
 		 	            $("#cantidad").val(),btnSerie];
 		 	agregarDetalle(data);
 		 	var fila = mercaderiaJSONArray.length-1;
 		 	mercaderiaJSONArray[fila].idProducto=$("#idProducto").val();
			mercaderiaJSONArray[fila].cantidad=$("#cantidad").val();
			mercaderiaJSONArray[fila].descripcionProducto=$("#idProducto option:selected").text();
			mercaderiaJSONArray[fila].numeroSerie="";
		 	$("#divModalDetalleForm").modal("hide");
	 }
});

function agregarDetalle(data){
	var mercaderiaJSON = {
		    idDetalle:'',idProducto:'',cantidad:'',descripcionProducto:'',
		    indicadorBD: INDICADOR_NUEVO};
	mercaderiaJSONArray.push(mercaderiaJSON);
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

		$("#idProducto").val(mercaderiaJSONArray[index].idProducto).trigger('change');
		$("#cantidad").val(mercaderiaJSONArray[index].cantidad);
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

	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var _idProducto = mercaderiaJSONArray[i].idProducto;
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
	data.mercaderiaJSONArray = JSON.stringify(mercaderiaJSONArray);
		
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
	}else if(mercaderiaJSONArray.length==0){
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
	var tamanio = mercaderiaJSONArray[filaSerie].cantidad;
	var cadenaHtml="";
	for (var i = 0; i < tamanio; i++) {
		cadenaHtml = cadenaHtml + '<div class="control-group"><label class="control-label">Serie '+(i+1)+'</label><div class="controls"><input type="text" id="idSerie'+(i+1)+'" class="inputInsumo"></div></div>';
	}
	$("#bodySerie").html(cadenaHtml);
	
	var numeroSerie=mercaderiaJSONArray[filaSerie].numeroSerie;
	var cantidad = mercaderiaJSONArray[filaSerie].cantidad;
	for (var i = 0; i < cantidad; i++) {
		$("#idSerie"+(i+1)).val(numeroSerie.split(";")[i]);
	}
	
	$("#divSerie").modal("show");
}

$("#btnAgregarSerieDetalle").click(function(){
	var numeroSerie="";
	var tamanio = mercaderiaJSONArray[filaSerie].cantidad;
	for (var i = 0; i < tamanio; i++) {
		numeroSerie = numeroSerie + $("#idSerie"+(i+1)).val()+";"
	}
	mercaderiaJSONArray[filaSerie].numeroSerie = numeroSerie;
	$("#divSerie").modal("hide");
});

</script>