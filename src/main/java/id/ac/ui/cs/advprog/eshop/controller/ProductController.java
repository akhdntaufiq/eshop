package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "ProductList";
    }

    @PostMapping("/edit/{productId}")
    public String editProductPost(@ModelAttribute Product product, @PathVariable("productId") String productID, Model model) {
        service.edit(product, productID);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(Model model, @PathVariable("productId") String productId) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/delete/{productID}")
    public String deleteProductPost(Model model, @PathVariable("productID") String productID) {
        service.delete(productID);
        return "redirect:/product/list";
    }
}