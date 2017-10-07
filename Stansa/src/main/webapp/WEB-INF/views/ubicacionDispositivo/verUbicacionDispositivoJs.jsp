<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../assets/select2/select2.min.js"></script>
<script type="text/javascript">
var dataSedeCliente=[];
$(document).ready(function() {

	var esEmpleado = "${esEmpleado}";
 	if(esEmpleado=="true"){
 		dataSedeCliente = [{id:" ",text:"Seleccionar"}];
 	}
	<c:forEach var="item" items="${listaSedeCliente}">
		var obj = {id:"${item.idSedeCliente}",text:"${item.cliente.nombre} - ${item.lugarOficina}"}
		dataSedeCliente.push(obj);
	</c:forEach>
	
	$("#idSedeCliente").select2({
		  data: dataSedeCliente
	});
	
	$("#idSedeClienteTransferir").select2({
		  data: dataSedeCliente
	});
	
	var idSedeCliente = "${beanConsulta.idSedeCliente}";
 	if(idSedeCliente.trim()!=""){
 		$("#idSedeCliente").val(idSedeCliente).trigger('change');
 	}

} );

$("#btnTranferir").click(function(){
	$("#divModalTransferirForm").modal("show");
});

</script>