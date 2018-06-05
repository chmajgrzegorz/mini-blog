package pl.grzegorzchmaj.blog.controllers.restcontrollers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.grzegorzchmaj.blog.model.dtos.PostDTO;
import pl.grzegorzchmaj.blog.model.dtos.TagDTO;
import pl.grzegorzchmaj.blog.model.entities.Post;
import pl.grzegorzchmaj.blog.model.entities.Tag;
import pl.grzegorzchmaj.blog.repositories.PostRepository;
import pl.grzegorzchmaj.blog.repositories.TagRepository;

import java.util.List;
import java.util.Set;

@RestController
public class TagRestController {

    private TagRepository tagRepository;
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TagRestController(TagRepository tagRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.tagRepository = tagRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/tag")
        public ResponseEntity<TagDTO> createTag(@RequestParam String tagName){
            Tag tag = new Tag();
            tag.setTagName(tagName);
            tagRepository.save(tag);

            TagDTO tagDto = modelMapper.map(tag, TagDTO.class);
            return ResponseEntity.ok().body(tagDto);

    }

    @PutMapping("/tag/addToPost")
    public ResponseEntity<PostDTO> addTagToPost(@RequestParam Long tagId, @RequestParam Long postId ){
        Tag tag = tagRepository.getOne(tagId);
        Post post = postRepository.getOne(postId);
        post.getTags().add(tag);
        postRepository.save(post);

        return ResponseEntity.ok().body(modelMapper.map(post, PostDTO.class));
    }

    @GetMapping("/tags")
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }
}
