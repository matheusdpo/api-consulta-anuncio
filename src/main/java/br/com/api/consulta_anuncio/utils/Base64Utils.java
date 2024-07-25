package br.com.api.consulta_anuncio.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Component
public class Base64Utils {


    public static String base64toString(MultipartFile file) {
        String base64File = null;
        try {
            byte[] bytes = file.getBytes();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao processar o arquivo.";
        }
    }
}
