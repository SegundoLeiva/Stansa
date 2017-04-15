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
								<label class="control-label" for="idUnidadMinera">Cliente-Sede</label>
								<div class="controls">
									<select name="idSedeCliente" id="idSedeCliente">
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaSedeCliente}">
											<option value="${item.idSedeCliente}" ${item.idSedeCliente == beanConsulta.idSedeCliente ? 'selected' : ' '}>${item.cliente.nombre}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
									<span class="input-icon input-icon-right"> 
										<input type="text" name="fechaInicio" id="fechaInicio" class="span12 date-picker" readonly="readonly" value="${beanConsulta.fechaInicio}"> <i class="icon-calendar"></i>
									</span>								</div>
							</div>							
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="estadoEntregaPedido">Estado Pedido</label>
								<div class="controls">
									<select name="estadoEntregaPedido" id="estadoEntregaPedido">
										<option value="">Seleccionar</option>
										<option value="P" ${beanConsulta.estadoEntregaPedido=='P' ? 'selected' : ' '}>PENDIENTE</option>
										<option value="A" ${beanConsulta.estadoEntregaPedido=='A' ? 'selected' : ' '}>APROBADO</option>
									</select>		
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Fin</label>
								<div class="controls">
									<span class="input-icon input-icon-right"> 
										<input type="text" name="fechaFin" id="fechaFin" class="span12 date-picker" readonly="readonly" value="${beanConsulta.fechaFin}"> <i class="icon-calendar"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<hr>
	<table class="tablaSearch table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Cliente</th>
							<th class="center">Estado Pedido</th>
							<th class="center">Fecha Creación</th>
							<th class="center">Usuario Creación</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center">${jbean.idConsumo}</td>
								<td class="center">${jbean.sedeCliente}</td>
								<td class="center">${jbean.estadoEntregaPedido}</td>
								<td class="center">${jbean.fechaCreacion}</td>
								<td class="center">${jbean.idUsuarioCreacion}</td>
								<td class="center">
									<a class="blue" href="modificar.htm?id=<c:out value="${jbean.idConsumo}" />"
											title="Modificar"> <i class="icon-edit bigger-130"></i>
									</a>
									<a class="green" href="consultar.htm?id=<c:out value="${jbean.idConsumo}" />"
										title="Consultar"> <i class="icon-align-justify bigger-130"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>