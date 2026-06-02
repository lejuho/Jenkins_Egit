package student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class StudentManagerTest {
    static StudentManager manager;

    @BeforeAll
    public static void setUp(){
        manager = new StudentManager(); // 테스트
    }

    @Test
    @Order(1)
    public void testAddStudent(){
        manager.addStudent("홍길동");

        Assertions.assertTrue(manager.hasStudent("홍길동"));
    }

    @Test
    @Order(2)
    public void testAddStudentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> manager.addStudent("홍길동"));
    }

    @Test
    @Order(3)
    public void testRemoveStudent(){
        manager.removeStudent("홍길동");

        Assertions.assertFalse(manager.hasStudent("홍길동"));
    }

    @Test
    @Order(4)
    public void testRemoveStudentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->manager.removeStudent("홍길동"));
    }
}
