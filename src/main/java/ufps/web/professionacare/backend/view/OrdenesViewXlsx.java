package ufps.web.professionacare.backend.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptOrdenServicio;

@Component("reporte-ordenes.xlsx")
public class OrdenesViewXlsx extends AbstractXlsxView {

	private String[] celdasHeader = new String[] { "IDRadicado", "TipoIdCliente", "NumIdCliente", "Nombre1", "Nombre2",
			"Apellido1", "Apellido2", "Telefono", "Dirección", "Correo", "FechaNacimiento", "TipoCliente",
			"Departamento", "Municipio", "CodigoMunicipio", "FechaExpedición", "LugarExpedición",
			"CodigoActividadEconomica", "ActividadEconomica", "NivelRiesgo", "IBC", "Plan", "Servicios", "Estado Orden",
			"Fecha Limite", "Fecha de Registro", "Fecha Pago", "Funcionario a cargo" };

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"ordenes-pago.xlsx\"");

		Sheet sheet = workbook.createSheet("Solicitudes Afiliación");
		CellStyle theaderStyle = workbook.createCellStyle();

		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Row row = sheet.createRow(0);

		Cell celda;
		for (int i = 0; i < celdasHeader.length; i++) {
			celda = row.createCell(i);

			celda.setCellValue(celdasHeader[i]);
			celda.setCellStyle(theaderStyle);

		}

		List<SsptOrdenServicio> lista = (List<SsptOrdenServicio>) model.get("ordenes");

		if (lista != null) {

			SsptOrdenServicio item;
			SsptCliente cliente;
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			int j;

			for (int i = 0; i < lista.size(); i++) {
				item = lista.get(i);
				cliente = item.getCliente();

				if (cliente == null) {
					continue;
				} else {
					System.out.println("Cliente: " + cliente.getId());
				}

				row = sheet.createRow(i + 1);

				j = 0;
				row.createCell(j++).setCellValue(item.getId());
				row.createCell(j++).setCellValue(cliente.getTipoIdentificacion().getTipo());
				row.createCell(j++).setCellValue(cliente.getIdentificacion());
				row.createCell(j++).setCellValue(cliente.getNombre1());
				row.createCell(j++).setCellValue(cliente.getNombre2());
				row.createCell(j++).setCellValue(cliente.getApellido1());
				row.createCell(j++).setCellValue(cliente.getApellido2());
				row.createCell(j++).setCellValue(cliente.getTelefono());
				row.createCell(j++).setCellValue(cliente.getDireccion());
				row.createCell(j++).setCellValue(cliente.getCorreo());
				row.createCell(j++).setCellValue(
						cliente.getFechaNacimiento() != null ? formatDate.format(cliente.getFechaNacimiento()) : "");
				row.createCell(j++).setCellValue(
						cliente.getTipoCliente() != null ? cliente.getTipoCliente().getDescripcion() : "");
				row.createCell(j++).setCellValue(
						cliente.getMunicipio() != null ? cliente.getMunicipio().getNombreDepartamento() : "");
				row.createCell(j++).setCellValue(
						cliente.getMunicipio() != null ? cliente.getMunicipio().getNombreMunicipio() : "");
				row.createCell(j++)
						.setCellValue(cliente.getMunicipio() != null ? cliente.getMunicipio().getCodigoDptoMpio() : "");
				row.createCell(j++).setCellValue(
						cliente.getFechaExpedicion() != null ? formatDate.format(cliente.getFechaExpedicion()) : "");
				row.createCell(j++)
						.setCellValue(cliente.getLugarExpedicion() != null ? cliente.getLugarExpedicion() : "");
				row.createCell(j++).setCellValue(
						cliente.getActividad() != null && cliente.getActividad().getCodigoActividad() != null
								? cliente.getActividad().getCodigoActividad().toString()
								: "");
				row.createCell(j++).setCellValue(
						cliente.getActividad() != null ? cliente.getActividad().getNombreActividad() : "");
				row.createCell(j++).setCellValue(
						cliente.getActividad() != null ? cliente.getActividad().getNivelRiesgo().toString() : "");
				row.createCell(j++).setCellValue(cliente.getIbc() != null ? cliente.getIbc().toString() : "");
				row.createCell(j++).setCellValue(cliente.getPlan() != null ? cliente.getPlan().getTitulo() : "");
				row.createCell(j++).setCellValue(cliente.getPlan() != null ? cliente.getPlan().getServicios() : "");
				row.createCell(j++).setCellValue(item.getEstadoOrden() != null ? item.getEstadoOrden().getNombre(): "");
				row.createCell(j++)
						.setCellValue(item.getFechaLimite() != null ? formatDate.format(item.getFechaLimite()) : "");
				row.createCell(j++)
						.setCellValue(item.getFechaOrden() != null ? formatDateTime.format(item.getFechaOrden()) : "");
				row.createCell(j++)
						.setCellValue(item.getFechaPago() != null ? formatDateTime.format(item.getFechaPago()) : "");
				row.createCell(j++).setCellValue(cliente.getAsesor() != null ? cliente.getAsesor().getNombres() : "");

			}

		}

		for (int i = 0; i < celdasHeader.length; i++) {
			sheet.autoSizeColumn(i);
		}

	}

}
