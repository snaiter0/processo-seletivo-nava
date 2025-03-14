package br.sp.sp.portal.cep.domain.models;

import br.sp.sp.portal.cep.application.ports.dtos.enums.StatusPedidoConsultaCepEnum;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "pedido_consulta_cep", schema = "cep")
@AllArgsConstructor
public class PedidoConsultaCep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "dat_hora_soli_cslt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "dd-MM-yyyy@HH-mm-ssss")
    private LocalDateTime dataHoraSolicitacaoConsulta;

    @Column(name = "exchange_cslt")
    private String exchangeConsulta;

    @Column(name = "resposta")
    private String resposta;

    @Column(name = "status_cslt", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedidoConsultaCepEnum status;

    @PostConstruct
    public void setDataHoraSolicitacaoConsultaNow() {
        setDataHoraSolicitacaoConsulta(LocalDateTime.now());
    }
}
