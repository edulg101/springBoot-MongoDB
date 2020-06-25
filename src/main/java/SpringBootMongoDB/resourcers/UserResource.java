package SpringBootMongoDB.resourcers;

import SpringBootMongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){  // ResponseEntity for encapsulation.
        User maria = new User("1","maria", "maria@gmail.com");
        User alex = new User("2","alex", "alex@gmail.com");
        List<User> usersList = new ArrayList<>();
        usersList.add(maria);
        usersList.add(alex);
        return ResponseEntity.ok().body(usersList);
    }





}
