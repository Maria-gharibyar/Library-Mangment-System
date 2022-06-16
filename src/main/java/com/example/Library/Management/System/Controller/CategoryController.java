package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.savecategorz.Book3Dto;
import com.example.Library.Management.System.DTO.savecategorz.CategoryDto;
import com.example.Library.Management.System.Entitiy.Book;
import com.example.Library.Management.System.Entitiy.Category;
import com.example.Library.Management.System.Services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Category")

public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @PostMapping("SaveCategory")
    public ResponseEntity<CategoryDto> SaveCategory(@RequestBody Category category){
        Category category1 = categoryServices.theBookCategory(category);

        return new ResponseEntity<CategoryDto>(convert(category1), HttpStatus.CREATED);
    }
    @GetMapping("GetCategory")
    public List<Category> getAllCategory(){
        List<Category> getCategory=categoryServices.getAllCategory();
        return getCategory;
    }
    @PutMapping("UpdateCategory")
    public ResponseEntity<Category> updateCategory(@PathVariable("id")long id,@RequestBody Category category){
        return new ResponseEntity<Category>(categoryServices.updateCategory(category,id),HttpStatus.OK);
    }
    @DeleteMapping("DeleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id")long id){
        String categoryDelete=categoryServices.deleteCategory(id);
        return new ResponseEntity<String>(" category "   + categoryDelete +" successfully Deleted!",HttpStatus.OK);
    }
    @Autowired
    private ModelMapper modelMapper;
    private CategoryDto convert(Category category) {
       CategoryDto c = modelMapper.map(category, CategoryDto.class);
        return c;
    }
}
