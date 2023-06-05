package com.example.digitallibrary.core.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class FileUtil {
    public static final int LIMITE_MAX = 50000000; /** 50MB */
    public static final String FORMATO_ACEITO = "pdf";
    public static final String FOLDER_TMP = "/repositorioTemp";
    public static final String PATH_TO_FILES = System.getProperty("java.io.tmpdir").concat(FOLDER_TMP);



    public static String generateMD5Hash(MultipartFile file){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(convert(file));
            DigestInputStream dis = new DigestInputStream(fis, md);

            byte[] buffer = new byte[8192];
            while (dis.read(buffer) != -1) {
                // Lendo o arquivo para atualizar o hash
            }

            dis.close();

            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException | IOException e) {
            return "ERRO AO GERAR HASH MD5 DO ARQUIVO";
        }
    }

    public static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
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

    public static boolean existe(MultipartFile file){
        if(!file.isEmpty() || file!=null){
            return true;
        }
        return false;
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

    public static String gerarIdentificador(String codigoAutor, String codigoOrientador){
        LocalDateTime today = LocalDateTime.now();
        return codigoAutor.concat("_")
                .concat(codigoOrientador).concat("_")
                .concat( String.valueOf(today) ).replace(':', '-' ).replace('.', 'N');
    }

    public static boolean gerarDiretorioRaiz(){

        boolean ok = new java.io.File(PATH_TO_FILES).mkdirs();
        return ok;

    }

    public static String copyToFileSystemTmp(MultipartFile file){
        String fileName = file.getOriginalFilename();
        System.out.println("NOME DO ORIGINAL DO ARQUIVO: " +fileName);

        // Cria um caminho para armazenar temporariamente o arquivo
        Path tempDir = Path.of(PATH_TO_FILES);

        System.out.println("tempDir: " +tempDir);
        Path tempFilePath = null;
        try {
//          Path tempFilePath = Files.createTempFile("temp-", fileName);
            tempFilePath = Files.createTempFile(tempDir, "temp-", fileName);

            // Copia o conteúdo do arquivo para o caminho temporário
            Files.copy(file.getInputStream(), tempFilePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------> NOME DO ARQUIVO MODIFICADO: " + tempFilePath.getFileName().toString());

        System.out.println("*********** ARMAZENAOD EM: " + tempFilePath);

        return tempFilePath.getFileName().toString();
    }

    public static File getTempArq(String nameArq){
        // Caminho para o arquivo que será enviado
        String filePath = PATH_TO_FILES + File.separator + nameArq;

        File file = new File(nameArq);

        return file;
    }

}
