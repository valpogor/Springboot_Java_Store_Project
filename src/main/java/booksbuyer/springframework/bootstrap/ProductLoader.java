package booksbuyer.springframework.bootstrap;

import booksbuyer.springframework.domain.Product;
import booksbuyer.springframework.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product spacebook = new Product();
        spacebook.setDescription("Space Atlas, Second Edition: Mapping the Universe and Beyond");
        spacebook.setPrice(new BigDecimal("48.90"));
        spacebook.setImageUrl("https://www.amazon.com/Space-Atlas-Second-Mapping-Universe/dp/1426219695?ref_=Oct_s9_apbd_obs_hd_bw_b1xno&pf_rd_r=D0MZT0SEM2BPKHXZGPWE&pf_rd_p=64c786d0-33be-5eb1-b462-f78b26efcc3a&pf_rd_s=merchandised-search-10&pf_rd_t=BROWSE&pf_rd_i=468212");
        spacebook.setProductId("978-1426219696");
        productRepository.save(spacebook);

        log.info("Saved Book with id: " + spacebook.getId());

        Product books = new Product();

        books.setDescription("COVID-19: The Greatest Cover-Up in History―From Wuhan to the White House");
        books.setImageUrl("https://www.amazon.com/COVID-19-Greatest-Cover-Up-History_From-Detectives/dp/1510765336/ref=sr_1_3?dchild=1&keywords=covid&qid=1607455757&s=books&sr=1-3");
        books.setProductId("B08HZFH1J3");
        books.setPrice(new BigDecimal("22.40"));
        productRepository.save(books);

        log.info("Saved Book with id:" + books.getId());
    }
}
