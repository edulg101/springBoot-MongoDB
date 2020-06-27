package SpringBootMongoDB.repository;

import SpringBootMongoDB.domain.Post;
import SpringBootMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <Post,String> {

}
