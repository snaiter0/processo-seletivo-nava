package br.sp.sp.portal.cep.adapters.out;

import br.sp.sp.portal.cep.application.ports.out.PedidoConsultaCepRepositoryPort;
import br.sp.sp.portal.cep.domain.models.PedidoConsultaCep;
import br.sp.sp.portal.cep.infrastructure.persistence.PedidoConsultaCepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PedidoConsultaCepRepositoryAdapter implements PedidoConsultaCepRepositoryPort {

    private final PedidoConsultaCepRepository pedidoConsultaCepRepository;

    @Override
    public PedidoConsultaCep save(PedidoConsultaCep pedidoConsultaCep) {
        return pedidoConsultaCepRepository.save(pedidoConsultaCep);
    }

    @Override
    public PedidoConsultaCep findByCep(String cep) {
        return pedidoConsultaCepRepository.findByCep(cep);
    }
}
