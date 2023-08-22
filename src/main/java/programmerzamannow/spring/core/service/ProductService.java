package programmerzamannow.spring.core.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import programmerzamannow.spring.core.repository.ProductRepository;

// ## Constructor-based Dependency Injection:
//
// - DI pada @Component dapat dilakukan menggunakan constructor parameter.
// - Kita bisa menambahkan constructor yang memiliki parameter jika membutuhkan bean lain
// - Secara otomatis Spring akan mencari bean yang cocok untuk parameter konstruktor
//   dan menggunakannya saat membuat bean `@Component`.
// - Metode ini hanya mendukung satu constructor, jadi harus memiliki satu constructor saja.
// - https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html#beans-constructor-injection
//
// ### Multiple Constructors:
//
// - Spring awalnya hanya mendukung satu konstruktor untuk DI.
// - Namun, untuk multiple constructors, gunakan annotation `@Autowired`
//   untuk menandai konstruktor yang akan digunakan oleh Spring.
//
// @Scope("prototype")
// @Lazy
@Component
public class ProductService {
    @Getter
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
    }
}
