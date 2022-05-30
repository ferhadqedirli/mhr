package az.evimtekstil.mhr.database;

import az.evimtekstil.mhr.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    List<Category> getAllByNameContains(String word);

}
