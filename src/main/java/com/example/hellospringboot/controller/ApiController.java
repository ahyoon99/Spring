package com.example.hellospringboot.controller;

import com.example.hellospringboot.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 해당 Class는 Rest API를 처리하는 Controller가 된다.
@RequestMapping("/api") // RequestMapping은 URI를 지정해주는 Annotation이다.
public class ApiController {

    // <GET method 만드는 방법>
    // 1) GetMapping을 통해 주소 할당
    @GetMapping("/hello")   // http://localhost:8080/api/hello 라는 주소와 매핑되었다.
    public String hello(){
        return "hello spring boot!";
    }

    @GetMapping(path = "/getHello") // http://localhost:8080/api/getHello 라는 주소와 명시적으로 매핑되었다.
    public String getHello(){
        return "get Hello";
    }

    // 2) RequestParam 방식
    //@RequestMapping(path = "/getHello") // GET/POST/PUT/DELETE 모두 동작한다.
    @RequestMapping(path = "/getHi", method = RequestMethod.GET) // GET에서만 동작한다. http://localhost:8080/api/getHi 라는 주소와 매핑되었다.
    public String getHi(){
        return "get Hi";
    }

    // 3) PathVariable : 변화하는 구간은 이 방식을 사용하여 받는다.
    // http://localhost:8080/api/path-variable/{name} 을 받고싶다.
    @GetMapping("/path-variable/{name}")
    public String PathVariable(@PathVariable String name){
        System.out.println("PathVariable : "+name);
        return name;
    }

    // 3-1) PathVariable사용시, id라는 변수를 이미 사용하고 있을 때
    @GetMapping("/path-variable02/{id}")
    public String PathVariable02(@PathVariable(name = "id") String pathId, String id){
        System.out.println("PathVariable02 : "+pathId);
        return pathId;
    }

    // 4) Query Parameter
    // http://localhost:8080/api/query-param?name=steve&email=etev@gamil.com&age=23
    // 4-1) Map 사용하여 Query Parameter
    @GetMapping(path="/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();

            sb.append(entry.getKey() + " = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    // 4-2) 각 매개변수 하나하나 마다 @RequestParam annotation 붙여주기 , 즉 명시적으로 변수를 받아온다.
    @GetMapping(path="/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    // 4-3) dto 사용 -> 현업에서 제일 많이 사용
    @GetMapping(path="/query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

    // <POST method 만드는 방법>
    // 1) PostMapping을 통해 주소 할당
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : "+stringObjectEntry.getKey());
            System.out.println("value : "+stringObjectEntry.getValue());
        });
    }

    // 2) QueryParameter
    @PostMapping("/post/query-param")
    public void postqueryParam(@RequestBody Map<String, Object> requestData){
        System.out.println(requestData);
    }

}
