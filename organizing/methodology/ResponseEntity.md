# ResponseEntity
    ResponseEntity 는 HttpEntity 를 상속받음으로써 HttpHeader 와 body 를 가질 수 있다.
    @ResponseBody 와 정확히 똑같은 동작을 하기 때문에 명시하지 않아도 된다.
    상태코드, 응답 메시지 등이 포함될 수 있다.

```java
@RequestMapping(path = "/index")
    public ResponseEntity<T> thisIsMethod(HttpServletResponse response) {
        
        [원하는 동작 구현!]

        return ResponseEntity
                .status([Http의 status])
                .body([Http의 body]);
    }
```

