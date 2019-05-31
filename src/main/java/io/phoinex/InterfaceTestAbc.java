package io.phoinex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * . <br />
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2019/5/31
 */
@Component
public class InterfaceTestAbc implements InterfaceTest {
    Logger logger = LoggerFactory.getLogger(InterfaceTestAbc.class);
    @Override
    public String testAbc(String abc) {
        String xx = ("testAbc hello:"+abc);
        logger.error(xx);
        return xx;
    }
}
