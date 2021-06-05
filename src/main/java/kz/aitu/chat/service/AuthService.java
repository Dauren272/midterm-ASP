package kz.aitu.chat.service;

import kz.aitu.chat.model.Users;
import kz.aitu.chat.model.auth;
import kz.aitu.chat.repository.AuthRepository;
import kz.aitu.chat.repository.ChatRepository;
import kz.aitu.chat.repository.UsersRepository;

import java.util.Date;
import java.util.UUID;

public class AuthService {
    private final AuthRepository authRepository;
    private final UsersRepository usersRepository;
    private final ChatRepository chatRepository;

    public AuthService(AuthRepository authRepository, UsersRepository usersRepository, ChatRepository chatRepository) {
        this.authRepository = authRepository;
        this.usersRepository = usersRepository;
        this.chatRepository = chatRepository;
    }

    public Long autho(auth auth){
        UUID token= UUID.randomUUID();
        auth.setToken(UUID,token);
        return authRepository.save(auth).getToken;
    }
    public auth save(auth auth){
        return AuthRepository.save(auth);
    }
    public auth getToken(UUID token){
        return authRepository.getToken(token);
    }
    public void authTime(auth auth, Users users){
        Users newUser = usersRepository.save(users);

        Long time = new Date().getTime();

        auth.setLast_login_timestamp(time);
        auth.setUser_id(newUser.getClass();
        save(auth);
    }

}
}
