package orm_practice.practice.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import orm_practice.practice.model.DemoTest;
import orm_practice.practice.repository.StudentRepository;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)

class BillInfoServiceTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    StudentService studentService;
    @MockBean
    StudentRepository studentRepository;

    @Test
    void getData() {
        DemoTest test = restTemplate.getForObject("http://localhost:"+port+"/api/getDemo?id=2", DemoTest.class);
        System.out.println(test.toString());
        assertTrue(test.getId()==2);
        assertEquals("tushar", test.getName());
//        assertTrue(test.getId()==2);
    }
    @Test
    void testing(){

    }
}