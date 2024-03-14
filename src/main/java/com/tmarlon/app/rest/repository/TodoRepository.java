package com.tmarlon.app.rest.repository;

import com.tmarlon.app.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
}
