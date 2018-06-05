package pl.grzegorzchmaj.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.grzegorzchmaj.blog.model.entities.Post;
import pl.grzegorzchmaj.blog.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/search")
    public String search(@RequestParam String searchPhrase, Model model){
        List<Post> posts = postRepository
                .findAllByTitleContainsOrContentContains(searchPhrase, searchPhrase);
        model.addAttribute("posts", posts);
        model.addAttribute("searchPhrase", searchPhrase);
        return "posts";
    }
}
