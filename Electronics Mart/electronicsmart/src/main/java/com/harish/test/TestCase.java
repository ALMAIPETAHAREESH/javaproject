package com.harish.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.harish.config.ApplicationContextConfig;
import com.harish.dao.CartDao;
import com.harish.dao.CartItemDao;
import com.harish.dao.CategoryDao;
import com.harish.dao.ProductDao;
import com.harish.dao.UserDao;
import com.harish.model.Cart;
import com.harish.model.CartItem;
import com.harish.model.Category;
import com.harish.model.Product;
import com.harish.model.UserDetails;

public class TestCase 
{
	
	public static void main(String[] ar)
	{
		@SuppressWarnings({ "resource" })
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	
		
		//usertestcase
		/*UserDao userdao = (UserDao) context.getBean("userdao");
		UserDetails user = new UserDetails();
		
		user.setUserName("SaiBaba");
		user.setPassword("password@123");
		user.setEmail("rama@gmail.com");
		user.setRole("ROLE_ADMIN");
		user.setIs_Active(true);
		user.setMobile("7890909045");
		userdao.addUsers(user);	*/
	
		
	//category test case
		
		/*CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
		
		Category category = new Category();
		category.setCategoryName("MensWear");
		categoryDAO.newCategory(category);*/
		
		
		//product test case
		/*CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
		ProductDao productDAO= (ProductDao) context.getBean("productDAO");
		Product product = new Product();
		product.setProductName("Samsung Smart tv");
		product.setProductPrice(560000);
		product.setQuantity(2);
		product.setStatus(true);
		product.setProductDesc("It is a very good smarttv at very low cost  ");
		product.setCategory(categoryDAO.getCategory(1));
		productDAO.addProduct(product);*/
		
		//cart and cartitem test case
		CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
		UserDao userdao = (UserDao) context.getBean("userdao");
		ProductDao productDAO= (ProductDao) context.getBean("productDAO");
		CartDao cartDao=(CartDao)context.getBean("cartDao");
		
		Cart cart=new Cart();
		cart.setId(1);
		cart.setUsers(userdao.getUser(1));
		CartItem cartItem=new CartItem();
		cartItem.setCart(cart);
		cartItem.setQuantity(2);
		Product product=productDAO.get(1);
		cartItem.setProduct(product);
		cartItem.setGrandTotal(cartItem.getQuantity()*product.getProductPrice());
		List<CartItem> cartItems=new ArrayList<CartItem>();
		cartItems.add(cartItem);
		cart.setCartItems(cartItems);
		cart.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
		cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
		cartDao.addCart(cart);
		
		}

	
	}
	


