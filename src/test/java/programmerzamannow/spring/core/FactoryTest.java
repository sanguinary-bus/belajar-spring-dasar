package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.client.PaymentGatewayClient;

// ## Factory Bean
//
// - Dalam beberapa kasus, terdapat kelas yang bukan milik kita, seperti kelas dari
//   pihak ketiga atau library.
// - Pada kasus tersebut, sulit untuk menambahkan anotasi pada kelas tersebut karena
//   kita tidak bisa mengontrolnya.
// - Solusi terbaik adalah membuat bean menggunakan metode `@Bean` atau menggunakan `@Component`
//   dengan memanfaatkan konsep Factory Bean.
// - Factory Bean memungkinkan kita membuat bean dengan cara yang lebih fleksibel,
//   terutama ketika kita tidak dapat mengubah kelas tersebut atau kelas yang bukan milik kita.
// - Penggunaan Factory Bean sangat berguna dalam integrasi dengan library atau
//   framework pihak ketiga yang tidak dapat diubah.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/FactoryBean.html
public class FactoryTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFactory() {
        PaymentGatewayClient paymentGatewayClient = applicationContext.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(paymentGatewayClient);
        Assertions.assertEquals("https://example.com", paymentGatewayClient.getEndpoint());
        Assertions.assertEquals("private", paymentGatewayClient.getPrivateKey());
        Assertions.assertEquals("public", paymentGatewayClient.getPublicKey());
    }
}
