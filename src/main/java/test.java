import dao.UserDAO;
import entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        UserDAO bean = context.getBean(UserDAO.class);
        User user = new User();
        user.setName("PETYA");
        user.setAdress("moscow");
        user.setKind_of_payment("cash");
        System.out.println( bean.create(user));


       /* List<User> all = bean.getAll();
        for (User user1 : all) {
            System.out.println(user1);

        }*/
    }
}
