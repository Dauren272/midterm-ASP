package kz.aitu.chat.controller;

import kz.aitu.chat.model.Message;
import kz.aitu.chat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
@AllArgsConstructor
public class MessageController {
    private MessageRepository messageRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(messageRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(messageRepository.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> addMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageRepository.save(message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id){
        messageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
 //  @PostMapping("/{id})
   //  public ResponseEntity<?>getLast10messages(){
    //   return ResponseEntity.ok(messageRepository.getLast10messages(user_id));
     ///  @PostMapping("/{id}"
      //   public ResponseEntity<?>getLast10messages(){
      //return ResponseEntity.ok(messageRepository.getLast10messages(chat_id));
     //  }
 @PutMapping("")
 public ResponseEntity<?> updateMessage(@RequestBody UpdateMessageCG updateMessageCG){
     return ResponseEntity.ok(messageService.updateMessageByID(updateMessageCG));
 }

    @GetMapping("/unDeliveredMessages/{chatId}")
 public ResponseEntity<?> getUnDeliveredMessages(@PathVariable Long chatId){
     return ResponseEntity.ok(messageService.getAllByChatIdAndIsDeliveredFalse(chatId));
 }

}
