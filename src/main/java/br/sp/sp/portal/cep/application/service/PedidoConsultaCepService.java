package br.sp.sp.portal.cep.application.service;

import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultaCepRequest;
import br.sp.sp.portal.cep.application.ports.in.PedidoConsultaCepPort;
import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultarCepResponse;
import br.sp.sp.portal.cep.application.ports.dtos.enums.StatusPedidoConsultaCepEnum;
import br.sp.sp.portal.cep.application.ports.mappers.PedidoConsultaCepMapper;
import br.sp.sp.portal.cep.application.ports.out.PedidoConsultaCepRepositoryPort;
import br.sp.sp.portal.cep.domain.models.PedidoConsultaCep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PedidoConsultaCepService implements PedidoConsultaCepPort {

    private final PedidoConsultaCepRepositoryPort repository;
    private final ConsultaCepService consultaCepService;
    private final PedidoConsultaCepMapper mapper;
    private final ObjectMapper objectMapper;


    @Override
    public PedidoConsultarCepResponse consultarCep(PedidoConsultaCepRequest request) {

        PedidoConsultaCep pedidoConsulta = repository.save(mapper.toPedidoConsultaCep(request));

        ConsultaCepResposta response = consultaCepService.consultarApiCep(request.cep());

        try {
            pedidoConsulta.setResposta(objectMapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        pedidoConsulta.setStatus(StatusPedidoConsultaCepEnum.CONSULTA_CONCLUIDA);
        return mapper.toPedidoConsultarCepResponse(repository.saveAndFlush(pedidoConsulta), response);
    }

    @Override
    public PedidoConsultarCepResponse consultarCep(String cep) {

        PedidoConsultaCep consultaByCep = repository.findByCep(cep);

        ConsultaCepResposta response;
        if(consultaByCep!=null){
            try {
                response = objectMapper.readValue(consultaByCep.getResposta(), ConsultaCepResposta.class) ;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return mapper.toPedidoConsultarCepResponse(repository.saveAndFlush(consultaByCep), response);
        }else{
            consultaByCep = repository.save(PedidoConsultaCep.builder()
                    .cep(cep)
                    .dataHoraSolicitacaoConsulta(LocalDateTime.now())
                    .status(StatusPedidoConsultaCepEnum.CONSULTANDO)
                    .build());

            response = consultaCepService.consultarApiCep(cep);

            try {
                consultaByCep.setResposta(objectMapper.writeValueAsString(response));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        consultaByCep.setStatus(StatusPedidoConsultaCepEnum.CONSULTA_CONCLUIDA);
        return mapper.toPedidoConsultarCepResponse(repository.saveAndFlush(consultaByCep), response);
    }
}
