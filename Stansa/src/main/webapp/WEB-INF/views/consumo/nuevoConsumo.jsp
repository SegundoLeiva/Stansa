<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<c:set var="now" value="<%=Calendar.getInstance().getTime()%>" />

<div class="page-header position-relative">
	<form id="formConsumo" method="POST" class="form-horizontal">
	<input type="hidden" name="idConsumo" id="idConsumo" value="${consumo.idConsumo}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">

					<div class="row-fluid">
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idSedeCliente">Cliente-Sede</label>
								<div class="controls">
									<select name="idSedeCliente" id="idSedeCliente" onchange="this">
	
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Asignaci�n</label>
								<div class="controls">
									<c:choose>
										<c:when test="${empty accion}">
											<input type="text" class="form-control date-picker" name="fechaConsumo" id="fechaConsumo" 
												readonly="readonly" value="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy" />">
										</c:when>
										<c:otherwise>
											<input type="text" class="form-control date-picker" name="fechaConsumo" id="fechaConsumo" 
											readonly="readonly" value="<fmt:formatDate value="${consumo.fechaConsumo}" pattern="dd/MM/yyyy" />">
										</c:otherwise>
									</c:choose>
									
								</div>
							</div>	
							
						</div>

						<div class="span4">							
							<div class="control-group">
								<label class="control-label" for="idUsuarioCreacion">Usuario</label>
								<div class="controls">		
									<input type="text" class="form-control" name="idUsuarioCreacion" id="idUsuarioCreacion" value="${idUsuarioCreacion}" readonly="readonly">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="idTipoContrato">Tipo Contrato</label>
								<div class="controls">
									<select name="idTipoContrato" id="idTipoContrato" required="required" data-msg-required="El campo Tipo Contrato es obligatorio.">
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaTipoContrato}">
											<option value="${item.idTipoContrato}">${item.tipoContrato}</option>
										</c:forEach>
									</select>		
								</div>
							</div>		
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<div class="header table-header">
			<a href="#" title="Agregar Detalle" class="btn btn-small btn-primary" id="abrirDetalleAgregar"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar</a>
			<a href="#" title="Eliminar Detalle" class="btn btn-small btn-primary" id="eliminarDetalle"
				style="border: 1px solid #c4e7ff;"><i class="icon-trash"></i>Eliminar</a>
			<a href="#" title="Editar Detalle" class="btn btn-small btn-primary" id="abrirDetalleEditar"
				style="border: 1px solid #c4e7ff;"><i class="icon-edit"></i>Editar</a>
	</div>
	<table id="tablaConsumoDetalle"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">
								<label><input type="checkbox" class="checkSelectedAll">
								<span class="lbl"></span></label>
							</th>
							<th class="center" width="10%">C�digo</th>
							<th class="center" width="50%">Modelo</th>
							<th class="center">Nro Serie</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
</div>


<%@ include file="/WEB-INF/views/consumo/nuevoConsumoDetalle.jsp"%>