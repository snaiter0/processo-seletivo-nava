package br.sp.sp.portal.cep.application.ports.out;

import br.sp.sp.portal.cep.domain.models.PedidoConsultaCep;

public interface PedidoConsultaCepRepositoryPort {
    PedidoConsultaCep save(PedidoConsultaCep build);

    PedidoConsultaCep findByCep(String cep);
}
