package com.baeldung.application.repositories;

import com.baeldung.application.entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{}
