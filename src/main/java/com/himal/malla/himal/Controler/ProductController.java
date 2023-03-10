package com.himal.malla.himal.Controler;

import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping("/save")
    public Product saveMan(@RequestBody Product product){
return productService.save(product);
    }

    @PostMapping("/saveAll")
    public List<Product> saveAll(@RequestBody List<Product> productList){
        return productService.saveAll(productList);
    }


    @GetMapping("/products")
    public List<Product> findAllProduct(){
        return productService.getProducts();
    }

    @GetMapping("/productId/{id}")
    public Product findProductById(@PathVariable Integer productId){
        return productService.getProductById(productId);
    }

//    @GetMapping("/manId/{id}")
//    public UserEntity findBooksByUserId(@PathVariable long id){
//        return booksService.getBooksByUserId(id);
//    }

//    @GetMapping("/books/{name}")
//    public BooksEntity findBooksByName(@PathVariable String name){
//        return booksService.getBooksByName(name);
//    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer productId){
        return productService.deleteProduct(productId);
    }

}
