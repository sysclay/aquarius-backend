package aquarius.crud.usuario.infrastructure.adapter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aquarius.crud.usuario.application.usecase.LoginUsuarioUseCaseImpl;
import aquarius.crud.usuario.domain.Usuario;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
    private final LoginUsuarioUseCaseImpl loginUsuarioUseCaseImpl;
	
	public UsuarioController(LoginUsuarioUseCaseImpl loginUsuarioUseCaseImpl) {
		this.loginUsuarioUseCaseImpl=loginUsuarioUseCaseImpl;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario loginRequest){
		try {
            Usuario  usuario = loginUsuarioUseCaseImpl.execute(loginRequest.getUsername(), loginRequest.getPassword());
            usuario.setPassword(null);
            return ResponseEntity.ok(usuario);
        } catch (IllegalArgumentException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Usuario no encontrado");
            return ResponseEntity.ok(errorResponse);
        } 
		
		
		

	}
	
}
