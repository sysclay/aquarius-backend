package aquarius.crud.tarea.infrastructure.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aquarius.crud.tarea.application.usecase.CreateTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.DeleteTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.ListTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.UpdateTareaUseCaseImpl;
import aquarius.crud.tarea.domain.model.Tarea;

@RestController
@RequestMapping("/tareas")
public class TareaController {

	@Autowired
    private final CreateTareaUseCaseImpl createTareaUseCaseImpl;
    private final UpdateTareaUseCaseImpl updateTareaUseCaseImpl;
    private final DeleteTareaUseCaseImpl deleteTareaUseCaseImpl;
    private final ListTareaUseCaseImpl listTareaUseCaseImpl;
    
    public TareaController(CreateTareaUseCaseImpl createTareaUseCaseImpl,UpdateTareaUseCaseImpl updateTareaUseCaseImpl, 
    		DeleteTareaUseCaseImpl deleteTareaUseCaseImpl, ListTareaUseCaseImpl listTareaUseCaseImpl ) {
    	this.createTareaUseCaseImpl = createTareaUseCaseImpl;
    	this.updateTareaUseCaseImpl = updateTareaUseCaseImpl;
    	this.deleteTareaUseCaseImpl = deleteTareaUseCaseImpl;
    	this.listTareaUseCaseImpl = listTareaUseCaseImpl;
	}
    
    @PostMapping
    public ResponseEntity<Tarea> createTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = createTareaUseCaseImpl.execute(tarea);
        return ResponseEntity.ok(nuevaTarea);
    }
    
    @GetMapping
    public ResponseEntity<List<Tarea>> getAllTareas() {
        List<Tarea> tareas = listTareaUseCaseImpl.execute();
        return ResponseEntity.ok(tareas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tarea) {

        try {
            Tarea updatedTarea = updateTareaUseCaseImpl.execute(id, tarea);
            return ResponseEntity.ok(updatedTarea);
        } catch (IllegalArgumentException e) {
        	System.out.print("ERROR 20");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTarea(@PathVariable Long id) {
    	Map<String, String> response = new HashMap<>();
        try {
        	deleteTareaUseCaseImpl.execute(id); // ✅ Ahora no devuelve nada
        	response.put("message", "Tarea successfully deleted");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("message", "Tarea not deleted");
            return ResponseEntity.ok(response);
        }
    }
    
}
