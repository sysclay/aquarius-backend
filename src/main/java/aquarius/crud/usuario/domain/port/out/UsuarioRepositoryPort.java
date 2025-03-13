package aquarius.crud.usuario.domain.port.out;

import java.util.Optional;

import aquarius.crud.usuario.domain.Usuario;

public interface UsuarioRepositoryPort {
	Optional<Usuario> findByUsername(String username);
}
