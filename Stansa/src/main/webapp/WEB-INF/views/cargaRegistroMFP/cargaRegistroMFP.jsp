<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<form id="formConsumo" method="POST" class="form-horizontal">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span5">

						<div class="row">
							<div class="control-group">
								<label class="control-label" for="">Cargar Archivo</label>
								<div class="controls">
									<input type="file" id="cargaRegistro" name="cargaRegistro">
								</div>
							</div>
						</div>
						
						<div class="row">
							<button type="button" id="btnArchivo" class="btn btn-info btn-small pull-right">Cargar</button>
						</div>
					</div>
			</div>

		</div>

	</form>

</div>