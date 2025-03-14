package br.sp.sp.portal.cep.adapters.in;

import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultaCepRequest;
import br.sp.sp.portal.cep.application.ports.in.PedidoConsultaCepPort;
import br.sp.sp.portal.cep.adapters.in.resources.PedidoConsultarCepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cep")
@RequiredArgsConstructor
public class PedidoConsultaCepController {

    private final PedidoConsultaCepPort pedidoConsultaCepPort;

    @PostMapping
    public ResponseEntity<PedidoConsultarCepResponse> registrarPedidoConsultaCep(@RequestBody PedidoConsultaCepRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoConsultaCepPort.consultarCep(request));
    }

    @GetMapping("/{cep}")
    public ResponseEntity<PedidoConsultarCepResponse> registrarPedidoConsultaCep(@PathVariable("cep") String cep){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoConsultaCepPort.consultarCep(cep));
    }
}
