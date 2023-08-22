package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

// ## Mengubah Nama Bean:
//
// - Secara default, nama bean diambil dari nama method yang mendefinisikan bean.
// - Dalam kasus proyek yang besar, kemungkinan terjadi nama method yang sama pada berbagai jenis bean.
// - Menggunakan nama method yang sama dapat menyebabkan nama bean bentrok,
//   karena nama bean harus unik di Spring.
// - Untuk menghindari masalah ini, kita dapat mengubah nama bean dengan menggunakan
//   anotasi `@Bean` dan atribut `name` untuk memberi nama bean yang berbeda.
//
// ### Mengakses Bean:
//
// - Saat mengakses bean dengan nama yang telah diubah, kita menggunakan
//   nama bean yang baru untuk mengambil bean tersebut.
// - Mengubah nama bean memungkinkan kita untuk menghindari bentrok nama dan memastikan keunikan.
public class BeanNameTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    @Test
    void testBeanName() {
        Foo foo = applicationContext.getBean(Foo.class);
        Foo fooFirst = applicationContext.getBean("fooFirst", Foo.class);
        Foo fooSecond = applicationContext.getBean("fooSecond", Foo.class);

        Assertions.assertSame(foo, fooFirst);
        Assertions.assertNotSame(foo, fooSecond);
    }
}
