package br.sp.sp.portal.cep.infrastructure.configuration;

import br.sp.sp.portal.cep.infrastructure.persistence.PedidoConsultaCepRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = PedidoConsultaCepRepository.class)
public class RepositoriesConfiguration {
}
