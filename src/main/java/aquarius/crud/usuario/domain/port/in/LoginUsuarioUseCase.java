package aquarius.crud.usuario.domain.port.in;

import aquarius.crud.usuario.domain.Usuario;

public interface LoginUsuarioUseCase {
	Usuario execute(String username, String password);
}
