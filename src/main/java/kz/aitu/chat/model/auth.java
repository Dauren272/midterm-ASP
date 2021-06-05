package kz.aitu.chat.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String login;
    protected long password;
    private long last_login_timestamp;
    private Long user_id;
    private UUID token;

    public auth() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public long getLast_login_timestamp() {
        return last_login_timestamp;
    }

    public void setLast_login_timestamp(long last_login_timestamp) {
        this.last_login_timestamp = last_login_timestamp;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public auth(String login, long password, long last_login_timestamp, Long user_id, UUID token) {
        this.login = login;
        this.password = password;
        this.last_login_timestamp = last_login_timestamp;
        this.user_id = user_id;
        this.token = token;
    }
}

