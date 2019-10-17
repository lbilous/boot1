package hello;

// Колонки : АйДи, Айди автора, время создания, собственно текст поста
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String login;
        private Timestamp time;
        private String text;

        protected Post() {
        }

        public Post(String login, Timestamp time, String text) {
            this.login = login;
            this.time = time;
            this.text = text;
        }

    @Override
    public String toString() {
        return String.format(
                "Account[id=%d, login='%s', time='%s', text='%s']",
                id, login, time, text);
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getText() {
            return text;
    }
}
