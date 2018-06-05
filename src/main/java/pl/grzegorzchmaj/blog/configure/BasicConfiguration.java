package pl.grzegorzchmaj.blog.configure;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.grzegorzchmaj.blog.model.dtos.PostDTO;
import pl.grzegorzchmaj.blog.model.dtos.TagDTO;
import pl.grzegorzchmaj.blog.model.entities.Post;
import pl.grzegorzchmaj.blog.model.entities.Tag;

@Configuration
public class BasicConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDTO.class)
                .addMapping(post -> post.getUser().getId(), PostDTO::setUserId)
                .addMapping(p -> p.getAudit().getAdded(), PostDTO::setCreated);

        modelMapper.createTypeMap(Tag.class, TagDTO.class)
                .addMapping(tag -> tag.getAudit().getAdded(), TagDTO::setCreated);

        return modelMapper;

    }
}
