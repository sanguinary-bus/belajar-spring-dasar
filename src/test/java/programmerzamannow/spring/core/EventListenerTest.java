package programmerzamannow.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import programmerzamannow.spring.core.listener.LoginAgainSuccessListener;
import programmerzamannow.spring.core.listener.LoginSuccessListener;
import programmerzamannow.spring.core.listener.UserListener;
import programmerzamannow.spring.core.service.UserService;

// ## Event Listener:
//
// - Spring memiliki fitur Event Listener untuk komunikasi antar kelas menggunakan event.
// - Event di Spring adalah objek turunan dari `ApplicationEvent`,
//   sedangkan Listener adalah turunan dari `ApplicationListener` yang mendengarkan event tertentu.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEvent.html
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationListener.html
//
// ## Application Event Publisher:
//
// - Application Event Publisher digunakan untuk mengirim event ke listener,
//   bisa melalui objek `ApplicationEventPublisher` atau menggunakan `ApplicationEventPublisherAware`.
// - `ApplicationEventPublisher` juga merupakan super interface dari `ApplicationContext`.
// - `ApplicationEventPublisherAware` digunakan untuk mendapatkan objek `ApplicationEventPublisher`.
// - Keuntungan menggunakan event listener adalah memungkinkan komunikasi longgar antar komponen
//   tanpa harus menghubungkan mereka secara langsung.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEventPublisher.html
//
// =============================================================================
//
// ## Event Listener Annotation:
//
// - Selain menggunakan ApplicationListener interface, kita bisa menggunakan
//   annotation untuk membuat listener.
// - Ini lebih fleksibel dibandingkan menggunakan ApplicationListener interface.
// - Annotation @EventListener digunakan untuk menandai method sebagai listener.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/EventListener.html
//
// ### Cara Kerja Event Listener Annotation:
//
// - Annotation @EventListener bekerja menggunakan Bean Post Processor yang disebut
//   `EventListenerMethodProcessor`.
// - `EventListenerMethodProcessor` mendeteksi method dengan annotation @EventListener pada bean,
//    maka akan membuat listener baru dan mendaftarkannya ke
//    `ApplicationContext.addApplicationListener(listener)`.
public class EventListenerTest {
    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,         // listener yang memakai `ApplicationListener`
            LoginAgainSuccessListener.class,
            UserListener.class                  // listener yang memakai `@EventListener`
    })
    public static class TestConfiguration {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {
        UserService userService = applicationContext.getBean(UserService.class);

        // login menggunakan method `userService.login`
        userService.login("eko", "eko");
        userService.login("eko", "salah");
        userService.login("kurninawan", "salah");
    }
}
