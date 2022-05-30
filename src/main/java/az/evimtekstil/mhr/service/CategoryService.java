package az.evimtekstil.mhr.service;

import az.evimtekstil.mhr.core.*;
import az.evimtekstil.mhr.database.CategoryRepo;
import az.evimtekstil.mhr.entity.Category;
import az.evimtekstil.mhr.entity.dto.CategoryDto;
import az.evimtekstil.mhr.enums.SuccessCode;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepo repo;

    public CategoryService(CategoryRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public Result save(CategoryDto categoryDto) {
        try {
            Category category = new Category(categoryDto);
            return new SuccessDataResult<>(repo.save(category), SuccessCode.SAVED);
        } catch (Exception e) {
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }

    @Transactional
    public Result update(CategoryDto categoryDto) {
        try {
            Category category = repo.getReferenceById(categoryDto.getCategoryId());
            category.setName(categoryDto.getName());
            return new SuccessDataResult<>(repo.save(category), SuccessCode.UPDATED);
        } catch (Exception e) {
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }

    @Transactional
    public Result remove(Integer categoryId) {
        try {
            repo.deleteById(categoryId);
            return new SuccessDataResult<>(SuccessCode.DELETED);
        } catch (Exception e) {
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }

    public DataResult<List<CategoryDto>> all() {
        try {
            List<Category> categories = repo.findAll();
            return new SuccessDataResult<>(getCategoryDtos(categories), SuccessCode.DATA_LISTED
                    .getMessage("Categories"));
        } catch (Exception e) {
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }

    @Transactional
    public DataResult<CategoryDto> byId(Integer id) {
        try {
            Category category = repo.getReferenceById(id);
            CategoryDto categoryDto = new CategoryDto(category);
            return new SuccessDataResult<>(categoryDto, SuccessCode.DATA_LISTED
                    .getMessage("Categories"));
        } catch (Exception e) {
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }

    public DataResult<List<CategoryDto>> allByContaining(String word) {
        try {
            List<Category> categories = repo.getAllByNameContains(word);
            return new SuccessDataResult<>(getCategoryDtos(categories), SuccessCode.DATA_LISTED
                    .getMessage("Categories"));
        } catch (Exception e) {
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }

    private List<CategoryDto> getCategoryDtos(List<Category> categories) {
        return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

}
