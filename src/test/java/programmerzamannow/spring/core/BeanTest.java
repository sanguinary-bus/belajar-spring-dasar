package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

// ## Bean:
//
// - Konsep "bean" merujuk pada objek yang dimasukkan ke dalam Spring Container IoC.
// - Defaultnya, bean adalah singleton, artinya jika mengakses bean yang sama,
//   akan mengembalikan instance yang sama.
// - Bean memanfaatkan konsep Inversion of Control (IoC) di mana kontrol pembuatan
//   objek diberikan kepada Spring Framework.
// - Dalam konteks Spring Framework, secara default objek akan dikelola oleh Application Context.
//
// ### Membuat Bean:
//
// - Bean dapat dibuat dengan membuat metode dalam kelas konfigurasi.
// - Nama metode akan menjadi nama bean, dan return value-nya menjadi instance bean.
// - Metode tersebut perlu ditandai dengan anotasi `@Bean`.
// - Spring akan menjalankan metode tersebut dan mengelola instance bean di dalam Application Context.
//
// ### Mengakses Bean:
//
// - Instance bean akan disimpan dalam Application Context secara otomatis.
// - Untuk mengakses bean, digunakan method `getBean` dari Application Context
//   dengan tipe data bean yang diinginkan.
// - Metode `getBean` ini mengembalikan instance yang telah disimpan dalam
//   Application Context.
public class BeanTest {
    @Test
    void testCreateBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Assertions.assertNotNull(context);
    }

    @Test
    void testGetBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);

        Assertions.assertSame(foo1, foo2);
    }
}
