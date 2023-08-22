package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

// ## Duplicate Bean:
//
// - Dalam Spring, mungkin untuk mendaftarkan beberapa bean dengan tipe yang sama.
// - Namun, jika kita membuat bean dengan tipe data yang sama,
//   kita harus memberikan nama bean yang berbeda agar tidak ada konflik.
// - Saat mengakses bean dengan tipe yang sama, Spring memerlukan nama bean
//   yang spesifik untuk menghindari kebingungan.
//
// ### Mengakses Duplicate Bean:
//
// - Jika ada beberapa bean dengan tipe yang sama, Spring tidak dapat membedakan
//   secara otomatis, dan kita perlu mengakses bean dengan menyebutkan nama bean-nya.
// - Saat mengakses bean dengan tipe yang sama, menggunakan method `getBean`
//   memerlukan penentuan nama bean yang ingin diakses.
// - Nama bean perlu diberikan sebagai argumen saat memanggil `getBean`.
public class DuplicateTest {

    @Test
    void testDuplicate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo = context.getBean(Foo.class);
        });
    }

    @Test
    void getBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
