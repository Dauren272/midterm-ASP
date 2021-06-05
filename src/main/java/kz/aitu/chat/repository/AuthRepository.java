package kz.aitu.chat.repository;

import kz.aitu.chat.model.auth;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<auth, String> {
    default auth getToken(UUID token) {

        return getToken(token);
    }



}





