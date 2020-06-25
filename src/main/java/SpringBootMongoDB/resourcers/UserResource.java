package SpringBootMongoDB.resourcers;

import SpringBootMongoDB.domain.User;
import SpringBootMongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){  // ResponseEntity for encapsulation.
        List<User> usersList = service.findAll();
        return ResponseEntity.ok().body(usersList);
    }





}
