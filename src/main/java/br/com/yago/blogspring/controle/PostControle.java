package br.com.yago.blogspring.controle;

import br.com.yago.blogspring.model.Post;
import br.com.yago.blogspring.service.PostServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/posts")
public class PostControle {

    @Autowired
    private PostServico servico;

    @GetMapping()
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = servico.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getDetalhamentoPost (@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("detalhamentoPost");
        Post post = servico.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping("/novoPost")
    public ModelAndView getPostForm(){
        ModelAndView mv = new ModelAndView("novoPost");
        mv.addObject("post", new Post());
        return mv;
    }

    @PostMapping("/novoPost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/novoPost";
        }
        servico.save(post);
        return "redirect:/posts";
    }
}