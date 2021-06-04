package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import ufps.web.professionacare.backend.repository.SsptSolicitudAfiliacionRepository;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;

public class SsptSolicitudAfiliacionServiceImpl implements SsptSolicitudAfiliacionService{
	
	public SsptSolicitudAfiliacionRepository s;

	@Override
	public SsptSolicitudAfiliacion GetPorId(int id) {
		
		return (SsptSolicitudAfiliacion) s.finById(id);
	}

	@Override
	public List<SsptSolicitudAfiliacion> Get() {
		
		return s.findAll();
	}

	@Override
	public SsptSolicitudAfiliacion guardar(SsptSolicitudAfiliacion so) {
		
		return s.save(so);
	}
	
	

}
