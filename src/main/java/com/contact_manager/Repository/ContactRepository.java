package com.contact_manager.Repository;

import com.contact_manager.Entities.Contact;
import com.contact_manager.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByUser(User user);
    Optional<Contact> findByIdAndUser(long id, User user);
}
