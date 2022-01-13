package example.example.web;


import example.example.model.TodoModel;
import example.example.model.TodoRequest;
import example.example.model.TodoResponse;
import example.example.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        log.info("CREATE");

        // ObjectUtils.isEmpty : 값의 유무 판단 (= if (data != null))
        if (ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();
        if (ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);
        if (ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);
        TodoModel result = this.service.add(request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        log.info("READ ONE");

        TodoModel result = this.service.searchById((id));
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        log.info("READ ALL");

        List<TodoModel> list = this.service.searchAll();
        List<TodoResponse> responses = list.stream().map(TodoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PatchMapping
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody  TodoRequest request) {
        log.info("UPDATE");

        TodoModel result = this.service.updateById(id, request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        log.info("DELETE");
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        log.info("DELETE ALL");
        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }



}
