package programmerzamannow.spring.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

// ### Daftar Spring Application Event
//
// | Event                               | Keterangan                                                                                                                                                |
// |-------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
// | ApplicationStartingEvent            | Dikirim ketika aplikasi sedang dimulai.                                                                                                                   |
// | ApplicationContextInitializedEvent  | Dikirim ketika ApplicationContext sudah diinisialisasi, tetapi sebelum Spring membuat bean.                                                               |
// | ApplicationPreparedEvent            | Dikirim setelah ApplicationContext diinisialisasi dan sebelum bean dibuat. Berguna untuk memodifikasi ApplicationContext sebelum penggunaan sebenarnya.   |
// | ApplicationStartedEvent             | Dikirim ketika aplikasi telah sepenuhnya berjalan dan siap menerima permintaan.                                                                           |
// | ApplicationReadyEvent               | Dikirim ketika aplikasi sudah sepenuhnya berjalan dan siap menerima permintaan. Pada titik ini, command-line runner dan bean terjadwal sudah dijalankan.  |
// | ApplicationFailedEvent              | Dikirim ketika aplikasi gagal untuk berjalan.                                                                                                             |
// | ApplicationEnvironmentPreparedEvent | Dikirim sebelum ApplicationContext diinisialisasi, biasanya digunakan untuk mengkustomisasi environment aplikasi.                                         |
// | ApplicationPreparedEvent            | Dikirim setelah ApplicationContext diinisialisasi dan sebelum bean dibuat.                                                                                |
// | ApplicationStartedEvent             | Dikirim ketika aplikasi sudah sepenuhnya berjalan dan siap menerima permintaan.                                                                           |
// | ApplicationReadyEvent               | Dikirim ketika aplikasi sudah sepenuhnya berjalan dan siap menerima permintaan.                                                                           |
// | ApplicationFailedEvent              | Dikirim ketika aplikasi gagal untuk berjalan. |
@Slf4j
public class AppStartingListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("Application starting");
    }
}
