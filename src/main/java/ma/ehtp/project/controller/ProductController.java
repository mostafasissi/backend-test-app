package ma.ehtp.project.controller;

import ma.ehtp.project.entities.Product;
import ma.ehtp.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllObjects() {
        List<Product> objects = productService.getAllProducts();
        return ResponseEntity.ok(objects);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addObject(@RequestBody Product object) {
        productService.addProduct(object);
        return ResponseEntity.ok(object);
    }

    @PostMapping("/addRandomProduct")
    public ResponseEntity<Object> addRandomObject() {
        productService.addRandomProduct();
        return ResponseEntity.ok("Object with random values added successfully");
    }
}

