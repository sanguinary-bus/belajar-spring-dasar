package programmerzamannow.spring.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.scope.DoubletonScope;

// ## Membuat Custom Scope:
//
// ### Kebutuhan untuk Custom Scope:
// - Jika built-in scope yang disediakan oleh Spring tidak memenuhi kebutuhan,
//   kita dapat membuat custom scope sendiri.
//
// ### Langkah Membuat Custom Scope:
// - Buat sebuah class yang mengimplementasikan interface org.springframework.beans.factory.config.Scope.
// - Interface Scope memiliki beberapa method penting seperti get, remove, dan lain-lain
//   yang perlu diimplementasikan.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/Scope.html

// ### Method Penting pada Interface Scope:
// - get(name, objectFactory): Digunakan untuk mendapatkan objek dari scope.
// - remove(name): Digunakan untuk menghapus objek dari scope.
// - Method lain seperti registerDestructionCallback, resolveContextualObject,
//   dan getConversationId bersifat opsional dan mungkin tidak perlu diimplementasikan.
//
// ### Registrasi Custom Scope:
// - Gunakan class CustomScopeConfigurer untuk meregistrasikan custom scope ke dalam Spring.
// - Registrasikan custom scope dengan menambahkannya ke dalam CustomScopeConfigurer.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/CustomScopeConfigurer.html
//
// ### Contoh Custom Scope - DoubleTonScope:
// - DoubleTonScope adalah contoh custom scope yang dibuat dalam materi.
// - DoubleTonScope membatasi jumlah objek yang dibuat menjadi dua dan
//   mengembalikan objek pertama jika melebihi batas.
@Slf4j
@Configuration
public class ScopeConfiguration {
    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Create new Foo");
        return new Foo();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar() {
        log.info("Create new Bar");
        return new Bar();
    }
}
