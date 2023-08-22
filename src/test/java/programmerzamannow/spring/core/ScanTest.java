package programmerzamannow.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;

// ## Component Scan
//
// - Import adalah fitur menarik yang memungkinkan pemecahan Configuration Class
//   menjadi banyak kelas.
// - Saat aplikasi semakin besar, jumlah Configuration Class akan bertambah dan
//   proses import satu per satu akan menjadi tidak praktis.
// - Spring memiliki fitur "component scan" yang memungkinkan mengimpor otomatis semua
//   Configuration class dari satu package dan subpackage yang ditentukan.
// - Annotation `@ComponentScan` digunakan untuk mengaktifkan fitur "component scan".
// - Dalam kode, annotation `@ComponentScan` diikuti dengan `basePackages` yang berisi
//   package yang ingin di-scan.
// - Fitur "component scan" memudahkan pengelompokan dan mengatur berbagai
//   konfigurasi tanpa perlu impor satu per satu.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html
public class ScanTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testScan() {
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
    }
}
