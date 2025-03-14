package br.sp.sp.portal.cep.application.ports.dtos.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusPedidoConsultaCepEnum {
    REGISTRADO,
    CONSULTANDO,
    CONSULTA_CONCLUIDA,
    ERRO_CONSULTA_TIMEOUT;

    private String descricao;

    StatusPedidoConsultaCepEnum(StatusPedidoConsultaCepEnum statusPedidoConsultaCepEnum) {
        this.descricao = statusPedidoConsultaCepEnum.getDescricao();
    }
}
