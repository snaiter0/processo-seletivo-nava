package br.sp.sp.portal.cep.application.service;

import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import br.sp.sp.portal.cep.application.ports.in.ConsultaCepPort;
import br.sp.sp.portal.cep.application.ports.out.gateway.ConsultaApiCep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaCepService implements ConsultaCepPort {

    private final ConsultaApiCep consultaApiCep;

    @Override
    public ConsultaCepResposta consultarApiCep(String cep){
        return consultaApiCep.consultarCep(cep);
    }
}
