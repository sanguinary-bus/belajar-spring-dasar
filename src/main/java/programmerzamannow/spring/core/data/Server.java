package programmerzamannow.spring.core.data;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// ### Spring Bean Life Cycle Diagram
//
//                ┌─────────────┐        ┌────────────┐        ┌────────────────┐
//                │ Instantiate │        │  Populate  │        │ BeanNameAware  │
//                │    Bean     ├────────► Properties ├────────► .setBeanName() ├────┐
//                └─────────────┘        └────────────┘        └────────────────┘    │
//                                                                                   │
// ┌────────────────────────────────────┐   ┌──────────────────────────┐   ┌─────────▼─────────┐
// │         BeanPostProcessor          │   │ ApplicationContextAware  │   │ BeanFactoryAware  │
// │ .postProcessBeforeInitialization() ◄───┤ .setApplicationContext() ◄───┤ .setBeanFactory() │
// └──────────────────┬─────────────────┘   └──────────────────────────┘   └───────────────────┘
//                    │
//            ┌───────┴────────┐   ┌───────────────────────┐   ┌───────────────────┐
//            │  Method with   │   │    InitializingBean   │   │ Custom configured │
//            │ @PostConstruct ├───► .afterPropertiesSet() ├───►   initMethod()    │
//            └────────────────┘   └───────────────────────┘   └──────────┬────────┘
//                                                                        │
//                    ┌──────────────┐                     ┌────────────┐ │
//                    │ Container is │   Bean performing   │ Bean ready │ │
//                    │   Shutdown   ◄─────────────────────┤  to use    ◄─┘
//                    └──┬───────────┘        task         └────────────┘
//                       │
//                ┌──────▼──────┐     ┌────────────────┐     ┌───────────────────┐
//                │ Method with │     │ DisposableBean │     │ Custom configured │
//                │ @PreDestroy ├─────►  .destroy()    ├─────►  destroyMethod()  │
//                └─────────────┘     └────────────────┘     └────────┬──────────┘
//                                                                    │
//                                ┌─────┐         ┌─────────────┐     │
//                                │ End │         │   Object    │     │
//                                │     ◄─────────┤ .finalize() ◄─────┘
//                                └─────┘         └─────────────┘
//
// - https://www.concretepage.com/spring/spring-bean-life-cycle-tutorial
@Slf4j
public class Server {
    @PostConstruct
    public void start() {
        log.info("Start Server");
    }

    @PreDestroy
    public void stop() {
        log.info("Stop Server");
    }
}
