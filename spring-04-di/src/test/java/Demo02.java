import com.utaha.pojo.SetterBean;
import com.utaha.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    @Autowired
    private SetterBean setterBean;
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowireCandidateBean.xml");
        SetterBean.IService iService = context.getBean(SetterBean.IService.class);
        System.out.println(iService + "********");

    }
    @Test
    public void test3(){
        List<Object> objects = new ArrayList<>();


    }
}
