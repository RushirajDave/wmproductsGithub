package com.group2.wmproducts.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void newProduct(ProductBean product, MultipartFile productImg) {
		
		try {
			Binary BinaryProductImage = new Binary(BsonBinarySubType.BINARY, productImg.getBytes());
			ProductWM productmongo = new ProductWM(product.getProductId(), product.getProductName(), BinaryProductImage, product.getProductCatagory(), product.getProductPrice(), product.getProductQty(), product.getProductSaller(), product.getProductDiscription(), 0);
			this.productRepository.save(productmongo);
			System.out.println("user saved in Mongodb");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ProductBean findProduct(String productId) {
		// TODO Auto-generated method stub
		ProductWM productmongo = productRepository.findByProductId(productId);
		ProductBean product = new ProductBean(productmongo.getProductName(), productmongo.getProductImage(), null, productmongo.getProductCatagory(), productmongo.getProductPrice(), productmongo.getProductQty(), productmongo.getProductSaller(), productmongo.getProductDiscription(), null);
		return product;
	}

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductBean> productList = new ArrayList<ProductBean>();
		List<ProductWM> productmongoList = productRepository.findAll();
		for (int i=0; i<productmongoList.size(); i++) {
			ProductBean product= new ProductBean(productmongoList.get(i).getProductName(), productmongoList.get(i).getProductImage(), null, productmongoList.get(i).getProductCatagory(), productmongoList.get(i).getProductPrice(), productmongoList.get(i).getProductQty(), productmongoList.get(i).getProductSaller(), productmongoList.get(i).getProductDiscription(), null);
            productList.add(product);
		}
		return productList;
	}

}
