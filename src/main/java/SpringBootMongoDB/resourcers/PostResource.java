package SpringBootMongoDB.resourcers;

import java.util.Date;
import java.util.List;

import SpringBootMongoDB.resourcers.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SpringBootMongoDB.domain.Post;
import SpringBootMongoDB.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        // text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
//    para Pesquisar no postman:
//    http://localhost:8080/posts/titlesearch?text=expressão que presente buscar.


    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate){

        text = URL.decodeParam(text);
        Date min = URL.convertData(minDate, new Date(0L));
        Date max = URL.convertData(maxDate, new Date());

        List<Post> posts = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);

       // exemplo de search:
        // http://localhost:8080/posts/fullsearch?text=bom&maxDate=2018-03-23

    }

}
