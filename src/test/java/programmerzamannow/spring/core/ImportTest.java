package programmerzamannow.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;

// ## Import
//
// - Saat membuat aplikasi, tidak mungkin hanya ada satu Configuration Class.
// - Biasanya, akan ada banyak Configuration Class tergantung pada kompleksitas aplikasi.
// - Spring mendukung import Configuration Class lain yang dibutuhkan.
// - Annotation `@Import` digunakan untuk mengimpor Configuration Class lain.
// - Annotation `@Import` memiliki konsep array, sehingga bisa mengimpor lebih dari satu
//   Configuration Class sekaligus.
// - Penggunaan `@Import` dapat membuat kode lebih bersih dan terstruktur,
//   dengan mengisolasi berbagai konfigurasi ke dalam kelas yang berbeda.
// - Saat mengakses bean dari Spring Application Context, semua bean yang ada dalam konfigurasi
//   yang diimpor akan tersedia.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Import.html
public class ImportTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testImport() {
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
    }
}
