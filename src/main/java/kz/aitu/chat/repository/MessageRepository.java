package kz.aitu.chat.repository;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findLast10MessagesByChatId(Long chatId);

    List<Message> findLast10MessagesByUserId(Long userId);

    List<Message> findAllByIsReadFalseAndChatIdAndUserId(Long chatId, Long userId);

    List<Message> findAllByIsDeliveredFalseAndUserId(Long userId);

    List<Message> findAllByChatIdAndUserId(Long chatId, Long userId);

    List<Message> findAllByChatIdAndIsDeliveredFalse(Long chatId);

}


