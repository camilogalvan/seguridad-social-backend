package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import ufps.web.professionacare.backend.repository.SsptSolicitudAfiliacionRepository;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;

@Service
@Transactional
public class SsptSolicitudAfiliacionServiceImpl implements SsptSolicitudAfiliacionService{
	
	@Autowired
	private SsptSolicitudAfiliacionRepository s;

	@Override
	public SsptSolicitudAfiliacion GetPorId(int id) {
		
		return s.findById(id).orElse(null);
	}

	@Override
	public List<SsptSolicitudAfiliacion> Get() {
		
		return (List<SsptSolicitudAfiliacion>) s.findAll();
	}

	@Override
	public SsptSolicitudAfiliacion guardar(SsptSolicitudAfiliacion so) {
		
		return s.save(so);
	}
	
	

}
