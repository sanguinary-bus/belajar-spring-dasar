package programmerzamannow.spring.core;

import org.springframework.context.annotation.Configuration;

// ## Inversion of Control (IoC):
//
// - Inversion of Control (IoC) adalah prinsip dalam pembuatan perangkat lunak.
// - Dalam IoC, kontrol dan eksekusi program dipindahkan ke dalam sebuah container
//   di dalam sebuah framework.
// - IoC melibatkan penyerahan kontrol dan manajemen objek ke dalam container,
//   yang abstrak dari program kita.
// - Dalam IoC, pekerjaan yang biasanya dilakukan secara manual dapat diberikan
//   kepada container IoC.
//
// ## Spring Inversion of Control:
//
// - Spring merupakan contoh framework IoC.
// - Spring Framework mewujudkan prinsip IoC, dimana pekerjaan dalam program
//   kita diberikan kepada Spring.
// - Kontainer IoC dalam Spring adalah ApplicationContext.
// - Kode program kita akan mengikuti cara kerja Spring Framework.
// - Menggunakan Spring Framework mengharuskan kita mengikuti aturan dan cara kerjanya.
//
// ## Diagram Inversion of Control
//
//             inversion of control
// ┌───────────────────────────────────────────┐
// │                                           │
// │ ┌───────────┐ ┌───────────┐ ┌───────────┐ │
// │ │           │ │           │ │           │ │
// │ │   kode    │ │   kode    │ │   kode    │ │
// │ │  program  │ │  program  │ │  program  │ │
// │ │           │ │           │ │           │ │
// │ └───────────┘ └───────────┘ └───────────┘ │
// │                                           │
// └───────────────────────────────────────────┘
@Configuration
public class HelloWorldConfiguration {
}
