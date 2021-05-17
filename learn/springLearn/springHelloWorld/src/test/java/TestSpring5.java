import com.jia.spring5.Book;
import com.jia.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void addTest(){
        //1、加载Spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2、获取在xml配置的对象
        User user = context.getBean("user",User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testBookSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
}
