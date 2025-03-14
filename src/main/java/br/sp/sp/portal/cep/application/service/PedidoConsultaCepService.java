package br.sp.sp.portal.cep.application.service;

import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultaCepRequest;
import br.sp.sp.portal.cep.application.ports.PedidoConsultaCepPort;
import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import br.sp.sp.portal.cep.application.ports.dtos.PedidoConsultarCepResponse;
import br.sp.sp.portal.cep.application.ports.dtos.enums.StatusPedidoConsultaCepEnum;
import br.sp.sp.portal.cep.application.ports.dtos.mappers.PedidoConsultaCepMapper;
import br.sp.sp.portal.cep.application.ports.out.PedidoConsultaCepRepositoryPort;
import br.sp.sp.portal.cep.application.ports.out.gateway.ConsultaApiCep;
import br.sp.sp.portal.cep.domain.models.PedidoConsultaCep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PedidoConsultaCepService implements PedidoConsultaCepPort {

    private final PedidoConsultaCepRepositoryPort repository;
    private final PedidoConsultaCepMapper mapper;
    private final ConsultaApiCep gateway;


    @Override
    @Cacheable(cacheNames = "consulta-cep")
    public PedidoConsultarCepResponse consultarCep(PedidoConsultaCepRequest request) {

        PedidoConsultaCep pedidoConsulta = repository.save(mapper.toPedidoConsultaCep(request));

        ConsultaCepResposta response = gateway.consultarCep(request.cep());

        try {
            pedidoConsulta.setResposta(new ObjectMapper().writeValueAsString(response));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return PedidoConsultarCepResponse.builder()
                .consultaCepResposta(response)
                .statusPedidoConsultaCep(pedidoConsulta.getStatus().toString())
                .dataHoraSolicitacao(pedidoConsulta.getDataHoraSolicitacaoConsulta())
                .build();
    }

    @Override
    public PedidoConsultarCepResponse consultarCep(String cep) {
        PedidoConsultaCep pedidoConsulta = repository.save(PedidoConsultaCep.builder()
                .cep(cep)
                .status(StatusPedidoConsultaCepEnum.REGISTRADO)
                .build());

        ConsultaCepResposta response = gateway.consultarCep(cep);

        try {
            pedidoConsulta.setResposta(new ObjectMapper().writeValueAsString(response));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return PedidoConsultarCepResponse.builder()
                .consultaCepResposta(response)
                .statusPedidoConsultaCep(pedidoConsulta.getStatus().toString())
                .dataHoraSolicitacao(pedidoConsulta.getDataHoraSolicitacaoConsulta())
                .build();
    }
}
