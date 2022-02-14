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

    ## 사용하기 :computer:

    ```java
    @AutoConfigureMockMvc
    @SpringBootTest // Test임을 명시하는 어노테이션
    class BaseControllerTest {

        @DisplayName("[view] [GET] 기본 페이지 요청")
        @Test                                                       
        void givenNothing_whenRequestingRootPage_thenReturnsIndexPage(@Autowired MockMvc mvc) throws Exception {
            // Given

            // When & Then
            mvc.perform(get("/")) 
                    .andExpect(status().isOk()) // status 정상
                    .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                    // 그냥 contentType() 을 사용할 경우 사실은 content의 contentType은
                    // chatset=UTF-8이 더 추가 되어 있기 때문에 같지 않다고 뜬다.
                    .andExpect(content().string(containsString("This is default page.")))
                    .andExpect(view().name("index"))
                    .andDo(print());
                   
                }
        }   
    ```

- .perform([http method(ex: GET,POST, ...)!]("[URL!]")) http method의 URL에서 test 할낍니다~
- andExpect([검증할것들!]) : 검증을 수행하게 해준다. 모든 Expect가 통과해야만 테스트를 통과한다.
- andDo([행동!]) : 검증 후 할 행동

    - **status().isOk**  : Http status가 정상인가
    - **content().contentType([content의 타입!])** : content의 타입과 [content의 타입!]이 같은가 
    - **content().contentTypeCompatibleWith([content의 타입!])**  : content의 타입에 [content의 타입!]이 포함되어 있는가                 
    - **content().string()** : content 에서 body 를 뜻함
    - **containsString("[값!]")** : 감싸는 메소드에 값이 포함 되어있는지 확인
    - **view.name("[값!]")** : view 의 이름이 index 인지 확인 
    - **print()** : test 결과를 출력한다.
