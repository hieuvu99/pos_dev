package com.example.Pos.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.Pos.data.Product;
import com.example.Pos.data.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	
	public List<Product> getAllProduct(){
		return this.productRepository.findAll();
	}


	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			if(product == null)
				throw new RuntimeException("Product can not be empty");
			else
				return this.productRepository.save(product);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return null;
		}
	}


	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			Product updateProduct;
			if(product == null)
				throw new RuntimeException("Product can not be empty");
			else
				{
				Optional<Product> updatedProductOptional = this.productRepository.findById(product.getProductID());
				if(updatedProductOptional.isEmpty())
					throw new RuntimeException("Can not found the product");
				else
					{
//						updateProduct = updatedProductOptional.get();
						System.out.println(product.toString());
						return this.productRepository.save(product);
					}	
				}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return null;
		}
	}


	public void deleteProducts(Long[] productIDArray) {
		// TODO Auto-generated method stub
		try {
			Stream<Long> productIDStream = Arrays.stream(productIDArray);
			productIDStream.forEach(id -> 
			{
				Product deleteProduct;
				Optional<Product> deleteProductOptional = this.productRepository.findById(id);
				if(!deleteProductOptional.isEmpty())
				{
					deleteProduct = deleteProductOptional.get();
					this.productRepository.delete(deleteProduct);
				}
				
			});
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}
