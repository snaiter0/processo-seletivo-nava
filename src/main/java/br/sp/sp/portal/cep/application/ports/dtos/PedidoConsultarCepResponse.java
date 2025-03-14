package br.sp.sp.portal.cep.application.ports.dtos;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
public record PedidoConsultarCepResponse(ConsultaCepResposta consultaCepResposta,
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "dd-MM-yyyy@HH-mm-ssss")
                                        LocalDateTime dataHoraSolicitacao,
                                        String statusPedidoConsultaCep) {
}
