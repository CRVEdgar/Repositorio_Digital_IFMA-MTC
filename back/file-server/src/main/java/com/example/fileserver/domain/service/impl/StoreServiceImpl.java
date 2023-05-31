package com.example.fileserver.domain.service.impl;

import com.example.fileserver.core.exceptions.ServiceException;
import com.example.fileserver.core.util.FileUtils;
import com.example.fileserver.domain.model.Arquivo;
import com.example.fileserver.domain.service.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.example.fileserver.core.util.FileUtils.PATH_TO_FILES;
import static com.example.fileserver.core.util.FileUtils.getPath;

@Service
public class StoreServiceImpl implements StoreService {

    @Override
    public String store(MultipartFile arquivo) {
        if (arquivo.isEmpty()) {
            throw new ServiceException("Erro: arquivo vazio!");
        }

        try {
            // Obtendo o nome do arquivo
//            String fileName = arquivo.getOriginalFilename();
            String extension = FileUtils.getFileExtension(arquivo);

            String fileName = FileUtils.getFileMD5(arquivo.getInputStream())+"."+extension;

            // Definindo o caminho completo onde o arquivo será armazenado
//            String filePath = "/caminho/do/diretorio/" + fileName;
//            String filePath = PATH_TO_FILES+fileName;
            String filePath = getPath().toString()+"/"+fileName;
            System.out.println("SERÁ TRANSFERIDO PARA: " +filePath);

            // Salvando o arquivo
            arquivo.transferTo(new File(filePath));

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("Erro: nao foi possivel armazenar o arquivo!");
        }

    }

    @Override
    public Path load(String filename) throws ServiceException {

        return FileUtils.getPath().resolve(filename);

    }
}
