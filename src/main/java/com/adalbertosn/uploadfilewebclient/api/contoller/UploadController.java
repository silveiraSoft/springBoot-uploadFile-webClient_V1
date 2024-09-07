package com.adalbertosn.uploadfilewebclient.api.contoller;

import com.adalbertosn.uploadfilewebclient.core.UploadDisco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    Logger log = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    private UploadDisco disco;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile multipartFile) {
        //log.info("Request contains, File: " + file.getOriginalFilename());
        log.info("Request contains, File: "+ multipartFile.getOriginalFilename());
        // Add your processing logic here
        disco.salvarFoto(multipartFile);
        return ResponseEntity.ok("Success");
    }
}
