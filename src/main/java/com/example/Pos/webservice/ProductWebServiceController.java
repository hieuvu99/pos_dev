package com.example.Pos.webservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pos.business.ProductService;
import com.example.Pos.data.Product;

@RestController
@RequestMapping("/api")
public class ProductWebServiceController {
	private final ProductService productService;
	
	public ProductWebServiceController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(path = "/products", method = RequestMethod.GET)
	public List<Product> getProduct(Model model) {
		return this.productService.getAllProduct();
	}
	
	@RequestMapping(path = "/products", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}
	
	@RequestMapping(path = "/products", method = RequestMethod.PUT)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product updateProduct(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}
	
	@RequestMapping(path = "/products/deletes-product", method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity deleteProducts(@RequestBody Long[] productIDArray) {
		 this.productService.deleteProducts(productIDArray);
		 return ResponseEntity.ok().build(); 
	}
}
