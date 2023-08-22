package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.data.FooBar;

// ## Dependency Injection (DI):
//
// - Ketika membuat objek, seringkali objek tersebut tergantung pada objek lain,
//   disebut sebagai dependencies.
// - Dependency Injection (DI) adalah teknik untuk mengotomatisasi proses pembuatan objek
//   yang memiliki ketergantungan dengan objek lain (dependencies).
// - DI memungkinkan dependencies secara otomatis dimasukkan (di-inject) ke dalam objek yang membutuhkannya.
// - Spring Framework dikenal sebagai IoC (Inversion of Control) framework yang mengadopsi DI.
//
// ### Keuntungan DI:
//
// - Mengurangi kerumitan dalam pembuatan objek yang saling tergantung.
// - DI membantu mengatasi kerumitan dalam aplikasi dengan dependencies yang kompleks.
//
// ### Tanpa Dependency Injection:
//
// - Meskipun bisa membuat aplikasi tanpa DI, dalam kasus dengan relasi dependencies yang kompleks,
//   menggunakan DI menjadi lebih efisien.
// - Menggunakan DI framework seperti Spring sangat membantu dalam mengelola kompleksitas dependencies.
//
// ### Spring Dependency Injection:
//
// - Spring Framework terkenal sebagai framework Dependency Injection.
// - Saat membuat method bean di Spring, kita bisa menambahkan parameter.
// - Spring secara otomatis akan mencari bean yang cocok sesuai dengan tipe parameter.
// - Jika tidak ada bean yang cocok atau ada lebih dari satu bean yang cocok,
//   Spring akan menangani error ini.
//
// ### Menggunakan Dependency Injection:
//
// - Saat menggunakan DI, kita bisa memasukkan dependencies ke dalam method parameter.
// - Spring akan mencari bean sesuai dengan tipe parameter yang diberikan.
// - Pilihan menggunakan @Qualifier jika ada lebih dari satu bean yang cocok.
// - Ini mempermudah pengelolaan dependencies dalam aplikasi yang kompleks.
//
// =============================================================================
//
// ## Memilih Dependency:
//
// - Kadang-kadang dalam Dependency Injection (DI), kita perlu memilih objek mana yang ingin kita gunakan.
// - Saat ada duplikat bean dengan tipe data yang sama, Spring akan secara otomatis
//   memilih bean yang ditandai sebagai primary.
// - Namun, kita juga bisa memilih secara manual jika diinginkan.
//
// ### Pilihan Otomatis dan Manual:
//
// - Spring akan secara otomatis memilih primary bean jika ada beberapa bean dengan tipe yang sama.
// - Jika ingin memilih secara manual, kita bisa menggunakan annotation `@Qualifier("namaBean")`
//   pada parameter method.
//
// ### Mengakses Bean Menggunakan Dependency Injection:
//
// - Saat mengakses bean dengan DI, bisa menggunakan @Qualifier untuk memilih bean secara eksplisit.
// - Ini berguna jika kita ingin menggunakan bean yang bukan primary bean.
public class DependencyInjectionTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    @Test
    void testDI() {
        Foo foo = applicationContext.getBean("fooSecond", Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }

    @Test
    void testNoDI() {
        var foo = new Foo();
        var bar = new Bar();

        var fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());

    }
}
