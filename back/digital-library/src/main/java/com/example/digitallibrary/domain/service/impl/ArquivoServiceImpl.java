package com.example.digitallibrary.domain.service.impl;

import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.core.proxy.FileServerProxy;
import com.example.digitallibrary.core.util.FileUtil;
import com.example.digitallibrary.core.util.FunctionsUtils;
import com.example.digitallibrary.domain.model.Arquivo;
import com.example.digitallibrary.domain.repository.ArquivoRepository;
import com.example.digitallibrary.domain.service.ArquivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    private final FileServerProxy fileServerProxy;
    private final ArquivoRepository arquivoRepository;

    public ArquivoServiceImpl(FileServerProxy fileServerProxy, ArquivoRepository arquivoRepository) {
        this.fileServerProxy = fileServerProxy;
        this.arquivoRepository = arquivoRepository;
    }


    @Override
    public Arquivo enviar(MultipartFile file, String codigoAutor, String codigoOrientador, String titulo) throws DomainException {

        String identificador = FileUtil.gerarIdentificador(codigoAutor, codigoOrientador);


        try {

            ResponseEntity<?> responseEntity = fileServerProxy.uploadArquivo(file, identificador, titulo);
            System.out.println("---> RESPONSE_ENTITY STATUS CODE: " + responseEntity.getStatusCode());

            Arquivo arquivoArmazenado = FunctionsUtils.conveteEmArquivoInstaceOf(responseEntity);

            return arquivoArmazenado;


        }catch (Exception e) {
            e.printStackTrace();
            throw new DomainException("nao foi possivel enviar o arquivo");
        }

    }

    @Override
    public void save(Arquivo arquivoSalvo) throws DomainException {
        arquivoRepository.save(arquivoSalvo);
    }


}
