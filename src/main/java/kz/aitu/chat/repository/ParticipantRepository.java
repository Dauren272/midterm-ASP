package kz.aitu.chat.repository;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findAllByUserId(Long userId);
    List<Participant> findAllByChatId(Long chatId);
}
