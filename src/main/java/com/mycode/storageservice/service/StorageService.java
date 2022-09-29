package com.mycode.storageservice.service;

import com.mycode.storageservice.entity.ImageData;
import com.mycode.storageservice.repository.StorageRepository;
import com.mycode.storageservice.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());

        if (imageData != null) {
            return "File uploaded successfully: "+file.getOriginalFilename();
        }
        return null;
    }
}
