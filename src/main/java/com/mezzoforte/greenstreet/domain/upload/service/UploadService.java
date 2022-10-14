package com.mezzoforte.greenstreet.domain.upload.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {

    String uploadFile(MultipartFile file);
    List<String> uploadFiles(List<MultipartFile> files);
}
