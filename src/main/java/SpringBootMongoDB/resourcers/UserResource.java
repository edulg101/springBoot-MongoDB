package SpringBootMongoDB.resourcers;

import SpringBootMongoDB.domain.User;
import SpringBootMongoDB.dto.UserDTO;
import SpringBootMongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){  // ResponseEntity for encapsulation.
        List<User> usersList = service.findAll();
        List<UserDTO> usersDTOList = usersList.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTOList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {  // ResponseEntity for encapsulation.
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {  // ResponseEntity for encapsulation.
         User obj =service.fromDTO(objDTO);
         obj = service.insert(obj);
         // codigo abaixo para retornar uma reposta com o caminho do endereço criado:
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
         return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {  // ResponseEntity for encapsulation.
        service.delete(id);
        // codigo abaixo para retornar cod 204:
        return ResponseEntity.noContent().build();
    }





}
