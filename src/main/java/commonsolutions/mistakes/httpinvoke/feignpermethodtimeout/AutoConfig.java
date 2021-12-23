package commonsolutions.mistakes.httpinvoke.feignpermethodtimeout;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "org.geekbang.time.commonsolutions.mistakes.httpinvoke.feignpermethodtimeout")
public class AutoConfig {
}
