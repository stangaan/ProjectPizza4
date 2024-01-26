
import com.example.probe.entity.Users;
import com.example.probe.ProbeApplication;
import com.example.probe.repository.UsersRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static javax.management.Query.value;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ProbeApplication.class)
public class IntegrationTest {
@Value(value = "${local.server.port}")
private int port;
@Autowired
private UsersRepository usersRepository;
@Resource
    private TestRestTemplate restTemplate;
@Autowired
private MockMvc mockMvc;
@Autowired
private ObjectMapper objectMapper;


  @Test
public void testReadUsers(){
      HttpHeaders headers = new HttpHeaders();
      headers.setBasicAuth("admin","admin");
      headers.add("content-type","application/json");
      HttpEntity<String>request = new HttpEntity<>(headers);
     ResponseEntity<Users> response = restTemplate.exchange("http://localhost:" +port + "/api/user/get-user/1",
             HttpMethod.GET, request, Users.class);
       assertEquals(response.getBody(),response.getBody());
      assertEquals(HttpStatus.OK, response.getStatusCode());
        }
   @Test
 public void createUsers() {

    HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        HttpEntity<String> reguest = new HttpEntity<>
                ("{\"username\": \"admin\" , " +
                        "\"password\": \"admin\", " +
                        "\"roles\":\"admin\", " +
                        "\"firstName\": \"Stengauar\"," +
                        "\"lastName\": \"Andrei\"," +
                        "\"station\": \"IT\"," +
                        "\"E_mail\": \"nan.2005@mail.ru\"}",
                        headers
                 );
    assertEquals(usersRepository.count(),7);
       ResponseEntity<String> request = restTemplate.postForEntity(
                "http://localhost:" + port +"/api/user/create-users", reguest,String.class);
       assertEquals(usersRepository.count(), 7);
       assertEquals("User created","User created");

    }


}