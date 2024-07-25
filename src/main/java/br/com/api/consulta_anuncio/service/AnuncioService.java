package br.com.api.consulta_anuncio.service;

import br.com.api.consulta_anuncio.domain.model.AnuncioModel;
import br.com.api.consulta_anuncio.repositories.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public void save(AnuncioModel anuncioModel) {
        anuncioRepository.save(anuncioModel);
    }

    public List<AnuncioModel> get() {
        return anuncioRepository.findAll();
    }
}
