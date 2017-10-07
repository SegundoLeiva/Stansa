<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var dataSedeCliente=[];
$(document).ready(function() {
	
	dataSedeCliente = [{id:" ",text:"Seleccionar", tipoContrato:""}];
	<c:forEach var="item" items="${listaSedeCliente}">
		var obj = {id:"${item.idSedeCliente}",text:"${item.cliente.nombre} - ${item.lugarOficina}",
				tipoContrato:"${item.tipoContrato.tipoContrato}"}
		dataSedeCliente.push(obj);
	</c:forEach>
	
	$("#idSedeCliente").select2({
	  data: dataSedeCliente
	});
	
	var idSedeCliente ="${beanConsulta.idSedeCliente}";
 	if(idSedeCliente.trim()!=""){
 		$("#idSedeCliente").val(idSedeCliente).trigger('change');
 	}


} );

</script>