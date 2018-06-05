package pl.grzegorzchmaj.blog.controllers.restcontrollers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorzchmaj.blog.model.dtos.CommentDTO;
import pl.grzegorzchmaj.blog.model.dtos.PostDTO;
import pl.grzegorzchmaj.blog.model.entities.Comment;
import pl.grzegorzchmaj.blog.model.entities.Post;
import pl.grzegorzchmaj.blog.repositories.PostRepository;
import pl.grzegorzchmaj.blog.services.PostService;

import java.util.Optional;

@RestController
public class PostRestController {

    private PostRepository postRepository;
    private PostService postService;
    private ModelMapper modelMapper;


    @Autowired
    public PostRestController(PostRepository postRepository, PostService postService, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/api/addpost")
    public ResponseEntity<PostDTO> addPost(@RequestParam String title, String content, @RequestParam Long userId){
        PostDTO postDto = postService.createPost(title, content, userId);
        return ResponseEntity.ok().body(postDto);
    }

    @PostMapping("/api/post/{postId}/comment")
    public ResponseEntity<CommentDTO> addPostComment(@PathVariable Long postId, @RequestParam String comment){
        Optional<Post> postOptional = postRepository.findById(postId);
        Comment postComment = new Comment();
        postComment.setComent(comment);

        Post post = postOptional.get();

        post.addComment(postComment);
        post = postRepository.save(post);

        Comment savedComment = post.getComments().get(post.getComments().size() - 1);


        modelMapper.createTypeMap(Comment.class, CommentDTO.class)
                .addMapping(pc -> pc.getAudit().getAdded(), CommentDTO::setAdded);

        return ResponseEntity.ok()
                .body(modelMapper.map(savedComment, CommentDTO.class));

    }
}
