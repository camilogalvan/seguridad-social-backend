package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptMunicipio;

public interface SsptMunicipioService {
	
	public SsptMunicipio getPorId(int id);
	
	public List<SsptMunicipio> getPorDepartamento(int id);
	

}
