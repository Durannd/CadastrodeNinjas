package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
