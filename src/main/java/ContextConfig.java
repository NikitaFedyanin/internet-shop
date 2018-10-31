import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class ContextConfig {

        @PersistenceContext
        private  EntityManagerFactory entityManagerFactory;

        @Bean
        public void entityManagerFactory(){
            entityManagerFactory = Persistence.createEntityManagerFactory("persistence-name", setting());
        }


         @Bean
         public Map setting(){
            Map<String, String> settings = new HashMap<String, String>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/internet_shop");
        settings.put(Environment.USER, "postgres");
        settings.put(Environment.PASS, "admin");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgresPlusDialect");
        return settings;
        }

        @Bean
        public void entityManager(){
            entityManagerFactory.createEntityManager();
        }

}
