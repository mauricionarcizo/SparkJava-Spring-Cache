package sparkteste;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.google.common.cache.CacheBuilder;

@Configuration
@ComponentScan({ "sparkteste" })
@EnableCaching
public class HelloWork {
    public static void main(final String[] args) {

        try (final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWork.class)) {
            new WebConfig(ctx.getBean(MyService.class));
            ctx.registerShutdownHook();
        }
    }

    @Primary
    @Bean
    public CacheManager sadasdsa() {
        return new ConcurrentMapCacheManager() {

            @Override
            protected Cache createConcurrentMapCache(final String name) {
                final ConcurrentMap<Object, Object> asMap = CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.SECONDS).maximumSize(100).build().asMap();
                return new ConcurrentMapCache(name, asMap, false);
            }
        };
    }

}
