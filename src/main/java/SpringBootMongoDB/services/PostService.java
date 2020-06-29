package SpringBootMongoDB.services;

import SpringBootMongoDB.domain.Post;
import SpringBootMongoDB.repository.PostRepository;
import SpringBootMongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
            Optional<Post> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }


//    public List<Post> findByTitle (String text){
//        return repo.findByTitleContainingIgnoreCase(text);
//    }
//    esse de cima para usar o metodo pronto do spring

    public List<Post> findByTitle (String text){
        return repo.searchTitle(text);
    }
// esse para usar o query do mongoDB

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
