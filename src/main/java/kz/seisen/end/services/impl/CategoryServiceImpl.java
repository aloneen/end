package kz.seisen.end.services.impl;



import kz.seisen.end.dto.CategoryDto;
import kz.seisen.end.mappers.CategoryMapper;
import kz.seisen.end.models.Category;
import kz.seisen.end.repositories.CategoryRepository;
import kz.seisen.end.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;



    public List<CategoryDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


    public CategoryDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }


    public CategoryDto create(CategoryDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }


    public CategoryDto update(Long id, CategoryDto dto) {

        CategoryDto oldCategory = getById(id);

        if (Objects.isNull(oldCategory) || Objects.isNull(dto)) {
            return null;
        }

        oldCategory.setNameDto(dto.getNameDto());


        return mapper.toDto(repository.save(mapper.toEntity(oldCategory)));


    }


    public boolean delete(Long id) {
        repository.deleteById(id);
        Category category = repository.findById(id).orElse(null);

        if (Objects.isNull(category)) {
            return true;
        }

        return false;
    }
}
