package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Repository;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
