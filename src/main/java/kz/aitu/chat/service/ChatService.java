package kz.aitu.chat.service;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Participant;
import kz.aitu.chat.model.Users;
import kz.aitu.chat.repository.ChatRepository;
import kz.aitu.chat.repository.ParticipantRepository;
import kz.aitu.chat.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {
    private ChatRepository chatRepository;

    private ParticipantRepository participantRepository;

    private UsersRepository usersRepository;

    public List<Users> getUsersByChatId(Long chat_id) {
        List<Users> users = new ArrayList<>();
        if (chatRepository.existsById(chat_id)) {
            List<Participant> participants = participantRepository.findAllByChatId(chat_id);
            for (Participant participant : participants) {
                users.add(usersRepository.findById(participant.getUserId()).get());
            }
        }
        return users;
    }


    public List<Chat> findAllChatsByUserId(Long userId) {
        List<Chat> chatList = new ArrayList<>();
        List<Participant> participants = participantRepository.findAllByUserId(userId);

        for (Participant participant : participants) {
            chatList.add(chatRepository.findById(participant.getChatId()).get());
        }
        return chatList;
    }

    public List<Chat> findAll(){

        return chatRepository.findAll();
    }

    public void deleteById(Long id){

        chatRepository.deleteById(id);
    }

    public Chat save(Chat message){

        return chatRepository.save(message);
    }

    public Chat findById(Long id){

        return chatRepository.findById(id).get();
    }

}
