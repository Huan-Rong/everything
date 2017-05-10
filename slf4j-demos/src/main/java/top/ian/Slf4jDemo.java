package top.ian;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 需要注意的是，这个例子并没有引用任何的 logback 类，而是 import SLF4J 的类文件。
 *
 * 在绝大多数情况下，我们只需要 import SLF4J，并且不会去在意 logback 的存在。
 * Created by ian on 5/7/17.
 */
public class Slf4jDemo {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);
        logger.info("Hello World!");
        try {
           int i = 1/0;
        } catch (Exception e) {
            logger.error("Test", e);
        }

        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
