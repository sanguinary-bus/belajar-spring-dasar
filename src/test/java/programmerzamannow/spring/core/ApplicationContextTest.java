package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



// ## Application Context:
//
// - ApplicationContext adalah sebuah interface yang merepresentasikan
//   container Inversion of Control (IoC) di Spring.
// - ApplicationContext merupakan inti dari Spring Framework.
// - Terdapat berbagai implementasi class ApplicationContext,
//   secara garis besar dibagi menjadi 2 jenis: XML dan Annotation.
// - Pada versi Spring 3, XML masih menjadi pilihan utama,
//   tetapi banyak beralih dari XML ke Annotation.
// - Spring Boot merekomendasikan penggunaan Annotation untuk membuat aplikasi Spring.
//
// ### Configuration:
//
// - Untuk membuat ApplicationContext dengan Annotation, perlu dibuat Configuration class.
// - Configuration Class adalah sebuah class yang ditandai dengan anotasi @Configuration.
// - Contoh kode Configuration Class: HelloWorldConfiguration.
// - ApplicationContext menggunakan class AnnotationConfigApplicationContext
//   untuk membuatnya.
// - Pada Spring 3, lebih umum menggunakan Annotation daripada XML.
// - Configuration Class adalah tempat untuk mengkonfigurasi bean dan komponen aplikasi.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html
//
// ### Membuat Application Context:
//
// - Setelah membuat Configuration Class, kita digunakan
//   `AnnotationConfigApplicationContext` untuk membuat Application Context.
// - Contoh kode untuk membuat Application Context:
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html
public class ApplicationContextTest {

    @Test
    void testApplicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        Assertions.assertNotNull(context);
    }
}
