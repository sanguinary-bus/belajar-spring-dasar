# Spring Boot Plugin & Distribution File

## Spring Boot Plugin

- Saat kita membuat proyek Spring Boot, proyek maven akan otomatis memiliki spring-boot-plugin.
- `spring-boot-plugin` digunakan untuk mempermudah menjalankan aplikasi Spring Boot.
- Perintah `mvn spring-boot:run` digunakan untuk menjalankan aplikasi Spring Boot.
- Hanya boleh ada satu main class di proyek Spring Boot.
- Jika terdapat lebih dari satu main class, akan menyebabkan kesalahan saat menjalankan dengan `spring-boot:run`.
- [Spring Boot Maven Plugin Documentation](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)

## Distribution File

- `spring-boot-plugin` juga mendukung pembuatan distribusi file aplikasi.
- Plugin ini akan mendeteksi main class dalam proyek dan menggabungkan aplikasi dan dependensi menjadi satu file JAR.
- Pastikan hanya ada satu main class, jika lebih dari satu, plugin akan menghasilkan kesalahan.
- Perintah `mvn package` digunakan untuk membuat distribusi file.
- [Spring Boot Executable Jars Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-executable-jars)