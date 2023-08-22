package programmerzamannow.spring.core.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// ## Object Provider
//
// - Selain `java.util.Optional<T>`, kita juga dapat menggunakan `ObjectProvider<T>`.
// - Perbedaannya, `ObjectProvider<T>` dapat digunakan untuk mengambil semua bean
//   jika ada lebih dari satu bean yang cocok dengan tipe yang diberikan.
// - ObjectProvider<T> dapat digunakan untuk mengambil semua bean atau mengambil primary bean.
// - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ObjectProvider.html
@Component
public class MultiFoo {
    @Getter
    private List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider) {
        foos = objectProvider.stream().collect(Collectors.toList());
    }
}
