package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.MultiFoo;
import programmerzamannow.spring.core.repository.CategoryRepository;
import programmerzamannow.spring.core.repository.CustomerRepository;
import programmerzamannow.spring.core.repository.ProductRepository;
import programmerzamannow.spring.core.service.CategoryService;
import programmerzamannow.spring.core.service.CustomerService;
import programmerzamannow.spring.core.service.ProductService;

// ## Component
//
// - Spring menyediakan cara otomatis membuat bean tanpa perlu membuat method `@Bean`.
// - Penggunaan method `@Bean` di Configuration Class digantikan dengan
//   fitur yang lebih otomatis menggunakan `@Component` sehingga lebih mudah deklarasi bean.
// - Annotation `@Component` digunakan untuk menandai kelas yang akan menjadi bean,
//   secara otomatis Spring membuatkan bean untuk kelas yang ditandai dengan `@Component`.
// - Penggunaan `@Component` hanya mendukung pembuatan *satu bean dari satu tipe kelas*.
// - Jika ingin membuat beberapa bean dengan tipe yang sama, tetap gunakan method `@Bean`.
//
// ### Component Bean Name
//
// - Penggunaan `@Component` akan membuat nama bean secara otomatis oleh Spring.
// - Jika menggunakan `@ComponentScan`, nama bean secara otomatis mengikuti nama kelas
//   dengan format *camelCase*.
// - Saat menggunakan `@Import`, nama bean akan menjadi `NamaClass.class.getName()`.
// - Jika ingin mengubah nama bean, gunakan `@Component(value="namaBean")`.
//
// ### Annotation
//
// - Annotation yang sudah dijelaskan sebelumnya untuk `@Bean` juga berlaku
//   untuk `@Component`, seperti `@Scope`, `@PostConstruct`, `@PreDestroy`, `@Lazy`, `@Primary`, dll.
//
// =============================================================================
//
// ## Dependency Injection (DI) dengan @Component:
//
// - Sebelumnya, DI bisa dilakukan dengan menambahkan parameter di method @Bean.
// - Spring secara otomatis memilih bean yang cocok untuk parameter tersebut.
// - Pertanyaan muncul ketika menggunakan `@Component`, bagaimana DI dilakukan?
// - Ada beberapa cara untuk melakukan DI dengan `@Component`.
public class ComponentTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    // using @Component
    @Test
    void testService() {
        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService", ProductService.class);

        Assertions.assertSame(productService1, productService2);
    }

    // Constructor-based DI
    @Test
    void testConstructorDependencyInjection() {
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    // Setter-based DI
    @Test
    void testSetterDependencyInjection() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    // Field-based DI
    @Test
    void testFieldDependencyInjection() {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository", CustomerRepository.class);

        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }

    // Object Provider
    @Test
    void testObjectProvider() {
        MultiFoo multiFoo = applicationContext.getBean(MultiFoo.class);
        Assertions.assertEquals(3, multiFoo.getFoos().size());
    }
}
