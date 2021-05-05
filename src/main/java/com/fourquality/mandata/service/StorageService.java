package com.fourquality.mandata.service;

import com.fourquality.mandata.config.FileStorageProperties;
import com.fourquality.mandata.service.dto.UploadFileResponseDTO;
import com.fourquality.mandata.web.rest.errors.CTFileAlreadyExistsException;
import com.fourquality.mandata.web.rest.errors.MyFileNotFoundException;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Files.
 */
@Service
@Transactional
public class StorageService {

    private final Logger log = LoggerFactory.getLogger(StorageService.class);
    private final Path fileStorageLocation;
    private String diretorio;

    @Autowired
    Environment environment;

    public StorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        this.diretorio = fileStorageProperties.getUploadDir();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public void criarPasta(String nomePasta) {
        Path location = Paths.get(this.diretorio + "/" + nomePasta).toAbsolutePath().normalize();

        try {
            if (!Files.isDirectory(location)){
                Files.createDirectories(location);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    public String storeFile(MultipartFile file,  String nomePasta) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path targetLocation;
        if (Objects.nonNull(nomePasta) && nomePasta != "") {
            targetLocation = Paths.get(this.diretorio + "/" + nomePasta).toAbsolutePath().normalize();
        } else {
            targetLocation = this.fileStorageLocation;
        }
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            targetLocation = targetLocation.resolve(fileName);
            // Copy file to the target location (Replacing existing file with the same name)
            Boolean arquivoExistente = Files.exists(targetLocation, LinkOption.NOFOLLOW_LINKS);

            if (Objects.isNull(nomePasta) || nomePasta == "") {
                for (int i = 1; arquivoExistente; i++){
                    if (fileName.contains(".")){
                        fileName = StringUtils.cleanPath(file.getOriginalFilename()).replace(".", "("+i+").");
                    }
                    targetLocation = targetLocation.resolve(fileName);
                    arquivoExistente = Files.exists(targetLocation, LinkOption.NOFOLLOW_LINKS);
                }
            }

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        }catch (CTFileAlreadyExistsException fa){
            throw fa;
        } catch (Exception e) {
            throw new RuntimeException("FAIL! Could not store file " + fileName + ": " + e.getMessage(), e);
        }
    }

    public Resource loadFileAsResource(String pasta,String fileName) {
        try {
           // Path filePath = this.fileStorageLocation.resolve(fileName).normalize();

            Path filePath = Paths.get(this.diretorio + "/" + pasta).resolve(fileName).toAbsolutePath().normalize();

            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

    public List<UploadFileResponseDTO> listarTodosArquivosAluno(String matricula) {
        try {
            String fileDownloadUri = environment.getProperty("file.base-url") + ":" + environment.getProperty("server.port") + "/downloadFile/";
            Path targetLocation = Paths.get(this.diretorio + "/" + matricula).toAbsolutePath().normalize();
            List<UploadFileResponseDTO> arquivos = Files.list(targetLocation)
                .filter(Files::isRegularFile).map(o -> {
                        String name = o.getFileName().toString();
                        UploadFileResponseDTO fileDto = new UploadFileResponseDTO(name, fileDownloadUri + matricula + "/" + name,
                            FilenameUtils.getExtension(name), 0, 0l);
                        return fileDto;
                    }
                ).collect(Collectors.toList());

            return arquivos;
        } catch (Exception ex) {
            throw new MyFileNotFoundException("File not found " + matricula, ex);
        }
    }

    public void deleteFile(String pasta,String fileName) {
        try {
            Path filePath = null;
            if (Objects.isNull(pasta)){
                filePath = this.fileStorageLocation.resolve(fileName).normalize();
            }else {
                filePath = Paths.get(this.diretorio + "/" + pasta).resolve(fileName).toAbsolutePath().normalize();
            }

            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                File file = resource.getFile();
                file.delete();
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        } catch (IOException e) {
            log.error("Erro Ao Localizar arquivo "+e);
        }
    }
}
