package com.dbserver.agenda.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dbserver.agenda.models.AgendaModel;

public interface AgendaRepository extends CrudRepository <AgendaModel, String> {
	
	Iterable<AgendaModel> findById(Long id);
	void deleteById(Long id);
	
}
