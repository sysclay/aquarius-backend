package aquarius.crud.tarea.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aquarius.crud.tarea.application.usecase.CreateTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.DeleteTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.ListTareaUseCaseImpl;
import aquarius.crud.tarea.application.usecase.UpdateTareaUseCaseImpl;
import aquarius.crud.tarea.domain.port.out.TareaRepositoryPort;
import aquarius.crud.tarea.infrastructure.repository.JpaTareaRepositoryAdapter;

@Configuration
public class TareaConfiguration {

	//@Bean
    //protected TareaService tareaService(CreateTareaUseCaseImpl createTareaUseCaseImpl, UpdateTareaUseCaseImpl updateTareaUseCaseImpl, 
    //		DeleteTareaUseCaseImpl deleteTareaUseCaseImpl, ListTareaUseCaseImpl listTareasUseCaseImpl) {	
    //    return new TareaService(createTareaUseCaseImpl, updateTareaUseCaseImpl, deleteTareaUseCaseImpl, listTareasUseCaseImpl);
    //}
	
	@Bean
	protected CreateTareaUseCaseImpl createTareaUseCaseImpl(TareaRepositoryPort repository) {
        return new CreateTareaUseCaseImpl(repository);
    }
    
	@Bean
	protected UpdateTareaUseCaseImpl updateTareaUseCaseImpl(TareaRepositoryPort repository) {
        return new UpdateTareaUseCaseImpl(repository);
    }
	@Bean
	protected DeleteTareaUseCaseImpl deleteTareaUseCaseImpl(TareaRepositoryPort repository) {
        return new DeleteTareaUseCaseImpl(repository);
    }

	@Bean
	protected ListTareaUseCaseImpl listTareaUseCaseImpl(TareaRepositoryPort repository) {
        return new ListTareaUseCaseImpl(repository);
    }

	@Bean
	protected TareaRepositoryPort tareaRepositoryPort(JpaTareaRepositoryAdapter adapter) {
        return adapter;
    }
    
}
