package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// ## Singleton:
//
// - Singleton adalah sebuah Design Pattern untuk pembuatan objek
//   di mana objek tersebut hanya dibuat satu kali.
// - Ketika membutuhkan objek tersebut, hanya akan menggunakan objek yang sama.
// - Singleton memastikan hanya ada satu instance dari kelas tertentu dalam aplikasi.
// - Singleton menerapkan prinsip Inversion of Control (IoC) di mana
//   kontrol pembuatan objek diberikan ke kelas lain.
// - Contoh: Dalam konteks Spring Framework, objek yang dibuat oleh Spring secara default adalah singleton.
// - https://refactoring.guru/design-patterns/singleton
//
// ### Membuat Singleton di Java:
//
// Untuk membuat singleton di Java, langkah yang umum digunakan adalah:
//
// - Membuat class dengan method static untuk membuat objek sendiri.
// - Membuat constructor private agar tidak bisa diakses dari luar.
// - Menggunakan konsep shared instance untuk mengembalikan objek yang sama.
public class DatabaseTest {

    @Test
    void testSingleton() {
        var database1 = Database.getInstance();
        var database2 = Database.getInstance();

        Assertions.assertSame(database1, database2);

    }
}
