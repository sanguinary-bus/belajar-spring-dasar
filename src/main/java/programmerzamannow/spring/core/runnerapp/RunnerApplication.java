package programmerzamannow.spring.core.runnerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// menjalankan `RunnerApplication` dan semua `@Component` yang ada
// dalam paket yang sama yang dimiliki oleh `SimpleRunner`.
@SpringBootApplication
public class RunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }
}
