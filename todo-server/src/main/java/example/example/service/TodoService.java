package example.example.service;

import example.example.model.TodoModel;
import example.example.model.TodoRequest;
import lombok.AllArgsConstructor;
import example.example.service.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoModel add (TodoRequest request) {
        TodoModel todoModel = new TodoModel();
        todoModel.setTitle(request.getTitle());
        todoModel.setOrder(request.getOrder());
        todoModel.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoModel);
    }

    public TodoModel searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    // orElseThrow : 값이 없다면 에러가 나게 코드를 짜는것 흔한 패턴. But, if문 쓰면 마이 복잡타~
    }


    public List<TodoModel> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoModel updateById(Long id, TodoRequest request) {
        TodoModel todoModel = this.searchById(id);
        if (request.getTitle() != null) {
            todoModel.setTitle(request.getTitle());
        }
        if (request.getOrder() != null) {
            todoModel.setOrder(request.getOrder());
        }
        if (request.getCompleted() != null) {
            todoModel.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoModel);
    }
    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAll() {
        this.todoRepository.deleteAll();
    }

}
