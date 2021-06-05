package kz.aitu.chat.controller;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.auth;
import kz.aitu.chat.repository.ParticipantRepository;
import kz.aitu.chat.repository.UsersRepository;
import kz.aitu.chat.service.AuthService;
import kz.aitu.chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/chats")
@AllArgsConstructor
public class ChatController {
    private ChatService chatService;

    private UsersRepository usersRepository;

    private ParticipantRepository participantRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(chatService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        return ResponseEntity.ok(chatService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> addChat(@RequestBody Chat chat){

        return ResponseEntity.ok(chatService.save(chat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChat(@PathVariable Long id){
       chatService.deleteById(id);
       return ResponseEntity.noContent().build();
    }
    @GetMapping("/find/{userId}")
    public ResponseEntity<?> findAllChatsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(chatService.findAllChatsByUserId(userId));
    }

    @GetMapping("/findUsers/{chatId}")
    public ResponseEntity<?> findAllByChatId(@PathVariable Long chatId, @RequestHeader(name = "token")Long token) {
        auth auth= AuthService.getToken(token);
        return ResponseEntity.ok(chatService.getUsersByChatId(chatId,auth.getUser_id()));
    }

}
