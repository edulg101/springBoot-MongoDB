package SpringBootMongoDB.services;

import SpringBootMongoDB.domain.User;
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

}
