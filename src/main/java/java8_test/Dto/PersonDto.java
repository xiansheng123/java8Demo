package java8_test.Dto;

import lombok.Value;


@Value
public class PersonDto extends PersonBase {
    private Integer id;
    private String name;
    private Integer age;
    private Boolean sex;
    private CountryCode contryCode;
    @Value
    static  class  CountryCode{
        private Integer id;
        private String  groupName;
        private String  codename;
    }
}
