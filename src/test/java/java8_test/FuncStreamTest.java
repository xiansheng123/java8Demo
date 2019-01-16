package java8_test;

import java8_test.entity.Person;
import org.apache.tomcat.jni.Directory;
import org.assertj.core.util.Files;
import org.junit.Test;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FuncStreamTest {
    private final List<Person> personList = new ArrayList<Person> () {
        {
            add (new Person (1, "xuda1", 18, false));
            add (new Person (2, "xuda2", 28, true));
            add (new Person (3, "xuda3", 38, false));
            add (new Person (4, "xuda4", 48, true));
            add (new Person (5, "xuda5", 58, false));
        }
    };

    @Test
    public void myStream() {
        System.out.println (personList);
    }

    @Test
    public void streamForPeek() {
        List<Person> persons = personList.stream ()
                .peek (x -> {
                    if (x.getAge () > 30) {
                        System.out.println (x.getName ());
                    }
                })
                .collect (Collectors.toList ());
    }

    @Test
    public void streamForMap_newArrayList() throws Exception {
        List<String> persons = new ArrayList<> ();
        persons.stream ()
                .collect (Collectors.toList ());
        System.out.println (persons);
    }

    @Test
    public void streamForFirst() throws Exception {
        List<String> persons = new ArrayList<> ();
        System.out.println (persons.stream ()
                .findAny ().isPresent ());
        System.out.println (persons);
    }

    @Test
    public void streamForPredicate() throws Exception {
        filter (personList.get (2), x -> x.getAge () > 30, x -> x.setAge (x.getAge () + 1));
    }

    private Person filter(Person person, Predicate<Person> moreThan30, Consumer<Person> addAge1) {
        if (moreThan30.test (person)) {
            addAge1.accept (person);
        }
        System.out.println (person);
        return person;
    }

    @Test
    public void getCurrentDate() throws Exception {
        Date date1 = Calendar.getInstance ().getTime ();
        Date date2 = new java.sql.Date (System.currentTimeMillis ());

        SimpleDateFormat last1 = new SimpleDateFormat ("yyyy-MM-dd HH:mm:sss");
        SimpleDateFormat last2 = new SimpleDateFormat ("yyyy-MM-dd");
        Timestamp timestamp1 = new Timestamp (System.currentTimeMillis ());
        Timestamp timestamp2 = Timestamp.valueOf (date2 + " 09:00:00");
        Date date3 = last2.parse (date2.toString ());
        int aa = timestamp2.compareTo (date3);
        System.out.println (last1.format (timestamp1));
        System.out.println (last1.format (timestamp2));
    }

    @Test
    public void sortUpFiles() {
        File file = new File ("C:\\Users\\luxuda\\Pictures\\图片\\2018-11-05 zhangjie20181105");
        for (File temp : file.listFiles ()) {
            Date fileDate = new Date (temp.lastModified ());
            String folderFullName = temp.getParent () + "\\20180" + (fileDate.getMonth () + 1);
            if (!new File (folderFullName).exists ()) {
                Files.newFolder (folderFullName);
            }
            File newFile = new File (folderFullName + "\\" + temp.getName ());
            temp.renameTo (newFile);

           if(newFile.exists ())
               System.out.println (newFile.getName ()+"move successfully");
           else
               System.out.println (newFile.getName ()+"move faill");
        }

    }
}