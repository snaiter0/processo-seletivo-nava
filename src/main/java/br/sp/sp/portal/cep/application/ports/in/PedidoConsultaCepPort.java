package br.sp.sp.portal.cep.application.ports.in;

import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultaCepRequest;
import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultarCepResponse;

public interface PedidoConsultaCepPort {
    PedidoConsultarCepResponse consultarCep(PedidoConsultaCepRequest request);

    PedidoConsultarCepResponse consultarCep(String cep);
}
