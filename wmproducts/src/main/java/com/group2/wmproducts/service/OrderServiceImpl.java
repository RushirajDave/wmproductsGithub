package com.group2.wmproducts.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.wmproducts.model.OrderBean;
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
	public String emptyCart(String userId) {
		// TODO Auto-generated method stub
		CartWM cartmongo = cartRepository.findByUserId(userId);
		HashMap<String, Integer> cartProducts = cartmongo.getCartProducts();
		cartProducts.clear();
		cartmongo.setCartProducts(cartProducts);
		this.cartRepository.save(cartmongo);
		return null;
	}

	@Override
	public List<String> createOrder(String userId, HashMap<String, Integer> cartProducts) {
		// TODO Auto-generated method stub
		List<String> orders = new ArrayList<String>();
		for (Map.Entry<String,Integer> entry : cartProducts.entrySet())  {
			ProductWM product = productRepository.findByProductId(entry.getKey());
			Integer totalPrice = entry.getValue() * Integer.parseInt(product.getProductPrice());
			String address = "avbb";
			OrderWM ordermongo = new OrderWM(userId, product.getProductId(), String.valueOf(entry.getValue()), totalPrice, address);
			OrderWM ordersaved = this.orderRepository.save(ordermongo);
			orders.add(ordersaved.getOrderId());
		}
		return orders;
	}

	@Override
	public List<OrderBean> getMyOrders(String userId) {
		// TODO Auto-generated method stub
		List<OrderWM> ordersWMmongo = orderRepository.findByUserId(userId);
		List<OrderBean> orderbeanList = new ArrayList<OrderBean>();
		for (int i=0; i<ordersWMmongo.size(); i++) {
			OrderBean orderbean = new OrderBean(ordersWMmongo.get(i).getOrderId(), ordersWMmongo.get(i).getUserId(), ordersWMmongo.get(i).getProductId(), ordersWMmongo.get(i).getProductQty(), String.valueOf(ordersWMmongo.get(i).getTotalPrice()), ordersWMmongo.get(i).getOrderAddress());
			orderbeanList.add(orderbean);
		}
		//OrderWM myorder2 = myOrders.get();
		//System.out.println(orderbean);
		return orderbeanList;
	}

	@Override
	public List<OrderBean> getAllOrders() {
		// TODO Auto-generated method stub
		System.out.println("all orders");
		//ordersWMmongo = new ArrayList<OrderWM>();
		List<OrderWM> ordersWMmongo = orderRepository.findAll();
		List<OrderBean> ordersBeanmongo = new ArrayList<OrderBean>();
		for (int i=0; i<ordersWMmongo.size(); i++) {
			OrderBean orderbean = new OrderBean(ordersWMmongo.get(i).getOrderId(), ordersWMmongo.get(i).getUserId(), ordersWMmongo.get(i).getProductId(), ordersWMmongo.get(i).getProductQty(), String.valueOf(ordersWMmongo.get(i).getTotalPrice()), ordersWMmongo.get(i).getOrderAddress());
			ordersBeanmongo.add(orderbean);
		}
		return ordersBeanmongo;
	}

	@Override
	public List<ProductBean> getProducts(List<OrderBean> orders) {
		// TODO Auto-generated method stub
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		for(OrderBean order : orders) {
			ProductWM productWM = productRepository.findByProductId(order.getProductId());
			ProductBean product = new ProductBean(productWM.getProductId(), productWM.getProductName(), productWM.getProductImage(), productWM.getProductType(), productWM.getProductColor(), productWM.getProductSize(), productWM.getProductBrand(), productWM.getProductPrice(), productWM.getProductQty(), productWM.getProductSaller(), productWM.getProductDiscription(), "");
			productBeanList.add(product);
		}
		return productBeanList;
	}
}
