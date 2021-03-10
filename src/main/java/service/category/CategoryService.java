package service.category;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryRepository;

public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void update(Category model) {

    }

    @Override
    public void save(Category model) {

    }

    @Override
    public void remove(Long id) {

    }
}
