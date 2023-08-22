package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

// ## Primary Bean:
//
// - Ketika terjadi duplikasi bean dengan tipe yang sama, kita dapat memilih
//   salah satu bean menjadi "primary" yang akan diutamakan saat mengakses
//   tanpa menyebutkan nama bean secara eksplisit.
// - Dengan menandai bean sebagai primary, saat mengambil bean tanpa menyebutkan nama,
//   primary bean akan dipilih secara otomatis.
// - Anotasi `@Primary` dapat digunakan untuk menunjukkan bahwa sebuah bean adalah primary bean.
//
// ### Mengakses Primary Bean:
//
// - Saat mengakses bean dengan tipe yang sama, namun memiliki satu primary bean,
//   kita dapat mengambil bean tanpa menyebutkan nama, dan primary bean akan dipilih.
// - Bean yang tidak menjadi primary juga dapat diakses dengan menyebutkan nama bean
//   tersebut saat pengambilan.
public class PrimaryTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);
    }

    @Test
    void testGetPrimary() {
        Foo foo = applicationContext.getBean(Foo.class);
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);

        Assertions.assertSame(foo, foo1);
        Assertions.assertNotSame(foo, foo2);
        Assertions.assertNotSame(foo1, foo2);
    }
}
