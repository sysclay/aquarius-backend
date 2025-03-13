package aquarius.crud.usuario.application.service;

import org.springframework.stereotype.Service;

import aquarius.crud.usuario.application.usecase.LoginUsuarioUseCaseImpl;
import aquarius.crud.usuario.domain.Usuario;

@Service
public class UsuarioService {

    private final LoginUsuarioUseCaseImpl loginUsuarioUseCaseImpl;
    
    public UsuarioService(LoginUsuarioUseCaseImpl loginUsuarioUseCaseImpl) {
    	this.loginUsuarioUseCaseImpl=loginUsuarioUseCaseImpl;
    }
    
    public Usuario Login(String username, String password) {
    	return loginUsuarioUseCaseImpl.execute(username, password);
    	
    }
}
