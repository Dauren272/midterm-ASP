package kz.aitu.chat.repository;

import kz.aitu.chat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {


}
