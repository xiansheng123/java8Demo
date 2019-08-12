package java8_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class QuestTestTest {

    @Test
    public void RemoveSomeElement() {
        List<String> stringList = new ArrayList<> (Arrays.asList (
                "lu",
                "zhangjie",
                "zhangsan",
                "lu",
                "zhangjie",
                "liming"));
        List<String> subList = new ArrayList<String> () {{
            add ("lu");
            add ("zhangjie");
        }};
        stringList.removeAll (subList);
        stringList.remove ("zhangsan");
        System.out.println (stringList.stream ().collect (Collectors.joining (",")));

    }

}