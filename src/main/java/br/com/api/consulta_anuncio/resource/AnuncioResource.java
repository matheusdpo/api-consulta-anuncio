package br.com.api.consulta_anuncio.resource;

import br.com.api.consulta_anuncio.domain.model.AnuncioModel;
import br.com.api.consulta_anuncio.domain.response.ResponseMessage;
import br.com.api.consulta_anuncio.service.AnuncioService;
import br.com.api.consulta_anuncio.utils.Base64Utils;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping(value = "/anuncio")
@RestController
public class AnuncioResource {

    @Autowired
    private AnuncioService anuncioService;

    @PostMapping(value = "/insereAnuncio")
    public ResponseEntity<ResponseMessage> insereAnuncio(@Nonnull @RequestParam String titulo,
                                                         @Nonnull @RequestParam String descricao,
                                                         @Nonnull @RequestParam String valor,
                                                         @Nonnull @RequestParam MultipartFile file) {
        try {
            String imagemBase64 = Base64Utils.base64toString(file);
            Double valorConvertido = Double.valueOf(valor); // Converte o valor de String para Double

            AnuncioModel anuncio = AnuncioModel.builder()
                    .nome(titulo)
                    .descricao(descricao)
                    .valor(valorConvertido)
                    .imagem("data:image/png;base64," + imagemBase64)
                    .build();

            anuncioService.save(anuncio);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseMessage("success", "Anúncio publicado com sucesso!"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseMessage("error", "Erro ao inserir anúncio: " + e.getMessage()));
        }
    }

    @GetMapping(value = "/capturaAnuncios")
    public ResponseEntity<List<AnuncioModel>> capturaAnuncios() {
        try {
            List<AnuncioModel> anuncioModelList = anuncioService.get();
            return ResponseEntity.status(HttpStatus.OK).body(anuncioModelList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); 
        }
    }

}
