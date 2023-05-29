package com.example.digitallibrary.core;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtil {

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
}
