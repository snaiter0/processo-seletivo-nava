package br.sp.sp.portal.cep.application.ports.in;

import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;

public interface ConsultaCepPort {
    ConsultaCepResposta consultarApiCep(String cep);
}
