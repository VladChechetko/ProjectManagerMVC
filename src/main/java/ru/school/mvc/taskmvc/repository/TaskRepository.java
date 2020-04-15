package ru.school.mvc.taskmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.school.mvc.taskmvc.entity.Task;

/**
 * @author Denis Volnenko
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
