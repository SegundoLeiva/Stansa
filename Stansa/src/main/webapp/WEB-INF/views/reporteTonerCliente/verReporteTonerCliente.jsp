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
<!-- 							<div class="control-group"> -->
<!-- 								<label class="control-label" for="fecha">Fecha Inicio</label> -->
<!-- 								<div class="controls"> -->
<!-- 									<span class="input-icon input-icon-right">  -->
<%-- 										<input type="text" name="fechaInicio" id="fechaInicio" class="span12 date-picker" readonly="readonly" value="${beanConsulta.fechaInicio}"> <i class="icon-calendar"></i> --%>
<!-- 									</span>								</div> -->
<!-- 							</div>							 -->
						</div>
						<div class="span4">
<!-- 							<div class="control-group"> -->
<!-- 								<label class="control-label" for="idTipoContrato">Tipo Contrato</label> -->
<!-- 								<div class="controls"> -->
<!-- 									<select name="idTipoContrato" id="idTipoContrato"> -->
<!-- 										<option value="">Seleccionar</option> -->
<%-- 										<c:forEach var="item" items="${listaTipoContrato}"> --%>
<%-- 											<option value="${item.idTipoContrato}" ${item.idTipoContrato == beanConsulta.idTipoContrato ? 'selected' : ' '}>${item.tipoContrato}</option> --%>
<%-- 										</c:forEach> --%>
<!-- 									</select>		 -->
<!-- 								</div> -->
<!-- 							</div>	 -->
<!-- 							<div class="control-group"> -->
<!-- 								<label class="control-label" for="fecha">Fecha Fin</label> -->
<!-- 								<div class="controls"> -->
<!-- 									<span class="input-icon input-icon-right">  -->
<%-- 										<input type="text" name="fechaFin" id="fechaFin" class="span12 date-picker" readonly="readonly" value="${beanConsulta.fechaFin}"> <i class="icon-calendar"></i> --%>
<!-- 									</span> -->
<!-- 								</div> -->
<!-- 							</div> -->
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<hr>
	<table id="tablaReporteTonerCliente" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Cliente</th>
							<th class="center">Sede</th>
							<th class="center">Producto</th>
							<th class="center">T. Negro</th>
							<th class="center">T. Magenta</th>
							<th class="center">T. Cyan</th>
							<th class="center">T. Yellow</th>
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
								<td class="center">${jbean.blacktoner}%</td>
								<td class="center">${jbean.magentatoner}%</td>
								<td class="center">${jbean.cyantoner}%</td>
								<td class="center">${jbean.yellowtoner}%</td>
 							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>