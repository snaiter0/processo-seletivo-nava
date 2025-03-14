package br.sp.sp.portal.cep.application.ports.mappers;

import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultaCepRequest;
import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultarCepResponse;
import br.sp.sp.portal.cep.domain.models.PedidoConsultaCep;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoConsultaCepMapper {

    @Mapping(target = "dataHoraSolicitacaoConsulta",expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(br.sp.sp.portal.cep.application.ports.dtos.enums.StatusPedidoConsultaCepEnum.REGISTRADO)")
    PedidoConsultaCep toPedidoConsultaCep(PedidoConsultaCepRequest pedidoConsultaCepRequest);


    @Mapping(target="consultaCepResposta", source = "response")
    PedidoConsultarCepResponse toPedidoConsultarCepResponse(PedidoConsultaCep pedidoConsultaCep, ConsultaCepResposta response);
}
