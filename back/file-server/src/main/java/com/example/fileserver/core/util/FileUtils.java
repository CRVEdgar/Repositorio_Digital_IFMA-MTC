package com.example.fileserver.core.util;

import com.example.fileserver.core.exceptions.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

@Component
public class FileUtils {

    public static String PATH_TO_FILES;
    public static String PATH_ROOT;

    public static final int LIMITE_MAX = 50000000; /** 50MB */
    public static final String FORMATO_ACEITO = "pdf";

    public static String getFileMD5(InputStream inputStream){
        try {
            return DigestUtils.md5Hex(inputStream);
        }catch (IOException e){
            throw new ServiceException("erro ao gerar hashMD5 do arquivo");
        }
    }

    public static String getFileExtension(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isNotEmpty(originalFilename)) {
            int dotIndex = originalFilename.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < originalFilename.length() - 1) {
                return originalFilename.substring(dotIndex + 1);
            }
        }
        return null;
    }

    public static boolean gerarDiretorioRaiz(){
        boolean ok = new java.io.File(System.getProperty("user.home"), PATH_TO_FILES).mkdirs();
        return ok;
    }

    public static Path getPath(){
        return Path.of(PATH_ROOT+PATH_TO_FILES);
    }

    public static boolean tamanhoPermitido(MultipartFile file){
        if(file.getSize()<=LIMITE_MAX){
            return true;
        }
        return false;
    }

    public static boolean extensaoValida(MultipartFile file){
        if(getFileExtension(file).equals(FORMATO_ACEITO)){
            return true;
        }
        return false;
    }
}
