package commonsolutions.mistakes.httpinvoke.ribbonretry;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "org.geekbang.time.commonsolutions.mistakes.httpinvoke.ribbonretry.feign")
public class AutoConfig {
}
