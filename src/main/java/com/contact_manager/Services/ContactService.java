package com.contact_manager.Services;

import com.contact_manager.Entities.Contact;
import com.contact_manager.Entities.User;
import com.contact_manager.Repository.ContactRepository;
import com.contact_manager.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {


    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    public ContactService(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    public Contact addContact(Contact contact, Long userId) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found")));

        contact.setUser(user.get());

        return contactRepository.save(contact);
    }

    // Get all contacts for a user
    public List<Contact> getAllContacts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return contactRepository.findByUser(user);
    }

    // Get a specific contact for a user
    public Contact getContact(Long userId, Long contactId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return contactRepository.findByIdAndUser(contactId, user)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    // Update a contact for a user
    public Contact updateContact(Long userId, Long contactId, Contact updatedContact) {
        Contact contact = getContact(userId, contactId);  // Check if contact exists for the user
        contact.setName(updatedContact.getName());
        contact.setNumber(updatedContact.getNumber());
        contact.setWork(updatedContact.getWork());
        contact.setHome(updatedContact.getHome());
        contact.setBirthday(updatedContact.getBirthday());
        contact.setSociallink(updatedContact.getSociallink());
        contact.setRelationship(updatedContact.getRelationship());
        return contactRepository.save(contact);
    }


    // Delete a contact for a user
    public void deleteContact(Long userId, Long contactId) {
        Contact contact = getContact(userId, contactId);  // Check if contact exists for the user
        contactRepository.delete(contact);
    }

}
