package kz.aitu.chat.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class MessageCG{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long chat_id;
    private String text;
    private Date created_timestamp;
    private Date updated_timestamp;
    private String messageType;

    public MessageCG(Long id, Long user_id, Long chat_id, String text, Date created_timestamp, Date updated_timestamp) {
        this.id = id;
        this.user_id = user_id;
        this.chat_id = chat_id;
        this.text = text;
        this.created_timestamp = created_timestamp;
        this.updated_timestamp = updated_timestamp;
        this.messageType=messageType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }
    public String getMessageType(){
        return this.messageType;
    }

    public void setMessageType(String type){
        this.messageType = type;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(Date created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public Date getUpdated_timestamp() {
        return updated_timestamp;
    }

    public void setUpdated_timestamp(Date updated_timestamp) {
        this.updated_timestamp = updated_timestamp;
    }



}