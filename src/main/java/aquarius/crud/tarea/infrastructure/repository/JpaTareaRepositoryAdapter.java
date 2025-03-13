package aquarius.crud.tarea.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import aquarius.crud.tarea.domain.model.Tarea;
import aquarius.crud.tarea.domain.port.out.TareaRepositoryPort;

@Primary
@Repository
@Component
public class JpaTareaRepositoryAdapter implements TareaRepositoryPort {
	
    private final JpaTareaRepository jpaTareaRepository;

    public JpaTareaRepositoryAdapter(JpaTareaRepository jpaTareaRepository) {
        this.jpaTareaRepository = jpaTareaRepository;
    }
    

	@Override
	public Tarea save(Tarea tarea) {
		// TODO Auto-generated method stub
		return jpaTareaRepository.save(tarea);
	}

	@Override
	public Tarea deleteById(Long id) {
		// TODO Auto-generated method stub
		//jpaTareaRepository.deleteById(id);
		Optional<Tarea> tarea = jpaTareaRepository.findById(id);
	    tarea.ifPresent(jpaTareaRepository::delete);
	    return tarea.orElse(null); // Devuelve la tarea eliminada o null si no existe
	}

	@Override
	public Optional<Tarea> findById(Long id) {
		// TODO Auto-generated method stub
		return jpaTareaRepository.findById(id);
	}

	@Override
	public List<Tarea> findAll() {
		// TODO Auto-generated method stub
		return jpaTareaRepository.findAll();
	}

}
