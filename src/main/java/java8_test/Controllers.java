package java8_test;

import java8_test.Dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @PostMapping(name = "/getOnePerson")
    public Object getOnePerson(@RequestBody PersonDto personDto){
        PersonDto aa= personDto;
        return aa;
    }
}
