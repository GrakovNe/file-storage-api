package org.grakovne.file.storage.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.grakovne.file.storage.api.v1.dto.ApiResponse;
import org.grakovne.file.storage.domain.FileAsset;
import org.grakovne.file.storage.provider.FileStorageProvider;
import org.grakovne.file.storage.service.FileAssetService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/files")
public class FileAssetEndpoint {

    private final FileAssetService fileAssetService;
    private final FileStorageProvider fileStorageProvider;
    private final ObjectMapper objectMapper;

    public FileAssetEndpoint(FileAssetService fileAssetService, FileStorageProvider fileStorageProvider, ObjectMapper objectMapper) {
        this.fileAssetService = fileAssetService;
        this.fileStorageProvider = fileStorageProvider;
        this.objectMapper = objectMapper;
    }

    @PostMapping("")
    public ApiResponse<FileAsset> uploadFile(
        @RequestPart(value = "asset", required = false) String assetString,
        @RequestPart(value = "file") MultipartFile file) throws IOException {

        FileAsset asset;

        if (null == assetString || assetString.isEmpty()) {
            asset = new FileAsset();
            asset.setName(file.getOriginalFilename());
        } else {
            asset = objectMapper.readValue(assetString, FileAsset.class);
        }

        File tempFile = Files.createTempFile(UUID.randomUUID().toString(), file.getOriginalFilename()).toFile();
        file.transferTo(tempFile);

        return new ApiResponse<>(fileAssetService.createFileAsset(asset, tempFile));
    }

    @GetMapping("{hash}")
    public HttpEntity<byte[]> downloadFile(@PathVariable String hash) throws IOException {
        FileAsset asset = fileAssetService.getFileAsset(hash);
        File content = fileStorageProvider.getFile(asset.getFileName());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=" + asset.getName().replace(" ", "_")
        );

        httpHeaders.setContentLength(content.length());
        return new HttpEntity<>(FileUtils.readFileToByteArray(content), httpHeaders);
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteFile(@PathVariable Long id) {
        fileAssetService.getFileAsset(id);
        return new ApiResponse("File has been deleted.");
    }
}
