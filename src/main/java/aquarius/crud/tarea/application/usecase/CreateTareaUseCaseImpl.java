package aquarius.crud.tarea.application.usecase;


import aquarius.crud.tarea.domain.model.Tarea;
import aquarius.crud.tarea.domain.port.in.CreateTareaUseCase;
import aquarius.crud.tarea.domain.port.out.TareaRepositoryPort;


public class CreateTareaUseCaseImpl implements CreateTareaUseCase {
	
	private final TareaRepositoryPort tareaRespositoryPort;
	
    public CreateTareaUseCaseImpl(TareaRepositoryPort tareaRespositoryPort) {
		// TODO Auto-generated constructor stub
    	this.tareaRespositoryPort = tareaRespositoryPort;
	}
    
    @Override
    public Tarea execute(Tarea tarea) {
        if (tarea == null) {
            throw new IllegalArgumentException("Tarea must not be null");
        }
    	return tareaRespositoryPort.save(tarea);
    }
    
}
