package ufps.web.professionacare.backend.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ufps.web.professionacare.backend.model.SsptFile;
import ufps.web.professionacare.backend.repository.SsptFileRepository;
import ufps.web.professionacare.backend.service.SsptFileService;

@Service
@Transactional
public class SsptFileServiceImpl implements SsptFileService {

	@Autowired
	private SsptFileRepository repository;

	@Override
	public SsptFile save(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				return null;
			}

			SsptFile dbFile = new SsptFile(fileName, file.getContentType(), file.getBytes());

			return repository.save(dbFile);
		} catch (IOException ex) {
			return null;
		}
	}
	
	@Override
	public SsptFile save(SsptFile entity, MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				return null;
			}
			
			entity.setFileName(fileName);
			entity.setFileType(file.getContentType());
			entity.setData(file.getBytes());

			return repository.save(entity);
		} catch (IOException ex) {
			return null;
		}
	}

	@Override
	public SsptFile getById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
