package programmerzamannow.spring.core.commandapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// ## Command Line Runner
//
// - Command Line Runner adalah fitur di Spring Boot yang memungkinkan kita
//   untuk menjalankan kode khusus secara otomatis saat aplikasi Spring Boot berjalan.
// - Saat membuat aplikasi, kita kadang memerlukan argumen yang akan diberikan
//   pada method main. Spring Application bisa mengirim data argumen tersebut secara
//   otomatis ke bean yang kita buat.
// - Cara mengimplementasikan Command Line Runner adalah dengan membuat bean yang
//   mengimplementasikan interface `CommandLineRunner`.
// - Kelas yang mengimplementasikan `CommandLineRunner` akan memiliki metode `run()`,
//   yang akan dieksekusi secara otomatis ketika aplikasi berjalan.
// - Argumen yang diberikan pada method main dari command line atau konfigurasi lainnya
//   akan otomatis dikirimkan sebagai parameter ke metode `run()`.
// - CommandLineRunner secara otomatis akan di jalankan ketika Spring Application berjalan
// - Penggunaan Command Line Runner sangat berguna untuk menjalankan kode inisialisasi,
//   mengisi data awal, atau melakukan tindakan tertentu saat aplikasi berjalan.
// - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/CommandLineRunner.html
@Slf4j
@Component
public class LogCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Log Command Line Runner : {}", Arrays.toString(args));
    }
}
