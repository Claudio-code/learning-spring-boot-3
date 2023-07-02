package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/hello-word")
@RestController
public class HelloWordController {

    // http get request
    // http://localhost:8080/hello-word

    @GetMapping
    public String helloWord() {
        return "Hello again";
    }

    // http get request
    // http://localhost:8080/hello-word/value

    @GetMapping("{value}")
    public List<String> pathVariable(@PathVariable String value) {
        return List.of("Test", value);
    }

    // http get request
    // http://localhost:8080/hello-word/new-hello?value=dream

    @GetMapping("new-hello")
    public Map<String, String> requestVariable(@RequestParam("value") String value) {
        final var hasMap = new HashMap<String, String>();
        hasMap.put("test2", value);
        return hasMap;
    }


    // http post request
    // curl --location 'http://localhost:8080/hello-word' --header 'Content-Type: application/json' --data '{ "name": "notfound", "id": 404 }'

    @PostMapping
    public List<RequestBodyValues> postRequest(@RequestBody RequestBodyValues values) {
        final var defaultValues = new RequestBodyValues("soneca", 2L);
        return List.of(values, defaultValues);
    }

    record RequestBodyValues(String name, Long id) {
    }

}
