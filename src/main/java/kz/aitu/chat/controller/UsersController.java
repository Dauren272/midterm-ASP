package kz.aitu.chat.controller;


import kz.aitu.chat.model.Users;
import kz.aitu.chat.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UsersController {
    private UsersRepository usersRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(usersRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(usersRepository.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody Users user){
        return ResponseEntity.ok(usersRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        usersRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
