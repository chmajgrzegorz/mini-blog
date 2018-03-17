package pl.grzegorzchmaj.blog.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorzchmaj.blog.model.dtos.PostDTO;
import pl.grzegorzchmaj.blog.model.entities.Post;
import pl.grzegorzchmaj.blog.model.entities.User;
import pl.grzegorzchmaj.blog.repositories.PostRepository;
import pl.grzegorzchmaj.blog.repositories.UserRepository;

import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;
    ModelMapper modelMapper;


    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public PostDTO createPost(String title, String content, Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        Post post = new Post(title, content);
        optionalUser.ifPresent(user -> post.setUser(user));

        postRepository.save(post);

        return modelMapper.map(post, PostDTO.class);

    }
}
