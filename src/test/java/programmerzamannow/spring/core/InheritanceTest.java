package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.service.MerchantService;
import programmerzamannow.spring.core.service.MerchantServiceImpl;

// ## Inheritance
//
// - Ketika mengakses bean, kita dapat menggunakan tipe kelas bean tersebut atau
//   parent class / parent interface dari bean tersebut.
// - Contoh, jika terdapat sebuah interface bernama `MerchantService`,
//   dan terdapat bean yang mengimplementasi interface tersebut dengan nama `MerchantServiceImpl`,
//   kita dapat mengakses bean tersebut menggunakan tipe `MerchantServiceImpl` atau `MerchantService`.
// - Perlu diingat bahwa jika parent interface memiliki banyak bean turunan,
//   harus dihindari *kemungkinan terjadinya error duplicate bean*.
// - Penggunaan parent interface saat mengakses bean berguna untuk fleksibilitas,
//   khususnya jika ingin mengganti implementasi bean tanpa merubah dependensi yang menggunakannya.
public class InheritanceTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testInheritance() {
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = applicationContext.getBean(MerchantServiceImpl.class);

        Assertions.assertSame(merchantService, merchantServiceImpl);
    }
}
