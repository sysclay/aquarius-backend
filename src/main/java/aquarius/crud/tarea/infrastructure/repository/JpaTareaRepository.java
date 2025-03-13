package aquarius.crud.tarea.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aquarius.crud.tarea.domain.model.Tarea;

public interface JpaTareaRepository extends JpaRepository<Tarea, Long> {

}
