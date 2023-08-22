package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.processor.FooBeanFactoryPostProcessor;

// ## Bean Factory Post Processor:
//
// - Secara default, biasanya tidak perlu membuat Application Context
//   secara manual karena kompleksitasnya.
// - Kadang-kadang ada kebutuhan untuk memodifikasi Application Context secara internal.
// - Spring merekomendasikan penggunaan Bean Factory Post Processor untuk
//   melakukan modifikasi tersebut.
// - Bean Factory Post Processor adalah interface yang memungkinkan modifikasi pada bean factory
//   sebelum bean benar-benar diinisialisasi.
// - Interface ini memiliki dua turunan penting, yaitu:
//   - `BeanDefinitionRegistryPostProcessor`: Digunakan untuk registrasi bean secara otomatis.
//      https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanFactoryPostProcessor.html
//   - `BeanFactoryPostProcessor`: Digunakan untuk melakukan modifikasi pada bean factory.
//      https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/support/BeanDefinitionRegistryPostProcessor.html
public class BeanFactoryPostProcessorTest {
    @Configuration
    @Import(FooBeanFactoryPostProcessor.class)
    public static class TestConfiguration {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        // mengkonfigurasi bean factory post processor melalui `TestConfiguration`
        // yang mengimpor `FooBeanFactoryPostProcessor` dimana
        // `FooBeanFactoryPostProcessor` mengimplementasi `BeanDefinitionRegistryPostProcessor`
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactoryPostProcessor() {
        Foo foo = applicationContext.getBean(Foo.class);
        Assertions.assertNotNull(foo);
    }
}
