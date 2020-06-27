package SpringBootMongoDB.config;

import SpringBootMongoDB.domain.Post;
import SpringBootMongoDB.domain.User;
import SpringBootMongoDB.dto.AuthorDTO;
import SpringBootMongoDB.dto.CommentDTO;
import SpringBootMongoDB.repository.PostRepository;
import SpringBootMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.aggregation.DateOperators;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        postRepository.deleteAll();

        Post post1 = new Post(null,sdf.parse("21/03/2018"), "pariu viagem", "Vou viajar para SP", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acorde Feliz hoje", new AuthorDTO(maria));

        CommentDTO com1 = new CommentDTO("Boa Viagem Mano", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO com2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO com3 = new CommentDTO("Tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(com1,com2));
        post2.getComments().addAll(Arrays.asList(com2));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);

    }


}
