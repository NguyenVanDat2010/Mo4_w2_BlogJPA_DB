package blog.controller;

import blog.model.Blog;
import blog.service.impl.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute("blog") Blog blog, Model model){
        blogService.save(blog);
        model.addAttribute("success","New customer created successfully!");
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute("blog")Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Blog was updated successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id,Model model){
        blogService.remove(id);
        model.addAttribute("success","Blog was deleted successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/view";
    }
}
