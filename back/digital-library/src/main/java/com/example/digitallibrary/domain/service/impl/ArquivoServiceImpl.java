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

            ResponseEntity<?> responseEntityFE = fileServerProxy.uploadArquivo(file, identificador, titulo);
            System.out.println("---> RESPONSE_ENTITY: " + responseEntityFE);
            System.out.println("---> R.E TO String: " + responseEntityFE.getBody());
            Arquivo arquivoArmazenado = FunctionsUtils.conveteEmArquivoInstaceOf(responseEntityFE);
            //TODO: verificar a estrutura de retorno do json e testar a converção
//        {"identificador":"20182SI0028_190-19T2019","titulo":"ide arquivo ","fileName":"da37c20ba46a5f96b1faa2200bb53a8c.pdf"}
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
