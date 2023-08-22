package programmerzamannow.spring.core.application;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.listener.AppStartingListener;

import java.util.List;

@SpringBootApplication
public class FooApplication {
    @Bean
    public Foo foo() {
        return new Foo();
    }

    // - Selain @SpringBootApplication, bisa menggunakan kelas `SpringApplication`
    //   untuk membuat Application Context.
    // public static void main(String[] args) {
    //     ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
    //
    //     Foo foo = applicationContext.getBean(Foo.class);
    //     System.out.println(foo);
    // }
    //
    // ## Banner
    // - Spring Boot memiliki fitur banner, dimana saat aplikasi Spring Boot berjalan,
    //   kita bisa menampilkan tulisan banner di console
    //
    // ## Customizing Spring Application
    // - Kadang ada kalanya kita ingin melakukan pengaturan di Spring Application
    //   sebelum Application Context nya dibuat
    // - Pengaturan ini dapat dilakukan menggunakan berbagai metode yang disediakan oleh Spring Application,
    //   seperti `SpringApplication` dan `SpringApplicationBuilder`.
    //
    // ## Spring Application Event
    // public static void main(String[] args) {
    //     SpringApplication application = new SpringApplication(FooApplication.class);
    //
    //     // mematikan fitur banner
    //     application.setBannerMode(Banner.Mode.OFF);
    //
    //     // menambahkan Spring Application Event yaitu `AppStartingListener`
    //     application.setListeners(List.of(new AppStartingListener()));
    //
    //     ConfigurableApplicationContext applicationContext = application.run(args);
    //
    //     Foo foo = applicationContext.getBean(Foo.class);
    //     System.out.println(foo);
    // }
}
