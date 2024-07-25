package br.com.api.consulta_anuncio.repositories;

import br.com.api.consulta_anuncio.domain.model.AnuncioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Long> {
}
