package br.sp.sp.portal.cep.application.ports.dtos;

import lombok.Builder;

@Builder
public record ConsultaCepResposta(String cep,
                                  String logradouro,
                                  String bairro,
                                  String cidade,
                                  String estado) {
}
