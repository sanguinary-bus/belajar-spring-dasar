package programmerzamannow.spring.core.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// - https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring/
@Slf4j
public class Connection implements InitializingBean, DisposableBean {
    @Override
    // It is the `init()` method of our bean, and it gets
    // invoked on bean instantiation
    public void afterPropertiesSet() throws Exception {
        log.info("Connection is ready to be used");
    }

    @Override
    // This method is invoked just after the container
    // is closed
    public void destroy() throws Exception {
        log.info("Connection is closed");
    }
}
