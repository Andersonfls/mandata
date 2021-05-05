package com.fourquality.mandata.service.dto;

public class  UploadFileResponseDTO {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    private long materialDidaticoId;

    public UploadFileResponseDTO(String fileName, String fileDownloadUri, String fileType, long size, long materialDidaticoId) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
        this.materialDidaticoId = materialDidaticoId;
    }

    public UploadFileResponseDTO() {
    }

    // Getters and Setters

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getMaterialDidaticoId() {
        return materialDidaticoId;
    }

    public void setMaterialDidaticoId(long materialDidaticoId) {
        this.materialDidaticoId = materialDidaticoId;
    }
}
