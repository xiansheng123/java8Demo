package java8_test;

import java8_test.Dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @PostMapping(value = "/getOnePerson")
    public Object getOnePerson(@RequestBody PersonDto personDto) {
        return personDto;
    }

    @PostMapping(value = "/test")
    public String test() {
        return "call test";
    }

    //just test master changes
}
