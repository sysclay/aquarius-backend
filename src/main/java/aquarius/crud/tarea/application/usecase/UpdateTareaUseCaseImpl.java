package aquarius.crud.tarea.application.usecase;

import java.util.Optional;

import aquarius.crud.tarea.domain.model.Tarea;
import aquarius.crud.tarea.domain.port.in.UpdateTareaUseCase;
import aquarius.crud.tarea.domain.port.out.TareaRepositoryPort;

public class UpdateTareaUseCaseImpl implements UpdateTareaUseCase{
	
	private final TareaRepositoryPort tareaRepositoryPort;
	
	public UpdateTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
		this.tareaRepositoryPort=tareaRepositoryPort;
	}
	
	@Override
	public Tarea execute(Long id, Tarea tarea) {
		
        if (id == null) {
            throw new IllegalArgumentException("Tarea or its ID must not be null");
        }
        
		Optional<Tarea> existingTarea = tareaRepositoryPort.findById(id);
		if(existingTarea.isPresent()) {
			Tarea existing  = existingTarea.get();
			existing.setCompletada(tarea.getCompletada());
			return tareaRepositoryPort.save(existing);
		} else {
			throw new IllegalArgumentException("Tarea with given ID does not exist");
		}
	}

}
