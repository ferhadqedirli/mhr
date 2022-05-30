package az.evimtekstil.mhr.controller;

import az.evimtekstil.mhr.core.DataResult;
import az.evimtekstil.mhr.core.Result;
import az.evimtekstil.mhr.entity.Category;
import az.evimtekstil.mhr.entity.dto.CategoryDto;
import az.evimtekstil.mhr.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(@RequestBody CategoryDto categoryDto) {
        return service.save(categoryDto);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CategoryDto categoryDto) {
        return service.update(categoryDto);
    }

    @DeleteMapping ("/remove")
    public Result remove(@RequestParam Integer id) {
        return service.remove(id);
    }

    @GetMapping("/all")
    public DataResult<List<CategoryDto>> all() {
        return service.all();
    }

    @GetMapping("/all-by_containing")
    public DataResult<List<CategoryDto>> allByContaining(@RequestParam String word) {
        return service.allByContaining(word);
    }

    @GetMapping("/by-id")
    public DataResult<CategoryDto> getById(@RequestParam Integer id) {
        return service.byId(id);
    }

}
