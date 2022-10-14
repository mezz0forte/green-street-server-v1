package com.mezzoforte.greenstreet.domain.upload.presentation;

import com.mezzoforte.greenstreet.domain.upload.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class UploadController {

    private final UploadService uploadService;

    @PostMapping("/file")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        return uploadService.uploadFile(multipartFile);
    }

    @PostMapping("/files")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> uploadFiles(@RequestParam("file") List<MultipartFile> multipartFiles) {
        return uploadService.uploadFiles(multipartFiles);
    }
}
