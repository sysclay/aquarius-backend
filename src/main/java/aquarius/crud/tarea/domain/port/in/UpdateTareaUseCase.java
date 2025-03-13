package aquarius.crud.tarea.domain.port.in;

import aquarius.crud.tarea.domain.model.Tarea;

public interface UpdateTareaUseCase {
	Tarea execute(Long id, Tarea tarea);
}
