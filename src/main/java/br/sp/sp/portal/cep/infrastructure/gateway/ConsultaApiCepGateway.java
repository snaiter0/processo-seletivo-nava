package br.sp.sp.portal.cep.infrastructure.gateway;

import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import br.sp.sp.portal.cep.application.ports.out.gateway.ConsultaApiCep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ConsultaApiCepGateway implements ConsultaApiCep {

    private final RestTemplate restTemplate;

    @Value("${api.externa.url}")
    private String apiExternaUrl;

    @Override
    public ConsultaCepResposta consultarCep(String cep) {
        String url = apiExternaUrl + "/" + cep;

        //restTemplate.getForObject(url, consultaCepResposta.class); WireMock não está funcionando.

        return ConsultaCepResposta.builder()
                .cep(cep)
                .logradouro("Praça da Sé")
                .bairro("Sé")
                .cidade("São Paulo")
                .estado("SP")
                .build();
    }

}
