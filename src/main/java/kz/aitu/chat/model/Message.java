package kz.aitu.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Message {
    public Long getId;
    public Long getUser_id;
    public Long getChat_id;
    public String getText;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long chat_id;
    private String text;
    private Long created_timestamp=System.currentTimeMillis();
    private long updated_timestamp=System.currentTimeMillis();


    public long getCreated_timestamp() {
        return created_timestamp;
    }
}
