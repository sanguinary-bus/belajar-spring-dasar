package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;

// ## Scope:
//
// - Scope merujuk pada strategi bagaimana objek dibuat dalam Spring.
// - Secara default, strategi scope objek di Spring adalah singleton,
// yang berarti objek hanya dibuat sekali dan diakses dengan cara yang sama.
//
// ### Default Singleton:
//
// - Default scope dalam Spring adalah singleton.
// - Objek dibuat satu kali saat aplikasi pertama kali berjalan, dan setiap kali diakses,
//   akan mengembalikan objek yang sama.
//
// ### Mengubah Scope Bean:
//
// - Kita dapat mengubah scope bean sesuai kebutuhan dengan menambahkan annotation `@Scope("namaScope")`.
//
// ### Jenis-jenis Scope Bean:
//
// | Scope       | Keterangan                                            |
// | ----------- | ----------------------------------------------------- |
// | singleton   | (Default) Hanya dibuat sekali dalam Spring IoC        |
// | prototype   | Selalu dibuat object baru setiap kali bean diakses    |
// | request     | Dibuat baru per HTTP Request (hanya untuk Web App)    |
// | session     | Dibuat baru per HTTP Session (hanya untuk Web App)    |
// | application | Dibuat baru per ServletContext (hanya untuk Web App)  |
// | websocket   | Dibuat baru per WebSocket (hanya untuk WebSocket App) |
public class ScopeTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void testPrototypeScope() {
        // 3 object yang berbeda
        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo1, foo3);
        Assertions.assertNotSame(foo2, foo3);
    }

    @Test
    void testDoubletonScope() {
        Bar bar1 = applicationContext.getBean(Bar.class);
        Bar bar2 = applicationContext.getBean(Bar.class);
        Bar bar3 = applicationContext.getBean(Bar.class);
        Bar bar4 = applicationContext.getBean(Bar.class);

        Assertions.assertSame(bar1, bar3);
        Assertions.assertSame(bar2, bar4);

        Assertions.assertNotSame(bar1, bar2);
        Assertions.assertNotSame(bar3, bar4);
    }
}
