package com.mezzoforte.greenstreet.domain.upload.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mezzoforte.greenstreet.domain.upload.exception.FileUploadConvertException;
import com.mezzoforte.greenstreet.domain.upload.exception.FileUploadIOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3UploadService implements UploadService {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadFile(MultipartFile multipartFile) {
        return upload(multipartFile);
    }

    public List<String> uploadFiles(List<MultipartFile> multipartFiles) {

        List<String> resultList = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            String uploadedUrl = upload(multipartFile);
            resultList.add(uploadedUrl);
        }

        return resultList;
    }

    private String upload(MultipartFile multipartFile) {

        File uploadFile = convert(multipartFile);
        String fileName = "greenstreet/" + UUID.randomUUID() + uploadFile.getName();
        String uploadImageUrl = putS3(uploadFile, fileName);
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    private File convert(MultipartFile file) {

        File convertFile = new File(System.getProperty("user.dir") + "/" + file.getOriginalFilename());

        try {
            if (!convertFile.createNewFile()) {
                throw FileUploadConvertException.EXCEPTION;
            }

            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }

        } catch (IOException e) {
            throw FileUploadIOException.EXCEPTION;
        }

        return convertFile;
    }

    private void removeNewFile(File targetFile) {
        if (!targetFile.delete()) {
            // TODO : 에러 로깅하기
        }
    }
}
