
import com.example.probe.Entity.Users;
import com.example.probe.Repository.UsersRepository;
import com.example.probe.Service.UsersService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @LocalServerPort
    private int port;

    private UsersRepository usersRepository;

    private UsersService usersService;


    @Autowired
    private TestRestTemplate restTemplate;

   @Test
public void testReadUsers(){
       ResponseEntity<Users> response = restTemplate.getForEntity("http://localhost:" + port + "api/users/1", Users.class);
       assertEquals(HttpStatus.OK, response.getStatusCode());
       assertEquals("John", response.getBody().getFirstName());
       assertEquals("John", response.getBody().getLastName());
       assertEquals("nan,2005@mail.ru", response.getBody().getEMail());
   }
 public void createUsers() {

    HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        HttpEntity<String> reguest = new HttpEntity<>
                ("{\"username\": \"admin\"} , " +
                        "\"password\": \"admin\", " +
                        "\"roles\":\"admin\", " +
                        "\"firstName\": \"Stengauar\"," +
                        "\"lastName\": \"Andrei\"," +
                        "\"station\": \"IT\"," +
                        "\"E_mail\": \"nan.2005@mail.ru\"}",
                        headers
                 );
    assertEquals(usersRepository.count(),2);
       String result = restTemplate.postForEntity(
                "http://localhost:" + port + "/all-users", reguest, String.class).getBody();
        assertEquals(usersRepository.count(),2);
        assertEquals(result, "User created");

    }
}