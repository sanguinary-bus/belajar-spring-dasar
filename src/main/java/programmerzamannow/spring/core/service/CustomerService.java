package programmerzamannow.spring.core.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import programmerzamannow.spring.core.repository.CustomerRepository;

// ## Field-Based Dependency Injection
//
// - Selain constructor dan setter, dependency injection juga bisa dilakukan langsung menggunakan field.
// - Caranya sama seperti setter, dengan menambahkan anotasi @Autowired pada field.
// - Spring secara otomatis mencari bean dengan tipe data yang sesuai.
//
// ### Kombinasi Dependency Injection
//
// - Field-based DI dapat digunakan bersamaan dengan Setter-based DI dan Constructor-based DI.
//
// ### Pentingnya Perhatian Terhadap Field-Based DI
//
// - Walaupun field-based DI masih dapat digunakan, Spring *tidak lagi* merekomendasikan
//   penggunaannya, terutama jika field bersifat privat.
// - Terdapat peringatan bahwa "field injection is not recommended", namun masih tetap memungkinkan.
//
// =============================================================================
//
// ## Qualifier
//
// - Jika terdapat bean dengan tipe data yang sama, Spring bisa bingung memilih
//   bean mana yang akan digunakan.
// - Solusinya adalah membuat salah satu bean menjadi primary, yang akan otomatis dipilih oleh Spring.
// - Alternatifnya, kita bisa menggunakan anotasi `@Qualifier` untuk memilih bean secara manual.
// - Anotasi `@Qualifier` dapat diterapkan pada konstruktor, setter method, atau field.
@Component
public class CustomerService {
    @Getter
    @Autowired
    @Qualifier("normalCustomerRepository")
    private CustomerRepository normalCustomerRepository;

    @Getter
    @Autowired
    @Qualifier("premiumCustomerRepository")
    private CustomerRepository premiumCustomerRepository;
}
