package com.contact_manager.Controllers;

import com.contact_manager.Entities.Contact;
import com.contact_manager.Services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users/{userId}/contact")
public class ContactController {


    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Add a contact
    @PostMapping
    public ResponseEntity<Contact> addContact(@PathVariable Long userId, @RequestBody Contact contact) {
        Contact createdContact = contactService.addContact(contact, userId);
        return ResponseEntity.ok(createdContact);
    }

    // Get all contacts for a user
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(@PathVariable Long userId) {
        List<Contact> contacts = contactService.getAllContacts(userId);
        return ResponseEntity.ok(contacts);
    }

    // Get a specific contact for a user
    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContact(@PathVariable Long userId, @PathVariable Long contactId) {
        Contact contact = contactService.getContact(userId, contactId);
        return ResponseEntity.ok(contact);
    }

    // Update a contact
    @PutMapping("/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long userId, @PathVariable Long contactId, @RequestBody Contact updatedContact) {
        Contact contact = contactService.updateContact(userId, contactId, updatedContact);
        return ResponseEntity.ok(contact);
    }

    // Delete a contact
    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable Long userId, @PathVariable Long contactId) {
        contactService.deleteContact(userId, contactId);
        return ResponseEntity.ok("Contact deleted successfully");
    }


}
