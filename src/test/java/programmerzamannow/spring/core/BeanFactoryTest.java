package programmerzamannow.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// ## Bean Factory
//
// - `ApplicationContext` adalah interface turunan dari `BeanFactory`.
// - `BeanFactory` merupakan kontrak untuk manajemen bean di Spring.
// - Method-method yang digunakan untuk mengambil bean sebenarnya merupakan bagian
//   dari kontrak interface `BeanFactory`.
// - `BeanFactory` menyediakan method-method untuk mendapatkan detail tentang bean,
//   seperti cek keberadaan bean, tipe bean, dan lainnya.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html
//
// ## Listable Bean Factory
//
// - Bean Factory hanya dapat digunakan untuk mengakses satu bean tunggal.
//   Jika ada banyak bean dengan tipe yang sama, kita harus menyebutkan nama bean tersebut
//   secara spesifik.
// - `ListableBeanFactory` adalah turunan dari `BeanFactory` yang memungkinkan kita untuk
//   mengakses beberapa bean sekaligus.
// - Dalam beberapa kasus, fitur ini sangat berguna, contohnya ketika ingin mengambil semua bean
//   dengan tipe tertentu.
// - `ApplicationContext` juga turunan dari interface `ListableBeanFactory`.
// - Dalam Spring, metode `getBeansOfType()` dari `ListableBeanFactory` memungkinkan untuk
//   mengambil semua bean dengan tipe tertentu.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ListableBeanFactory.html
public class BeanFactoryTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactory() {
        ObjectProvider<Foo> fooObjectProvider = applicationContext.getBeanProvider(Foo.class);
        List<Foo> fooList = fooObjectProvider.stream().collect(Collectors.toList());

        System.out.println(fooList);

        Map<String, Foo> beans = applicationContext.getBeansOfType(Foo.class);
        System.out.println(beans);
    }
}
