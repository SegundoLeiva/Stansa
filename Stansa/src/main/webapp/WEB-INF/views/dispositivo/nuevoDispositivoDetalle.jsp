<form id="formModalDetalleForm">
<div id="divModalDetalleForm" class="modal hide fade"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="tituloText">Ingresar</h3>
	</div>
	<div class="modal-body">		
				<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idProducto">Producto</label>
								<div class="controls selectInsumo">
									<select id="idProducto" required disabled="disabled"
										data-msg-required="El campo Producto es obligatorio."></select>
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="numeroSerie">Nro Serie</label>
								<div class="controls">
									<input type="text" id="numeroSerie" class="inputInsumo" disabled="disabled">
								</div>
							</div>
						</div>				
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="aliasProducto">Nombre</label>
								<div class="controls">
									<input type="text" id="aliasProducto" class="inputInsumo">
								</div>
							</div>
						</div>	
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="numeroIp">Nro Ip</label>
								<div class="controls">
									<input type="text" id="numeroIp" class="inputInsumo" required data-msg-required="El campo Ip es obligatorio.">
								</div>
							</div>
						</div>
							
					</div>
	</div>
	<div class="modal-footer">
		<a title="Agregar" id="btnAgregarDetalle"
				class="btn btn-small btn-success">Agregar
		</a>
		<a title="Editar" id="btnEditarDetalle"
				class="btn btn-small btn-success">Editar
		</a>
		<button class="btn btn-small btn-primary" data-dismiss="modal" aria-hidden="true">Cancelar</button>
	</div>
</div>
</form>