package com.escuelita.demo.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    String upload(MultipartFile multipartFile);
}
