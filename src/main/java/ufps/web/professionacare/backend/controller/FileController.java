package ufps.web.professionacare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.model.SsptFile;
import ufps.web.professionacare.backend.service.SsptFileService;

@RestController
@RequestMapping("/api/file/")
public class FileController {

	@Autowired
	private SsptFileService service;

	@GetMapping("{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) {
		// Load file from database
		SsptFile dbFile = service.getById(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));
	}

}
