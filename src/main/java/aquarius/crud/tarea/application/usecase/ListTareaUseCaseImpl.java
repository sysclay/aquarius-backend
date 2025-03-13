package aquarius.crud.tarea.application.usecase;

import java.util.List;


import aquarius.crud.tarea.domain.model.Tarea;
import aquarius.crud.tarea.domain.port.in.ListarTareaUseCase;
import aquarius.crud.tarea.domain.port.out.TareaRepositoryPort;

public class ListTareaUseCaseImpl implements ListarTareaUseCase {

	private final TareaRepositoryPort tareaRepositoryPort;
	
	public ListTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
		this.tareaRepositoryPort=tareaRepositoryPort;
	}
	
	@Override
    public List<Tarea> execute() {
        return tareaRepositoryPort.findAll();
    }
}
