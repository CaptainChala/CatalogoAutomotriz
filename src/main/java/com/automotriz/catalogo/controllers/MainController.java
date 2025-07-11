package com.automotriz.catalogo.controllers;

import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.automotriz.catalogo.models.services.UploadService;

@Controller
public class MainController {

	private final UploadService uploadService;

	public MainController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@GetMapping({ "", "/", "/index" })
	public String index() {
		return "redirect:/productos";
	}

	@GetMapping("/upload/{filename:.+}")
	public ResponseEntity<Resource> viewImage(@PathVariable String filename) {

		Resource resource = null;

		try {
			resource = uploadService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);

	}

}
