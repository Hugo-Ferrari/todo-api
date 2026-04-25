package hugo.todo_api.controller;


import hugo.todo_api.model.Task;
import hugo.todo_api.model.User;
import hugo.todo_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/{userId}")
    public List<Task> listar (@PathVariable Long userId ){
        User user = new User();
        user.setId(userId);

        return ResponseEntity.ok(taskService.listarPorUsuario(user)).getBody();
    }

    @PostMapping
    public ResponseEntity<Task> criar(@RequestBody Task task){
        return ResponseEntity.ok(taskService.criar(task));
    }
    @PutMapping("{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody Task task) throws Throwable {
        return ResponseEntity.ok(taskService.atualizar(id,task));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id ){
        taskService.deletar(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso");

    }
}
