import cn.dz.daima.StartApp;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApp.class)
@WebAppConfiguration
public class RedisTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        });
        t1.start();
        t2.start();

    }

    public static void test(){
        int a = 0;
        for (int i = 0; i < 10000; i++) {
            a++;
            System.out.println("a = " + a);
        }
    }

    public static void test2(){
        int b = 0;
        for (int i = 0; i < 10000; i++) {
            b++;
            System.out.println("b = " + b);
        }
    }
}
