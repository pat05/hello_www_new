package it.ecole.hello.www.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository
        extends JpaRepository<
        User, /* @Entity public class Contact { ... */
        Integer  /* @Id @GeneratedValue private Integer id; ... */
        >
{

    public User findByEmailAndPassword(String email, String password);

}
