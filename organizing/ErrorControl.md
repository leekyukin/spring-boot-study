## At properties

- 기본 화이트라벨 에러 페이지 비활성화
    server.error.whitelabel.enabled=false

## At view

- templates에 error.html을 만들면 에러페이지로 인식하고 에러 발생시 자동 맵핑된다.

## At controller

```java
@RequestMapping("/error") 
public String error() {
    return "error";
}
```
- errorController method를 구현한다.
- @RequestMapping을 사용한 이유는 GET, POST 모든 요청을 받기 위해서이다. 
- 그냥 만들기만 하면 기본적으로 동작하는 errorController와 스팩이 같기 때문에 충돌하여 에러가 발생한다.  
우리가 완전히 errorController에 대한 제어권을 가져오기 위해서는 marker interface인  ErrorController라는 클레스를 implements해야한다. 

- **marker inferface란?**
    
    ```
    기본적인 인터페이스와 동일하지만 아무런 메소드가 없다.
    때문에 단지 타입을 체크하는 용도로 사용된다.
    ```

