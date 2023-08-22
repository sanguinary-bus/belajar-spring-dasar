package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.data.FooBar;

// ## Optional Dependency
//
// - Secara default, semua dependency adalah wajib dalam Dependency Injection (DI).
// - Ini berarti jika Spring tidak dapat menemukan bean yang diperlukan pada saat DI,
//   maka akan terjadi error.
// - Tetapi jika ingin membuat dependency menjadi opsional (tidak wajib),
//   kita dapat menggunakan `java.util.Optional<T>`.
// - Dengan menggunakan `Optional<T>`, jika bean yang dibutuhkan tidak ada,
//   tidak akan ada error yang terjadi.
// - Kita dapat menggunakan `Optional<T>` pada method `@Bean`, parameter method,
//   atau pada anotasi `@Component` (constructor parameter, setter method parameter, field).
public class OptionalTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testOptional() {
        Foo foo = applicationContext.getBean(Foo.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getBar());
        Assertions.assertSame(foo, fooBar.getFoo());
    }
}
