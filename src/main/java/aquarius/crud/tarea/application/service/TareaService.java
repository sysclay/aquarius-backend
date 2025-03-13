package aquarius.crud.tarea.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aquarius.crud.tarea.application.usecase.CreateTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.DeleteTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.ListTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.UpdateTareaUseCaseImpl;
import aquarius.crud.tarea.domain.model.Tarea;

@Service
public class TareaService {
	
    private final CreateTareaUseCaseImpl createTareaUseCaseImpl;
    private final UpdateTareaUseCaseImpl updateTareaUseCaseImpl;
    private final DeleteTareaUseCaseImpl deleteTareaUseCaseImpl;
    private final ListTareaUseCaseImpl listTareasUseCaseImpl;
    
    public TareaService(CreateTareaUseCaseImpl createTareaUseCaseImpl, UpdateTareaUseCaseImpl updateTareaUseCaseImpl, 
    		DeleteTareaUseCaseImpl deleteTareaUseCaseImpl, ListTareaUseCaseImpl listTareasUseCaseImpl) { 	 
		this.createTareaUseCaseImpl = createTareaUseCaseImpl;
        this.updateTareaUseCaseImpl = updateTareaUseCaseImpl;
        this.deleteTareaUseCaseImpl = deleteTareaUseCaseImpl;
        this.listTareasUseCaseImpl = listTareasUseCaseImpl;
    }
    
    public Tarea create(Tarea tarea) {
    	return createTareaUseCaseImpl.execute(tarea);
    }

    public Tarea update(Long id, Tarea tarea) {
    	return updateTareaUseCaseImpl.execute(id, tarea);
    }

    public Tarea delete(Long id) {
    	return deleteTareaUseCaseImpl.execute(id);
    }

    public List<Tarea> list() {
        return listTareasUseCaseImpl.execute();
    } 

}
