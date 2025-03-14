package br.sp.sp.portal.cep.infrastructure.persistence;

import br.sp.sp.portal.cep.domain.models.PedidoConsultaCep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoConsultaCepRepository extends JpaRepository<PedidoConsultaCep, Long> {
    PedidoConsultaCep findByCep(String cep);
}
