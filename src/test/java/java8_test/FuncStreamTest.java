package java8_test;

import java8_test.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FuncStreamTest {
    private final List<Person> personList = new ArrayList<Person>() {
        {
            add(new Person(1, "xuda1", 18, false));
            add(new Person(2, "xuda2", 28, true));
            add(new Person(3, "xuda3", 38, false));
            add(new Person(4, "xuda4", 48, true));
            add(new Person(5, "xuda5", 58, false));
        }
    };

    @Test
    public void myStream() throws Exception {
        System.out.println(personList);
    }

    @Test
    public void streamForPeek() throws Exception {
        List<Person> persons = personList.stream()
                .peek(x -> {
                    if (x.getAge() > 30) {
                        System.out.println(x.getName());
                    }
                })
                .collect(Collectors.toList());
    }

    @Test
    public void streamForMap_newArrayList() throws Exception {
        List<String> persons = new ArrayList<>();
        persons.stream()
                .collect(Collectors.toList());
        System.out.println(persons);
    }

    @Test
    public void streamForFirst() throws Exception {
        List<String> persons = new ArrayList<>();
        System.out.println(persons.stream()
                .findAny().isPresent());
        System.out.println(persons);
    }

    @Test
    public void streamForPredicate() throws Exception {
        filter(personList.get(2),x->x.getAge()>30,x->x.setAge(x.getAge()+1));
    }
    private Person filter(Person person, Predicate<Person> moreThan30, Consumer<Person> addAge1) {
        if (moreThan30.test(person)) {
            addAge1.accept(person);
        }
        System.out.println(person);
        return person;
    }

}