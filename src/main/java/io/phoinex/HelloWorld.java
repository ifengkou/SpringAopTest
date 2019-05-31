package io.phoinex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * . <br />
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2019/5/29
 */
@Component
public class HelloWorld{
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    
    public String printHello(String name,int age){
        String xx = ("print hello:"+name+",age="+age);
        logger.error(xx);
        return xx;
    }

    public String printWorld(String name,int age){
        String xx = ("say world:"+name+",age="+age);
        logger.error(xx);
        return xx;
    }


}
