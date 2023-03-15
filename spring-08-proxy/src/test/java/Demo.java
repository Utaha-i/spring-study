import com.utaha.demo05.Calculator;
import com.utaha.demo05.impl.CalculatorPureImpl;
import com.utaha.demo05.proxy.LogDynamicProxyFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
@Slf4j
public class Demo {
    @Test
    public void testDynamicProxy() {

        // 1.创建被代理的目标对象
        Calculator target = new CalculatorPureImpl();

        // 2.创建能够生产代理对象的工厂对象
        LogDynamicProxyFactory<Calculator> factory = new LogDynamicProxyFactory<>(target);

        // 3.通过工厂对象生产目标对象的代理对象
        Calculator proxy = factory.getProxy();

        // 4.通过代理对象间接调用目标对象
        int addResult = proxy.add(10, 2);
        log.debug("方法外部 addResult = " + addResult + "\n");

        int subResult = proxy.sub(10, 2);
        log.debug("方法外部 subResult = " + subResult + "\n");

        int mulResult = proxy.mul(10, 2);
        log.debug("方法外部 mulResult = " + mulResult + "\n");

        int divResult = proxy.div(10, 2);
        log.debug("方法外部 divResult = " + divResult + "\n");
    }
}
