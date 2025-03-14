package br.sp.sp.portal.cep.application.ports.out.gateway;

import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;

public interface ConsultaApiCep {
    ConsultaCepResposta consultarCep(String cep);
}
