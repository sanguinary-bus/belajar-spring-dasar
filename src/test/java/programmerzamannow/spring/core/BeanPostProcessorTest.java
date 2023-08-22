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

// ## Bean Post Processor:
//
// - Bean Post Processor adalah sebuah *interface* yang digunakan untuk memodifikasi
//   proses pembuatan bean di Application Context.
// - Fungsinya mirip dengan _middleware_ dalam konteks web, yaitu diakses
//   sebelum dan setelah bean diinisialisasi.
// - Bean Post Processor memiliki dua metode utama:
//   `postProcessBeforeInitialization` dan `postProcessAfterInitialization`.
// - Spring Framework menggunakan Bean Post Processor untuk mengaplikasikan
//   modifikasi atau validasi tambahan pada bean.
// - Penerapan Bean Post Processor sangat fleksibel dan dapat digunakan untuk banyak tujuan
//   terhadap proses pembuatan bean seperti validasi, pemrosesan, dan modifikasi objek.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html
//
// ## Bean Id Generator:
//
// - Untuk membuat unique ID untuk setiap bean, digunakan sebuah interface bernama `IdAware`
//   yang memiliki method `setId(String)` dan `getId()`.
// - Bean Post Processor (IdGeneratorBeanPostProcessor) diimplementasikan untuk mengatur ID unik
//   untuk bean yang mengimplementasikan `IdAware`.
// - Proses ini terjadi setelah bean diinisialisasi.
// - Penggunaan `UUID` untuk menghasilkan ID unik sangat umum dalam konteks ini.
// - Seluruh proses ini memungkinkan untuk memodifikasi bean secara otomatis dan dinamis
//   dalam konteks Spring.
// - Dalam kasus kode contoh, bean `Car` mengimplementasikan `IdAware` yang memungkinkan
//   pengaturan ID unik menggunakan Bean Post Processor.
// - Penggunaan Bean Post Processor dan konsep ID Generator memberikan fleksibilitas dan otomatisasi
//   dalam manajemen bean di Spring Framework.
public class BeanPostProcessorTest {
    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class
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

        System.out.println(car.getId());
        Assertions.assertNotNull(car.getId());
    }
}
