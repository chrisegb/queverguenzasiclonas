package com.escuelita.demo.controllers;

import com.escuelita.demo.services.interfaces.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private IFileService service;

    @PostMapping
    public String upload(@RequestParam MultipartFile file,
                         @RequestParam Long idUser) {
        return service.upload(file, idUser);
    }
}
