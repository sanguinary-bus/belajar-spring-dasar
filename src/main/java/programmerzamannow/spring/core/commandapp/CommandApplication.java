package programmerzamannow.spring.core.commandapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// menjalankan `CommandApplication` dan semua `@Component` yang ada
// dalam paket yang sama yang dimiliki oleh `LogCommandLineRunner`.
@SpringBootApplication
public class CommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
}
