package br.com.api.consulta_anuncio.domain.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table(name = "anuncios")
@Entity
public class AnuncioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double valor;

    @Lob
    private String imagem;

    public AnuncioModel() {

    }

    public AnuncioModel(Long id, String nome, String descricao, Double valor, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    public AnuncioModel(String nome, String descricao, Double valor, String imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }


    @Override
    public String toString() {
        return "AnuncioModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", base64='" + imagem + '\'' +
                '}';
    }
}
