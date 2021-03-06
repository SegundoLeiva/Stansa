package com.stansa.alfresco;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class CmisDownloadDocument extends BaseOnPremExample {

	public void descargarArchivo(String codigoArchivo,
			HttpServletResponse response) throws IOException {

		Session session = getCmisSession();
		CmisObject object = session.getObject(codigoArchivo);

//		String documentPath = "/ricoh/documentlibrary/MFP/"+ object.getName();
		String documentPath2 = "/ricoh/documentlibrary/MFP/"+ object.getName();

		Document templateDocument = (Document) session.getObjectByPath(documentPath2);// Original

		if (templateDocument != null) {
			try {
				response.setHeader("Content-Type", "application/octet-stream");
				response.setHeader("Content-Disposition","attachment; filename=" + templateDocument.getName());

				ServletOutputStream out = response.getOutputStream();
				ContentStream cs = templateDocument.getContentStream();
				InputStream is = cs.getStream();

				IOUtils.write(convertArrayByte(is), out);
				out.flush();
				out.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	public InputStream visualizarArchivo(String codigoArchivo) throws IOException {

		Session session = getCmisSession();
		CmisObject object = session.getObject(codigoArchivo);
		byte[] buf = null;
		String documentPath = "/Sitios/ricoh/documentLibrary/MFP/"+ object.getName();

		Document templateDocument = (Document) session.getObjectByPath(documentPath);// Original
		InputStream input = null;
		if (templateDocument != null) {
			
			input = templateDocument.getContentStream().getStream();
		}
		return input;
	}
	
	public byte[] convertArrayByte(InputStream is) throws IOException{
		int size = 1024;
		int len = 0;
		byte[] data = new byte[size];

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = is.read(data, 0, size)) != -1) {
			bos.write(data, 0, len);
		}

		return bos.toByteArray();
	}
}