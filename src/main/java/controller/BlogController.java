package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.blog.IBlogService;
import service.category.ICategoryService;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping()
    public ModelAndView index(){
        Iterable<Blog> listBlog = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("index","listBlog", listBlog);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView createBlog(){
        ModelAndView modelAndView = new ModelAndView("create", "blog", new Blog());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create", "blog", new Blog());
        modelAndView.addObject("message", "Tạo mới thành công");
        return modelAndView;
    }
}

