package SpringBootMongoDB.services;

import SpringBootMongoDB.domain.User;
import SpringBootMongoDB.dto.UserDTO;
import SpringBootMongoDB.repository.UserRepository;
import SpringBootMongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {

        return repo.findAll(); // metodo pronto do repository do springdata

    }

    public User findById(String id) {
            Optional<User> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

    public User insert(User obj){
        return repo.insert(obj);

    }

    public void delete(String id){
        findById(id); // aproveita esse codigo para verificar se existe esse usuario, senao chama exception.
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }



}
