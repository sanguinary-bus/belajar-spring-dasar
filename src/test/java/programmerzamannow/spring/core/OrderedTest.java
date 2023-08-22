package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import programmerzamannow.spring.core.data.Car;
import programmerzamannow.spring.core.processor.IdGeneratorBeanPostProcessor;
import programmerzamannow.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;

// ## Ordered Bean Post Processor:
//
// - Saat membuat Bean Post Processor, kita bisa membuat lebih dari satu.
// - Kadang-kadang, saat membuat beberapa Bean Post Processor,
//   kita ingin mengatur urutan eksekusi mereka.
// - Secara default, Spring tidak menjamin urutan eksekusi Bean Post Processor.
// - Untuk menentukan urutan eksekusi, kita dapat menggunakan interface `Ordered`.
// - `Ordered` memiliki method `getOrder()` yang memungkinkan kita untuk mengatur
//   urutan dari yang terkecil ke yang terbesar.
// - Penerapan `Ordered` memungkinkan kita mengendalikan urutan eksekusi Bean Post Processor
//   sesuai kebutuhan.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/Ordered.html
public class OrderedTest {
    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,         // order 1
            PrefixIdGeneratorBeanPostProcessor.class    // order 2
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
    void testCar() {
        Car car = applicationContext.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("PZN-"));
    }
}
