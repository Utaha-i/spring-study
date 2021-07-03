import com.utaha.mapper.CustomerMapper;
import com.utaha.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerMapper customerMapperImpl = context.getBean("customerMapper",CustomerMapper.class);

        List<Customer> customers = customerMapperImpl.selectCustomer();
        for (Customer customer:customers) {
            System.out.println(customer);
        }
    }

}
