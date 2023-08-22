package programmerzamannow.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Connection;
import programmerzamannow.spring.core.data.Server;

// ## Life Cycle
//
// - Spring Container memiliki Life Cycle yang mencakup pembuatan dan penghancuran bean.
// - Saat Spring pertama kali berjalan dan selesai membuat bean, Spring memberitahukan
//   bean tersebut bahwa semua dependensi sudah dimasukkan.
// - Ketika aplikasi Spring akan mati, Spring memberitahukan semua bean bahwa bean tersebut
//   akan dihancurkan.
//
// ### Life Cycle Callback
//
// - Secara default, bean tidak mengetahui Life Cycle Spring.
// - Untuk bereaksi terhadap Life Cycle Spring, kita bisa mengimplementasikan
//   interface `InitializingBean` dan `DisposableBean`.
// - `InitializingBean` digunakan untuk bereaksi saat Spring selesai membuat bean,
//   dengan meng-override metode `afterPropertiesSet()`.
// - `DisposableBean` digunakan untuk bereaksi saat Spring akan menghancurkan bean,
//   dengan meng-override metode `destroy()`.
// - Dalam kode `Connection`, metode `afterPropertiesSet()` dipanggil setelah bean siap digunakan,
//   dan metode `destroy()` dipanggil sebelum bean dihancurkan.
//
// =============================================================================
//
// ## Life Cycle Annotation
//
// - Selain menggunakan interface `InitializingBean` dan `DisposableBean`,
//   kita juga bisa menggunakan annotation `@Bean` untuk mendaftarkan callback method
//   untuk Life Cycle Spring.
// - Pada annotation `@Bean`, terdapat method `initMethod()` dan `destroyMethod()` yang digunakan
//   untuk meregistrasikan init dan destroy method secara eksplisit.
// - `initMethod()` digunakan untuk meregistrasikan method yang akan dipanggil setelah bean *selesai dibuat*.
// - `destroyMethod()` digunakan untuk meregistrasikan method yang akan dipanggil ketika bean *akan dihancurkan*.
// - Kedua method tersebut harus tanpa parameter dan return value, sebaiknya menggunakan void.
//
// ### @PostConstruct dan @PreDestroy
//
// - Selain menggunakan annotation `@Bean`, untuk menandai sebuah method adalah
//   init method dan destroy method, kita juga bisa menggunakan annotation pada method nya secara langsung
// - Ini bisa digunakan untuk menghindari kita lupa menyebutkan init dan destroy method ketika membuat `@Bean`
// - `@PostConstruct` merupakan method yang ditandai harus dipanggil ketika bean selesai dibuat
// - `@PreDestroy` merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan
// - Jika sudah menggunakan annotation ini, kita tidak perlu lagi menyebutkan nya di `@Bean`
// - https://docs.oracle.com/javaee/7/api/javax/annotation/PostConstruct.html
// - https://docs.oracle.com/javaee/7/api/javax/annotation/PreDestroy.html
public class LifeCycleTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @AfterEach
    void tearDown() {
        // applicationContext.close();
    }

    @Test
    void testConnection() {
        Connection connection = applicationContext.getBean(Connection.class);
    }

    @Test
    void testServer() {
        Server server = applicationContext.getBean(Server.class);
    }
}
