package programmerzamannow.spring.core.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import programmerzamannow.spring.core.data.Foo;

import static org.junit.jupiter.api.Assertions.*;

// ## Spring Boot Application
// - Sebelumnya kita selalu membuat `ApplicationContext` secara manual,
//   dan kita belum menggunakan fitur otomatis Spring Boot
// - Hal ini sengaja agar kita tidak kaget bagaimana semua itu bisa
//   berjalan secara otomatis dan memahami dasar-dasar cara kerja di Spring Boot.
// - Pada saat membuat aplikasi Spring Boot, kita akan mengganti `@Configuration` utama
//   menjadi `@SpringBootApplication`
// - Isi dari `@SpringBootApplication` itu sendiri sebenarnya gabungan dari `@Configuration`
//   dan banyak hal lain, seperti contohnya `@ComponentScan`, dkk
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html
//
// ## Spring Application
// - Selain `@SpringBootApplication`, untuk membuat Application Context nya,
//   kita tidak perlu membuat manual, kita bisa gunakan class `SpringApplication`
// - Secara otomatis `SpringApplication` akan membuat `ApplicationContext`
//   dan melakukan hal-hal yang dibutuhkan secara otomatis
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
//
// ## Spring Boot Test
// - Untuk membuat unit test di Spring Boot, kita bisa menggunakan annotation
//   `@SpringBootTest(classes={YourConfiguration.class})`
// - Selanjutnya kita tidak perlu mengambil bean secara manual lagi menggunakan
//  `ApplicationContext`, kita bisa menggunakan DI secara langsung di unit test nya
//   menggunakan `@Autowired`
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html
//
// =============================================================================
//
// ## Startup Failure:
//
// - Spring Boot memiliki fitur menarik yang disebut `FailureAnalyzer`.
// - `FailureAnalyzer` digunakan untuk menganalisis error saat startup yang
//   mengakibatkan aplikasi tidak berjalan.
// - Spring Boot menyediakan berbagai implementasi kelas `FailureAnalyzer` untuk
//   menganalisis startup failure.
// - Saat digunakan, FailureAnalyzer memberikan deskripsi error dan solusi
//   yang jelas dan mempermudah proses troubleshooting dan debugging saat startup failure.
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/diagnostics/FailureAnalyzer.html
//
// =============================================================================
//
// ## Banner
// - Spring Boot memiliki fitur banner, dimana saat aplikasi Spring Boot berjalan,
//   kita bisa menampilkan tulisan banner di console
// - Secara default fitur banner ini akan menyala dan akan mencari tulisan banner
//   di classpath dengan nama banner.txt
// - Jika tidak ada file tersebut, maka secara otomatis akan menampilkan tulisan banner Spring Boot
// - Salah satu contoh tempat untuk membuat banner adalah http://www.bagill.com/ascii-sig.php
//
// =============================================================================
//
// ## Customizing Spring Application
// - Kadang ada kalanya kita ingin melakukan pengaturan di Spring Application
//   sebelum Application Context nya dibuat
// - Pengaturan ini dapat dilakukan menggunakan berbagai metode yang disediakan oleh Spring Application,
//   seperti `SpringApplication` dan `SpringApplicationBuilder`.
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/builder/SpringApplicationBuilder.html
//
// =============================================================================
//
// ## Spring Application Event
// - Sebelumnya kita sudah belajar tentang Event Listener
// - Di Spring Boot, terdapat banyak event yang dikirim ketika aplikasi Spring Boot berjalan.
// - Kita bisa membuat event listener untuk menerima event-event ini.
// - Event-event ini adalah turunan dari `SpringApplicationEvent`.
// - Penggunaan event listener dalam Spring Boot agak berbeda dari event listener
//   biasa karena beberapa event di-trigger bahkan sebelum Application Context dibuat.
// - Untuk memastikan listener berfungsi dengan baik, lebih aman menambahkannya
//   saat membuat SpringApplication.
//
// ### Pentingnya Spring Application Event:
//
// - Spring Application Event memungkinkan kita untuk merespons event yang terjadi
//   dalam siklus hidup Spring Boot aplikasi.
// - Dengan menggunakan listener, kita dapat menjalankan kode tertentu saat
//   event terjadi, membantu dalam proses konfigurasi atau tindakan kustom.
@SpringBootTest(classes = FooApplication.class)
class FooApplicationTest {
    @Autowired
    Foo foo;

    @Test
    void testSpringBoot() {
        Assertions.assertNotNull(foo);
    }
}