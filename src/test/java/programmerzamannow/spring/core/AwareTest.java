package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import programmerzamannow.spring.core.service.AuthService;

// ## Aware Interface:
//
// - Spring memiliki sebuah interface yang disebut sebagai `Aware`.
// - `Aware` adalah super interface yang digunakan untuk sejumlah sub interface lainnya.
// - `Aware` digunakan sebagai penanda untuk memberi petunjuk kepada Spring agar
//   melakukan injection objek yang dibutuhkan.
// - Fungsinya mirip dengan saat kita membuat IdAware menggunakan Id Generator Bean Post Processor.
// - Aware memungkinkan kita mendapatkan akses ke berbagai objek atau konteks tanpa perlu
//   membuat Bean Post Processor secara manual.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/Aware.html
//
// ### Daftar Sub Interface Aware dan Keterangan:
//
// | Aware                          | Keterangan                                            |
// |--------------------------------|-------------------------------------------------------|
// | ApplicationContextAware        | Untuk mendapatkan application context.                |
// | BeanFactoryAware               | Untuk mendapatkan bean factory.                       |
// | BeanNameAware                  | Untuk mendapatkan nama bean.                          |
// | ApplicationEventPublisherAware | Untuk mendapatkan event publisher.                    |
// | EnvironmentAware               | Untuk mendapatkan environment.                        |
// | BeanClassLoaderAware           | Untuk mendapatkan bean class loader.                  |
// | MessageSourceAware             | Interface untuk mendapatkan message source.           |
// | NotificationPublisherAware     | Interface untuk mendapatkan notification publisher.   |
// | ResourceLoaderAware            | Interface untuk mendapatkan resource loader.          |
// | ServletContextAware            | Interface untuk mendapatkan servlet context.          |
// | LoadTimeWeaverAware            | Interface untuk mendapatkan load time weaver.         |
// | PortletConfigAware             | Interface untuk mendapatkan portlet config.           |
// | PortletContextAware            | Interface untuk mendapatkan portlet context.          |
// | dan lain-lain                  | ...                                                   |
public class AwareTest {
    @Configuration
    @Import({
            AuthService.class
    })
    public static class TestConfiguration {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);

        Assertions.assertEquals("programmerzamannow.spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
    }
}
