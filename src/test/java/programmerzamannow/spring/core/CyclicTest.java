package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// ## Circular Dependencies:
//
// - Circular dependencies adalah situasi dimana terbentuk suatu lingkaran dependensi,
// misal bean A membutuhkan bean B, bean B membutuhkan bean C, dan akhirnya bean C juga membutuhkan bean A.
// - Ini dapat mengakibatkan masalah yang kompleks dan membingungkan dalam aplikasi.
//
// ### Deteksi Circular Dependencies:
//
// - Spring secara otomatis mendeteksi circular dependencies dan menganggapnya sebagai kesalahan.
// - Circular dependencies juga harus dihindari dalam desain objek
//   berbasis Oriented Object Programming (OOP).
//
// ### Pengujian Error Circular Dependencies:
//
// - Ketika ada circular dependencies, Spring akan menghasilkan error saat mencoba membuat ApplicationContext.
// - Circular dependencies dapat mengakibatkan cyclic reference dan kesalahan pembuatan objek.
public class CyclicTest {
    @Test
    void testCyclic() {
        Assertions.assertThrows(Throwable.class, () -> {
            ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
        });
    }
}
