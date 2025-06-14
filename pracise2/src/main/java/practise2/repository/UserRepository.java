package practise2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import practise2.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);

}
