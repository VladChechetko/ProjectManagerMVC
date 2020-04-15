package ru.school.mvc.taskmvc.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.school.mvc.taskmvc.entity.Project;
import ru.school.mvc.taskmvc.entity.Task;
import ru.school.mvc.taskmvc.repository.ProjectRepository;
import ru.school.mvc.taskmvc.repository.TaskRepository;

/**
 * @author Denis Volnenko
 */
@Service
@Transactional
public class TaskService {

	@Autowired
    private TaskRepository taskRepository;

	@Autowired
    private ProjectRepository projectRepository;

    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        Task t = new Task();
        t.setName(name);
        return taskRepository.save(t);
    }

    public Task getTaskById(final String id) {
    	Task t = taskRepository.getOne(Long.valueOf(id));
    	t.getProject();
        return t;
    }

    public Task merge(final Task task) {
		if (task.getProjectId()!=null) {
			Project p = projectRepository.getOne(task.getProjectId());
			task.setProject(p);
		}
        return taskRepository.save(task);
    }

    public void removeTaskById(final String id) {
        taskRepository.deleteById(Long.valueOf(id));
    }

    public List<Task> getListTask() {
        return taskRepository.findAll();
    }

    public void clear() {
        taskRepository.deleteAll();
    }

    public Task createTaskByProject(final String projectId, final String taskName) {
        Project project = projectRepository.getOne(Long.valueOf(projectId));
        if (project == null) return null;
        Task t = new Task();
        t.setName(taskName);
        t.setProject(project);
        return taskRepository.save(t);
    }

    public Task getByOrderIndex(Long id) {
    	return taskRepository.getOne(id);
    }

    public void merge(Task... tasks) {
    	for (Task t : tasks) {
    		taskRepository.save(t);
    	}
    }

    public void load(Task... tasks) {
    	for (Task t : tasks) {
    		taskRepository.save(t);
    	}
    }

    public void load(Collection<Task> tasks) {
    	for (Task t : tasks) {
    		taskRepository.save(t);
    	}
    }

    public void removeTaskByOrderIndex(Long id) {
        taskRepository.deleteById(id);
    }

}
