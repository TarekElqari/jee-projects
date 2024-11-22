import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.emsi.dao.IDao;
import ma.emsi.entities.Product;
import ma.emsi.util.HibernateConfig;

public class Presentation2 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		IDao<Product> productDao = context.getBean(IDao.class);
		Product product = new Product();
		product.setName("Produit 1");
		product.setPrice(100.0);
		productDao.create(product);
		System.out.println("Produit sauvgarde :"+product.getName());
	}
}
