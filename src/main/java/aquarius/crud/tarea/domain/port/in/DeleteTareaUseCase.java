package aquarius.crud.tarea.domain.port.in;

import aquarius.crud.tarea.domain.model.Tarea;

public interface DeleteTareaUseCase {
	Tarea execute(Long id);
}
