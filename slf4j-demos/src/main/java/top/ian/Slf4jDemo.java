package top.ian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ian on 5/7/17.
 */
public class Slf4jDemo {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);
        logger.info("Hello World!");
    }
}
