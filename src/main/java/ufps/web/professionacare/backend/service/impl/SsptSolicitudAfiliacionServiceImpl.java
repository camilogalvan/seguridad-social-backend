package ufps.web.professionacare.backend.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.enums.EstadoSolicitudAfiliacion;
import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import ufps.web.professionacare.backend.repository.SsptSolicitudAfiliacionRepository;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;

@Service
@Transactional
public class SsptSolicitudAfiliacionServiceImpl implements SsptSolicitudAfiliacionService {

	@Autowired
	private SsptSolicitudAfiliacionRepository s;

	@Override
	public SsptSolicitudAfiliacion GetPorId(int id) {

		return s.findById(id).orElse(null);
	}

	@Override
	public List<SsptSolicitudAfiliacion> Get() {

		return (List<SsptSolicitudAfiliacion>) s.findAllOrderByfechaRespuesta();
	}

	@Override
	public SsptSolicitudAfiliacion guardar(SsptSolicitudAfiliacion so) {

		return s.save(so);
	}
	
	@Override
	public List<SsptSolicitudAfiliacion> filtradoReporte(String estado, Date fechaInicio, Date fechaFinal) {
		Integer tipo = -1;
		try {
			tipo = EstadoSolicitudAfiliacion.valueOf(estado).ordinal();
		} catch (Exception e) {
		}
		if (tipo != -1) {
			return s.findByFechaBetweenAndEstadoOnly(fechaInicio, fechaFinal, tipo);					
		} else {
			return s.findByFechaBetweenOnly(fechaInicio, fechaFinal);
		}
	}

	@Override
	public List<SsptSolicitudAfiliacion> busqueda(String busqueda, String estado, Date fecha, Boolean porFecha) {
		Integer tipo = -1;
		try {
			tipo = EstadoSolicitudAfiliacion.valueOf(estado).ordinal();
		} catch (Exception e) {
		}
		if (porFecha) {
			if (busqueda.length() > 0) {
				if (tipo != -1) {
					return s.findByBusquedaAndFechaAndEstadoOnly(fecha, tipo, busqueda);
				} else {
					return s.findByBusquedaAndFechaOnly(fecha, busqueda);
				}
			} else {
				if (tipo != -1) {
					return s.findByFechaAndEstadoOnly(fecha, tipo);					
				} else {
					return s.findByFechaOnly(fecha);
				}
			}
			
		} else {
			if (busqueda.length() > 0) {
				if (tipo != -1) {
					return s.findByBusquedaAndEstadoOnly(tipo, busqueda);
				} else {
					return s.findByBusquedaOnly(busqueda);
				}
			} else {
				if (tipo != -1) {
					return s.findByEstadoOnly(tipo);
				} else {
					return s.findAllOrderByfechaRespuesta();
				}
			}
		}
	}

}
