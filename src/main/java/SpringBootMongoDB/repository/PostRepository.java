package SpringBootMongoDB.repository;

import SpringBootMongoDB.domain.Post;
import SpringBootMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post,String> {

    @Query ("{ 'title': { $regex: ?0 , $options: 'i' } }")
    List<Post> searchTitle(String text);

    public List<Post> findByTitleContainingIgnoreCase (String text);
    }
//    metodo pronto do spring. não esta sendo usado agora.
