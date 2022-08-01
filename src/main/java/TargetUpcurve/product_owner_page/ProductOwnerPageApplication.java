package TargetUpcurve.product_owner_page;

import TargetUpcurve.product_owner_page.model.ProductOwner;
import TargetUpcurve.product_owner_page.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ComponentScan
public class ProductOwnerPageApplication{
		//implements CommandLineRunner

	public static void main(String[] args) {

		SpringApplication.run(ProductOwnerPageApplication.class, args);
	}


	//@Autowired
	//private ProductOwnerRepository productOwnerRepository;

	/*@Override
	public void run(String... args) throws Exception {
		ProductOwner productowner1=new ProductOwner();
		productowner1.setFirstname("Sharanya");
		productowner1.setLastname("CH");
		productowner1.setEmailId("sharanya@gmail.com");
		productowner1.setProduct_Name("Books");
		productowner1.setProduct_Type("stationary");
		productOwnerRepository.save(productowner1);

		ProductOwner productowner2=new ProductOwner();
		productowner2.setFirstname("Alice");
		productowner2.setLastname("H");
		productowner2.setEmailId("alice@gmail.com");
		productowner2.setProduct_Name("Shirts");
		productowner2.setProduct_Type("Clothing");
		productOwnerRepository.save(productowner2);
	}*/
}
