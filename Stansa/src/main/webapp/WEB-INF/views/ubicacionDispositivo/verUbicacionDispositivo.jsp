<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<form method="POST" class="form-horizontal">
	<input type="hidden" name="id" id="id">	
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">

					<div class="row-fluid">
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idSedeCliente">Cliente-Sede</label>
								<div class="controls">
									<select name="idSedeCliente" id="idSedeCliente">
										
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<hr>
	<a href="#" title="Buscar" id="btnTranferir" class="btn btn-success btn-small pull-right" style="margin-bottom: 20px">
 							<i class="icon-retweet"></i>Transferir</a>
	<table id="tablaReporteTonerCliente" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Cliente</th>
							<th class="center">Sede</th>
							<th class="center">Producto</th>
							<th class="center"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
 							<tr>
 								<td class="center">${contador.count}</td>
								<td class="center">${jbean.consumo.sedeCliente.cliente.nombre}</td>
								<td class="center">${jbean.consumo.sedeCliente.lugarOficina}</td>
								<td class="center">${jbean.producto.descripcion}</td>
								<td class="center"><label><input type='checkbox' class='checkEstadoPedido'><span class='lbl'></span></label></td>
 							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>
<%@ include file="/WEB-INF/views/ubicacionDispositivo/ubicacionDispositivoTransferir.jsp"%>