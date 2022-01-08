import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String args[]) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("hong");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        System.out.println(user);

        // < 기본적인 object mapper 방식 >
        String json = objectMapper.writeValueAsString(user);    // object를 string으로 바꿔준다.
        System.out.println(json); // -> json validator로 결과값 확인해보기

        // < json node에 접근하는 방법 >
        JsonNode jsonNode = objectMapper.readTree(json);
        // 1. name, age 각각 파싱하기 : 미리 변수 타입을 알 수 있을 때만 사용할 수 있다.
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : "+_name+", age : "+_age);

        // 2. carList 파싱하기
//        String _list = jsonNode.get("cars").asText();   // asList()이런건 없어서 String으로 리턴해보겠다.
//        System.out.println(_list);  // -> 그 결과, 아무 것도 출력되지 않는다. 이렇게 하는게 아니다!!!

        // cars는 json의 새로운 node이다. 더 자세히 말하면 배열의 node이다.
        JsonNode cars = jsonNode.get("cars");   // cars는 array node이다.
        ArrayNode arrayNode = (ArrayNode) cars; // cars를 ArrayNode로 타입을 변환시켜준다.
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});   // convertValue() : object를 우리가 원하는 class로 매핑시켜준다.
        System.out.println(_cars);

        // < json 값을 변경해보기 >
        // JsonNode 객체 클래스에서는 특정 json의 값을 변경할 수 없도록 해두었다.
        // ObjectNode에서는 값을 변경할 수 있다.
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name","steve");
        objectNode.put("age",20);
        System.out.println(objectNode.toPrettyString());    // toPrettyString() : json을 예쁘게 출력해준다.
    }
}
