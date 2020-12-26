package com.group2.wmproducts.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.model.SessionData;
import com.group2.wmproducts.model.UserBean;
import com.group2.wmproducts.repository.CartRepository;
import com.group2.wmproducts.repository.ProductRepository;
import com.group2.wmproducts.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public String createUser(UserBean user) {
		UserWM usermongo = new UserWM(user.getfName(), user.getlName(), user.getmNumber(), user.geteMail(), user.getuPassword());
		this.userRepository.save(usermongo);
		System.out.println("user saved in Mongodb");
		System.out.println(usermongo.toString());
		return usermongo.getId();
	}
	
	@Override
	public String verifyUser(UserBean user) {
		String userPass = user.getuPassword();
		UserWM usermongo = userRepository.findByUserEmail(user.geteMail());
		String dbUserEmailId = null;
		if(usermongo != null) {
			String dbPass = usermongo.getUserPassword();
			if(userPass.equals(dbPass)) {
				System.out.println("Login done");
				dbUserEmailId = usermongo.getUserEmail();
			} else {
				System.out.println("Login not done");
				dbUserEmailId = "";
			}
		}
		return dbUserEmailId;
	}

	@Override
	public void assignCart(String userId) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> cartProducts = new HashMap<String, Integer>();
		cartProducts.put("tshirt", 3);
		CartWM cartmongo = new CartWM(userId);
		cartmongo.setCartProducts(cartProducts);
		this.cartRepository.save(cartmongo);
	}

	@Override
	public String findUserIdbyEmail(String Email) {
		// TODO Auto-generated method stub
		UserWM usermongo = this.userRepository.findByUserEmail(Email);
		return usermongo.getId();
	}

	@Override
	public String addToCart(String userId, String productId, String productQty) {
		// TODO Auto-generated method stub
		CartWM cartmongo = cartRepository.findByUserId(userId);
		HashMap<String, Integer> cartProducts = cartmongo.getCartProducts();
		cartProducts.put(productId, Integer.parseInt(productQty));
		cartmongo.setCartProducts(cartProducts);
		this.cartRepository.save(cartmongo);
		return null;
	}

	@Override
	public HashMap<String, Integer> getCartProducts(String userId) {
		// TODO Auto-generated method stub
		CartWM cartmongo = cartRepository.findByUserId(userId);
		HashMap<String, Integer> cartProductsmongo = cartmongo.getCartProducts();
		return cartProductsmongo;
	}

	@Override
	public ProductBean getCartProduct(String productId) {
		// TODO Auto-generated method stub
		ProductWM productmongo = productRepository.findByProductId(productId);
		ProductBean product = new ProductBean(productmongo.getProductId(), productmongo.getProductName(), productmongo.getProductImage(), productmongo.getProductType(), productmongo.getProductColor(), productmongo.getProductSize(), productmongo.getProductBrand(), productmongo.getProductPrice(), productmongo.getProductQty(), productmongo.getProductSaller(), productmongo.getProductDiscription(), null);
		return product;
	}
}
