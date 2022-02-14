# MockMvc :running:
    MockMvc는 웹 어플리케이션을 애플리케이션 서버에 배포하지 않고
    테스트용 MVC환경을 만들어 요청 및 전송, 응답기능을 제공해주는 유틸리티 클래스다.

## 주입하기 :syringe:

1. ### :mag: @AutoConfigureMockMvc 의 일반적인 방법
    
    ```java
    @AutoConfigureMockMvc
    @SpringBootTest // Test임을 명시하는 어노테이션
    class BaseControllerTest {

        @Autowired
        private MockMvc mvc;
    }
    ```
    MockMvc 를 복잡한 설정 과정을 거치지 않고
    @Autowired 를 통해서 바로 주입 받을 수 있다.

2. ### :mag: @AutoconfigureMockMvc 와 테스트 함수의 파라미터로 받는 방법

    ```java
    @AutoConfigureMockMvc
    @SpringBootTest 
    class BaseControllerTest {
        void test (@Autowired MockMvc mvc){
            // Given

            // When & Then

        }
    }
    ```
    첫번째 방법처럼 파라미터로 받는 방식도 @AutoWired를 붙여줘야 한다.

3. ### :mag: 생성자

    ```java
    @SpringBootTest 
    class BaseControllerTest {

        private MockMvc mvc; // 생성자 주입 방식을 위한 선언

        public BaseControllerTest(@Autowired MockMvc mvc) {
            this.mvc = mvc;
        }
    }
    ```

## 사용하기 :tool:

