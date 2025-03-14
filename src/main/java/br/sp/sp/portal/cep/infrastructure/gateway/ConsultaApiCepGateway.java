package br.sp.sp.portal.cep.infrastructure.gateway;

import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import br.sp.sp.portal.cep.application.ports.out.gateway.ConsultaApiCep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConsultaApiCepGateway implements ConsultaApiCep {

    private final RestTemplate restTemplate;

    @Value("${api.externa.url}")
    private String apiExternaUrl;

    @Override
    public ConsultaCepResposta consultarCep(String cep) {
        String url = apiExternaUrl  + cep;

        log.info("Consultando CEP na URL: {}", url);

        return restTemplate.getForObject(url, ConsultaCepResposta.class);
    }

}
