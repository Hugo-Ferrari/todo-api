package hugo.todo_api.service;

import hugo.todo_api.model.Task;
import hugo.todo_api.model.User;

import hugo.todo_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository; // <-- o IntelliJ deve sugerir o import correto aqui

    public List<Task> listarPorUsuario(User user) {
        return taskRepository.findByUser(user);
    }

    public Task criar(Task task) {
        return taskRepository.save(task);
    }

    public Task atualizar(Long id, Task taskAtualizada) throws Throwable {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setTitle(taskAtualizada.getTitle());
        task.setDescription(taskAtualizada.getDescription());
        task.setStatus(taskAtualizada.getStatus());

        return taskRepository.save(task);
    }

    public void deletar(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        taskRepository.deleteById(id);
    }
}