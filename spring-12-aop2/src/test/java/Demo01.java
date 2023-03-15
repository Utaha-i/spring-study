import com.utaha.aop.AopInter;
import com.utaha.service.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class Demo01 {

    @Autowired
    private Calculator calculator;

    @Test
    public void testAnnotationAOP() {

        int add = calculator.add(10, 2);
        log.debug("方法外部 add = " + add);

    }

}
