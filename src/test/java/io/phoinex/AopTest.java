package io.phoinex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * . <br />
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2019/5/29
 */
@SpringBootTest(classes = AppMain.class)
@RunWith(SpringRunner.class)
public class AopTest {


    @Autowired
    HelloWorld helloWorld;

    @Autowired
    InterfaceTest interfaceTest;

    @Test
    public void testAop(){
        helloWorld.printHello("xxxx",1);
        helloWorld.printWorld("sb",1);
        //面向接口切
        interfaceTest.testAbc("afdadfa");
    }

}
