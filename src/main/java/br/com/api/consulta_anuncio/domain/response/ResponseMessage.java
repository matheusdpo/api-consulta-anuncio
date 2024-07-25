package br.com.api.consulta_anuncio.domain.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {
    private String status;
    private String message;

    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
