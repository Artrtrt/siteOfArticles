package ru.artem.siteofarticles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/siteOfArticles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public String showArticle(@PathVariable("id") int id, Model model){
    model.addAttribute("article", articleService.findById(id));
    return "show";
}

    @GetMapping("/downloadPage")
    public String showDownloadPage(Model model) {
        model.addAttribute("article",new Article());
        return "downloadPage";
    }

    @PostMapping()
    public String create(@ModelAttribute("article") @Valid Article article,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "downloadPage";
        }

        articleService.save(article);
        return "redirect:/siteOfArticles";
    }

    @GetMapping()
    public String showHomePage(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "homePage";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("article", articleService.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("article") @Valid Article article,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("article", articleService.findById(id));
            return "edit";
        }
        articleService.update(id, article);
        return "redirect:/siteOfArticles";
    }
    /*
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("article") @Valid Article article,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }
        articleService.update(article);
        return "redirect:/siteOfArticles";
    }*/

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        articleService.delete(id);
        return "redirect:/siteOfArticles";
    }
}