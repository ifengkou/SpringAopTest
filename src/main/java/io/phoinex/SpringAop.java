package io.phoinex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect切面类 . <br />
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2019/5/29
 */
@Aspect
@Component
public class SpringAop {
    Logger logger = LoggerFactory.getLogger(SpringAop.class);
    /**
     * 1. 定义切点
     */
    @Pointcut("execution(* io.phoinex.HelloWorld.*(..))")
    public  void executeService(){
    }

    @Pointcut("execution(* io.phoinex.InterfaceTest.*(..))")
    public  void interfacePointcut(){
    }

    @Before("executeService()")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.error("----before我是前置通知");
        //获取目标方法的参数信息
        Object[] obj=joinPoint.getArgs();
        Signature signature=joinPoint.getSignature();
        logger.error("代理的方法是 ： "+signature.getName());
        logger.error("AOP 代理的名字 ： "+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        Class s = signature.getDeclaringType();
        logger.error(s.toString());

        if(obj!=null && obj.length>0){
            for(Object object : obj){
                logger.error("参数:"+object.toString());
            }
        }
    }

    @AfterReturning(value = "executeService()",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object keys){
        logger.error("----end后置通知执行了！！");
        logger.error("----end第一个后置返回通知的返回值是 ："+keys);
    }

    @Around(value = "executeService()",argNames = "pjp")  //环绕整个方法的前后
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.error("----进入方法前---环绕通知");
        Object[] args = pjp.getArgs();
        if(null!=args && args.length>0 && "sb".equals((String)args[0])){
            logger.error("----直接退出方法，跳过before通知和方法体，不包括After）---环绕通知");
            return null;
        }
        Object o = pjp.proceed();
        logger.error("----获取执行结果---环绕通知："+o.toString());
        logger.error("----退出方法后---环绕通知");
        return o;
    }

    @Around(value = "interfacePointcut()",argNames = "pjp")  //环绕整个方法的前后
    public Object testInterfaceAdvice(ProceedingJoinPoint pjp) throws Throwable {
        logger.error("----进入方法前---环绕通知");
        Object[] args = pjp.getArgs();
        if(null!=args && args.length>0 && "xxx".equals((String)args[0])){
            logger.error("----直接退出方法，跳过before通知和方法体，不包括After）---环绕通知");
            return null;
        }
        Object o = pjp.proceed();
        logger.error("----获取执行结果---环绕通知："+o.toString());
        logger.error("----退出方法后---环绕通知");
        return o;
    }
}
