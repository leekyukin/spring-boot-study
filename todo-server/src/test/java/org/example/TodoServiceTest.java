package org.example;

import example.example.model.TodoModel;
import example.example.model.TodoRequest;
import example.example.service.repository.TodoRepository;


import example.example.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



// Mock 객체 사용이유
// 외부 시스템에 의존하지 않고 자체 테스트를 실행함.
// 네트워크나 데이터 베이스가 연결되지 않아도 사용 가능.
// 테스트를 할 때 마다  DB의 데이터의 수정이 일어나면 안된다.
@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    // 직접적으로 사용
    @Mock
    private TodoRepository todoRepository;

    // Mock을 주입
    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoModel.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("Test Title");

        TodoModel actual = this.todoService.add(expected);

        assertEquals(expected.getTitle(), actual.getTitle());

    }

    @Test
    void searchById() {
    }
}