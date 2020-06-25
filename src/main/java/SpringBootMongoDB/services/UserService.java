package SpringBootMongoDB.services;

import SpringBootMongoDB.domain.User;
import SpringBootMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){

        return repo.findAll(); // metodo pronto do repository do springdata


    }
}
