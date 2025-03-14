package br.sp.sp.portal.cep.adapters.in.resources;

import br.sp.sp.portal.cep.application.ports.dtos.ConsultaCepResposta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
public record PedidoConsultarCepResponse(ConsultaCepResposta consultaCepResposta,
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                                        LocalDateTime dataHoraSolicitacaoConsulta,
                                         String status) {
}
