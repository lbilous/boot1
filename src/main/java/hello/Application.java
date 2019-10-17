package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Bean
    public CommandLineRunner demo(
            AccountRepository repository,
            PostRepository repoPosts
            ) {
        return (args) -> {
            // save a few customers
            repository.save(new Account("Jack", "Bauer"));  // insert into account value (1, 'Jack', 'Bauer');
            repository.save(new Account("Chloe", "O'Brian"));
            repository.save(new Account("Kim", "Bauer"));
            repository.save(new Account("David", "Palmer"));
            repository.save(new Account("Michelle", "Dessler"));

            // save a few posts
            repoPosts.save(new Post("Jack", Timestamp.valueOf("2019-01-02 14:30:59"), "Hello, this is my first post"));
            repoPosts.save(new Post("Jack", Timestamp.valueOf("2019-01-02 14:31:59"), "This is a second one"));
            repoPosts.save(new Post("Jack", Timestamp.valueOf("2019-01-02 14:32:59"), "Tired, I go to sleep. Bye!"));

            // fetch an individual customer by login
            Account customer = repository.findByLogin("Chloe");
            log.info("Customer found with findByLogin(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");


            List<Post> p1 = repoPosts.findByLogin("Jack");
            log.info("Found posts for Jack:");
            for (Post p: p1)
                log.info(p.toString());

        };
    }

}