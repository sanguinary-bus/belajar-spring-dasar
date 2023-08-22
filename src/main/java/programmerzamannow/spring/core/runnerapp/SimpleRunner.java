package programmerzamannow.spring.core.runnerapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// ## Application Runner
//
// - Application Runner adalah fitur di Spring Boot yang mirip dengan `CommandLineRunner`,
//   digunakan untuk mengeksekusi kode saat aplikasi berjalan.
// - Argument dari command line sudah di wrap dalam objek `ApplicationArguments`.
// - `ApplicationArguments` memiliki fitur parsing untuk command line argument.
// - `ApplicationRunner` digunakan dengan cara membuat sebuah bean yang
//   mengimplementasikan `ApplicationRunner` dan Spring akan secara otomatis menjalankan
//   metode `run()` pada bean tersebut saat aplikasi berjalan.
// - Application Runner dapat digunakan untuk mendapatkan dan memanfaatkan argumen dari
//   command line, seperti profile dan option-value.
// - Application Runner cocok untuk mengambil data yang lebih terstruktur dari command line argument.
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationArguments.html
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationRunner.html
@Slf4j
@Component
public class SimpleRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> profiles = args.getOptionValues("profiles");
        log.info("Profiles : {}", profiles);
    }
}
