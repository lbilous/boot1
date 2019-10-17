package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    //"Hello, " + name + "!"
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        System.out.println("Call detected with name : "+ name);

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @Autowired
    AccountRepository repository;


    @RequestMapping("/acc")
    public Account account(@RequestParam(value = "login") String login){
        Account account = repository.findByLogin(login); // select * from account where login = :1
        return account;
    }

    @Autowired
    PostRepository TextRepository;

    @RequestMapping("/accyuofyhkjfgghkfjhgv")
    public List<Post> post(@RequestParam(value = "login") String login){
        List<Post> post = TextRepository.findByLogin(login);  // select * from post where login = :1
        return post;
    }
}

