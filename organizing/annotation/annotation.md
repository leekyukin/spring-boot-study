# Annotation organizing 

<sup>(하나씩 채워나갈 예정)</sup> 

## 🤫 
--------------------------------

## ComponentScan


----

- *@ResponseBody* 
    
    메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body에 쓰임

- *@RequestBody 변수* 

    Request의 body부분의 데이터를 변수에 저장한다.

- *@Restcontoller*
    
     @controller + @ReqsponesBody

- *@RequestParam*

    **url :  /create-developer<span style="color:purple">?name=kyukin2&age=17</span>**
    <br>
    <br>
    Http GET 방식으로 위와 같은 <span style="color:purple">quary parameter</span> 형식으로 변수에 데이터를 저장한다. 

    * 사실 @RequestParam은 생략이 가능하다.  
    * 기본적값으로 (required=false)로 필수값이 아니게 된다. 
    * 파라미터 변수 앞에 어노테이션을 붙이면 (required=true)로 그 변수는 필수값이 된다. 
