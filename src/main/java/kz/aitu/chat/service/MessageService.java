package kz.aitu.chat.service;

import kz.aitu.chat.model.Message;
import kz.aitu.chat.model.MessageCG;
import kz.aitu.chat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
    public class MessageService {
        private MessageRepository messageRepository;

        public List<Message> findAll() {
            List<Message> messages= messageRepository.findAll();
            return messageRepository.findAll();
        }

        public MessageCG findById(Long id) {
            Optional<Message> message= messageRepository.findById(id);
            Date date = new Date(message.get().getCreated_timestamp());

            MessageCG messageCG= new MessageCG(
                    message.get().getId,
                    message.get().getUser_id,
                    message.get().getChat_id,
                    message.get().getText,
                    date,
                    date
            );
            return messageCG;

        }
    //in process but not working
    //public List<Message> getLast10messages{
     //   List<Message> messages= messageRepository.getLast10messages(chat_id);
       // List<Message> getLast10messagesDesc(long chat_id);
      //  return messageRepository.getLast10messages;
    //}
    //in process but not working
    //public List<Message> getLast10messages{
      //  List<Message> messages= messageRepository.getLast10messages(user_id);
       // List<Message> getLast10messagesDesc(long user_id);
      //  return messageRepository.getLast10messages;
    //}


    public Message save(Message message) {
        if (message.getMessageType()==("basic")){
            message.setMessageType(message.getText());
        }
        else if (message.getMessageType()==("online")){
            message.setMessageType("user in chat");
        }
        else if (message.getMessageType()==("writing")){
            message.setMessageType("user starts write message");
        }

        return messageRepository.save(message);
    }








    public void deleteById(Long id) {

            messageRepository.deleteById(id);
        }
    }


