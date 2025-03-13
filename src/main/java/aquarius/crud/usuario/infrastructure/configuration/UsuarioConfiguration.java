package aquarius.crud.usuario.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aquarius.crud.usuario.application.usecase.LoginUsuarioUseCaseImpl;
import aquarius.crud.usuario.domain.port.in.LoginUsuarioUseCase;
import aquarius.crud.usuario.domain.port.out.UsuarioRepositoryPort;
import aquarius.crud.usuario.infrastructure.repository.JpaUsuarioRepository;
import aquarius.crud.usuario.infrastructure.repository.JpaUsuarioRepositoryAdapter;

@Configuration
public class UsuarioConfiguration {

    @Bean
    protected UsuarioRepositoryPort usuarioRepositoryPort(JpaUsuarioRepository jpaUsuarioRepository) {
        return new JpaUsuarioRepositoryAdapter(jpaUsuarioRepository);
    }

    @Bean
    protected LoginUsuarioUseCase loginUsuarioUseCase(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new LoginUsuarioUseCaseImpl(usuarioRepositoryPort);
    }
}
