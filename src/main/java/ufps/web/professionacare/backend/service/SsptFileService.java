package ufps.web.professionacare.backend.service;

import org.springframework.web.multipart.MultipartFile;

import ufps.web.professionacare.backend.model.SsptFile;

public interface SsptFileService {
	
	public SsptFile save(MultipartFile file);
	
	public SsptFile save(SsptFile entity, MultipartFile file);
	
	public SsptFile getById(Integer id);

}
