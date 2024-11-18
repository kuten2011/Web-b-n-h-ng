package CNJV.lab10;

import CNJV.lab10.Service.AccountService;
import CNJV.lab10.Service.ProductService;
import CNJV.lab10.model.Product;
import CNJV.lab10.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class Lab10Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Lab10Application.class, args);
	}

	@Autowired
	private ProductService productService;
	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		Account.AccountBuilder acc =  Account.builder()
				.username("kuten")
				.password("kuten2003");
		Product.ProductBuilder product1 =  Product.builder()
				.name("Dầu Gội Chăm Sóc Tóc Giúp Phục Hồi Pantene Damage Care 650ml")
				.price(165000)
				.brand("Pantene")
				.image("https://product.hstatic.net/200000061028/product/slide1_9f4f1ac74cda4575aedf6e8e1f4fb221_grande.png")
				.detail("Dầu gội chăm sóc tóc giúp phục hồi PANTENE giúp loại bỏ 10 dấu hiệu hư tổn của tóc do tác động của môi trường hay hóa chất, nuôi dưỡng tóc chắc khỏe.");
		Product.ProductBuilder product2 =  Product.builder()
				.name("Kem Xả Cho Tóc Bóng Mượt Pantene Pro-V 300ml")
				.price(97000)
				.brand("Pantene")
				.image("https://product.hstatic.net/200000061028/product/3021861_1_9123f6f4bb7b404cb4b0a04b69f61134_grande.jpg")
				.detail("Là dòng kem xả dành cho những mái tóc khô và xơ rối, mất độ bóng mượt tự nhiên.");
		Product.ProductBuilder product3 =  Product.builder()
				.name("Sữa Rửa Mặt Đất Sét Giúp Hỗ Trợ Sáng Da Ngọc Trai Nivea 100Gr")
				.price(55000)
				.brand("Nivea")
				.image("https://product.hstatic.net/200000061028/product/3022115-1_298285229cd345dba923dd3ba9ab9bc8_1024x1024.jpg")
				.detail("Sữa Rửa Mặt Đất Sét giúp sáng da Ngọc Trai Nivea 100Gr Giúp sáng da ngọc trai phát triển dựa trên công thức làm sạch cho mọi loại da.");
		Product.ProductBuilder product4 =  Product.builder()
				.name("Nước Tẩy Trang Hỗ Trợ Sáng Da Giúp Sạch Nhờn Nivea 200Ml")
				.price(109000)
				.brand("Nivea")
				.image("https://product.hstatic.net/200000061028/product/3013830-1_c6912333041d468391e5a8b64d4f39f7_grande.jpg")
				.detail("Là giải pháp tẩy trang thật sự dịu nhẹ với da nhờn & dễ nổi mụn do trang điểm.");
		Product.ProductBuilder product5 =  Product.builder()
				.name("Tinh Chất Chuyên Sâu Nivea Ngăn Ngừa Thâm Nám Luminous 30Ml")
				.price(350000)
				.brand("Nivea")
				.image("https://product.hstatic.net/200000061028/product/gdn-face-l630_-09_9a7b0cea35014cad80c9481b67e6f704_grande.jpg")
				.detail("Tinh chất chuyên sâu Nivea Luminous 630 Spotclear Itensive Treatment Serum 30Ml giúp giảm thâm nám và làm mờ đốm nâu kéo dài 10 năm chỉ trong vòng 4 tuần. ");
		Product.ProductBuilder product6 =  Product.builder()
				.name("Kem Đánh Răng Optic White Plus Shine Colgate 100Gr")
				.price(141000)
				.brand("Colgate")
				.image("https://product.hstatic.net/200000061028/product/slide1_28c5f62aa6414829b135bc26a28b93cc_grande.png")
				.detail("Kem đánh răng Colgate Plus Shine chứa công nghệ làm trắng giúp loại bỏ mảng bám & các hạt vi tinh thể giúp đánh bóng răng, cho nụ cười tỏa sáng");
		accountService.save(acc.build());
		productService.save(product1.build());
		productService.save(product2.build());
		productService.save(product3.build());
		productService.save(product4.build());
		productService.save(product5.build());
		productService.save(product6.build());
	}

}
