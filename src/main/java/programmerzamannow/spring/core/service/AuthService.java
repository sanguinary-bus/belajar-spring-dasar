package programmerzamannow.spring.core.service;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// Dalam contoh kode, AuthService mengimplementasikan `ApplicationContextAware` dan `BeanNameAware`.
@Component
public class AuthService implements ApplicationContextAware, BeanNameAware {
    @Getter
    private String beanName;

    @Getter
    private ApplicationContext applicationContext;

    // `setBeanName()` akan diinjeksi oleh Spring dengan nama bean yang bersangkutan.
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    // `setApplicationContext()` akan diinjeksi oleh Spring dengan application context yang berkaitan.
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
