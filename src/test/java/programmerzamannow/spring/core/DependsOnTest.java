package programmerzamannow.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

// ## Depends On:
//
// - Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut
//   akan dibuat setelah bean yang dibutuhkan.
// - Namun dalam beberapa kasus, bean tersebut tidak memiliki ketergantungan
//   namun perlu dibuat setelah bean lain.
//
// ### Menggunakan Annotation `@DependsOn`:
//
// - Dalam kasus di mana bean yang tidak membutuhkan bean lain perlu dibuat
//   setelah bean lain, kita dapat menggunakan annotation `@DependsOn(value={"namaBean"})`.
// - Dengan menggunakan `@DependsOn`, kita bisa mengontrol urutan pembuatan bean.
//
// ### Prioritaskan Pembuatan Bean:
//
// - Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdaftar
//   dalam `@DependsOn` terlebih dahulu sebelum membuat bean lain.
//
// =============================================================================
//
// ## Lazy Bean:
//
// - Secara default, semua bean dalam Spring akan dibuat saat aplikasi pertama kali berjalan.
// - Ini dapat menyebabkan keterlambatan dalam startup karena semua bean akan dibuat di awal.
//
// ### Keuntungan Lazy Bean:
//
// - Aplikasi dapat dimulai lebih cepat karena hanya bean yang dibutuhkan yang akan dibuat saat diakses.
// - Bean yang tidak diperlukan pada tahap awal tidak akan dibuat.
//
// ### Membuat Bean Menjadi Lazy:
//
// - Untuk membuat bean menjadi "lazy" (dibuat saat diakses), kita bisa menambahkan
//   annotation `@Lazy` pada deklarasi bean tersebut.
public class DependsOnTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
    }

    @Test
    void testDependsOn() {
        Foo foo = applicationContext.getBean(Foo.class);
    }
}
