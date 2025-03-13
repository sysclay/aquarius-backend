package aquarius.crud.usuario.infrastructure.repository;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import aquarius.crud.usuario.domain.Usuario;
import aquarius.crud.usuario.domain.port.out.UsuarioRepositoryPort;

@Primary
@Repository
@Component
public class JpaUsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final JpaUsuarioRepository jpaUsuarioRepository;

    public JpaUsuarioRepositoryAdapter(JpaUsuarioRepository jpaUsuarioRepository) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }
    
	@Override
	public Optional<Usuario> findByUsername(String username) {
		// TODO Auto-generated method stub
		return jpaUsuarioRepository.findByUsername(username);
	}

}
