package aquarius.crud.tarea.domain.port.in;

import java.util.List;

import aquarius.crud.tarea.domain.model.Tarea;

public interface ListarTareaUseCase {
	List<Tarea> execute();
}
