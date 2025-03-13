package aquarius.crud.tarea.domain.port.out;

import java.util.List;
import java.util.Optional;

import aquarius.crud.tarea.domain.model.Tarea;

public interface TareaRepositoryPort {
    Tarea save(Tarea tarea); // Para crear o actualizar un usuario
    Tarea deleteById(Long id); // Para eliminar un usuario por ID
    Optional<Tarea> findById(Long id); // Para obtener un usuario por ID
    List<Tarea> findAll();        // Para listar todos los usuarios
}
