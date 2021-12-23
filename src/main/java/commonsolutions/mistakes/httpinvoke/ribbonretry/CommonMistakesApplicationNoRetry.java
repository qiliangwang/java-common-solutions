package commonsolutions.mistakes.httpinvoke.ribbonretry;

import commonsolutions.mistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CommonMistakesApplicationNoRetry {

    public static void main(String[] args) {

        Utils.loadPropertySource(CommonMistakesApplicationNoRetry.class,"noretry-ribbon.properties");
        SpringApplication.run(CommonMistakesApplicationNoRetry.class, args);
    }
}

