package aquarius.crud.usuario.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import aquarius.crud.usuario.domain.Usuario;
import aquarius.crud.usuario.domain.port.in.LoginUsuarioUseCase;
import aquarius.crud.usuario.domain.port.out.UsuarioRepositoryPort;

@Service
public class LoginUsuarioUseCaseImpl implements LoginUsuarioUseCase {
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;
	//private final TokenService tokenService; // Para generar el token
	
    public LoginUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		// TODO Auto-generated constructor stub
    	this.usuarioRepositoryPort = usuarioRepositoryPort;
    	//this.tokenService = tokenService;
	}

	@Override
	public Usuario execute(String username, String password) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuarioOpt = usuarioRepositoryPort.findByUsername(username);
		
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        if(!usuario.getPassword().equals(password)) {
        	throw new IllegalArgumentException("Credenciales inválidas");
        }
    	//return tokenService.generateToken(username);
    	//return "TOken-";
        return usuario;
	}

}
