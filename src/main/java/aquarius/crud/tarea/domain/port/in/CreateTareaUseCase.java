package aquarius.crud.tarea.domain.port.in;

import aquarius.crud.tarea.domain.model.Tarea;

public interface CreateTareaUseCase {

	Tarea execute(Tarea tarea);
}
