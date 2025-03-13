package aquarius.crud.tarea.application.usecase;



import java.util.Optional;

import aquarius.crud.tarea.domain.model.Tarea;
import aquarius.crud.tarea.domain.port.in.DeleteTareaUseCase;
import aquarius.crud.tarea.domain.port.out.TareaRepositoryPort;


public class DeleteTareaUseCaseImpl implements DeleteTareaUseCase {

	private final TareaRepositoryPort tareaRepositoryPort;
	
	public DeleteTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
		this.tareaRepositoryPort=tareaRepositoryPort;
	}
	
	@Override
    public Tarea execute(Long id) {
		Optional<Tarea> tarea = tareaRepositoryPort.findById(id);
		//System.out.print("AKI ESOTY");
	    if (tarea.isPresent()) {
	        tareaRepositoryPort.deleteById(id);
	        return tarea.get();
	    } else {
	        throw new IllegalArgumentException("Tarea with ID " + id + " not found");
	    }
    }
	
}
