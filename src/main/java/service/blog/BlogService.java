package service.blog;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BlogRepository;

public class BlogService implements IBlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void update(Blog model) {
        blogRepository.save(model);
    }

    @Override
    public void save(Blog model) {
        blogRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }
}
