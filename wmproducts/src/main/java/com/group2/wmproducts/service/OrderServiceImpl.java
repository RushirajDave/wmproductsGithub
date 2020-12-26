package com.group2.wmproducts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.repository.CartRepository;
import com.group2.wmproducts.repository.OrderRepository;
import com.group2.wmproducts.repository.ProductRepository;
import com.group2.wmproducts.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public HashMap<String, Integer> getCart(String userId) {
		// TODO Auto-generated method stub
		CartWM cartmongo = cartRepository.findByUserId(userId);
		HashMap<String, Integer> cartProductsmongo = cartmongo.getCartProducts();
		return cartProductsmongo;
	}

	@Override
	public String findUserIdbyEmail(String Email) {
		// TODO Auto-generated method stub
		UserWM usermongo = this.userRepository.findByUserEmail(Email);
		return usermongo.getId();
	}

	@Override
	public void createOrder(String userId, HashMap<String, Integer> cartProducts) {
		// TODO Auto-generated method stub
		for (Map.Entry<String,Integer> entry : cartProducts.entrySet())  {
			ProductWM product = productRepository.findByProductId(entry.getKey());
			Integer totalPrice = entry.getValue() * Integer.parseInt(product.getProductPrice());
			String address = "avbb";
			OrderWM ordermongo = new OrderWM(userId, product.getProductId(), String.valueOf(entry.getValue()), totalPrice, address);
			this.orderRepository.save(ordermongo);
		}	
	}

	@Override
	public String getMyOrders(String userId) {
		// TODO Auto-generated method stub
		Optional<OrderWM> myOrders = orderRepository.findById(userId);
		//OrderWM myorder2 = myOrders.get();
		System.out.println(myOrders.toString());
		return null;
	}
	
	
}
