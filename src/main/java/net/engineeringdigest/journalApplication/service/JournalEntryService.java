package net.engineeringdigest.journalApplication.service;

import net.engineeringdigest.journalApplication.entity.JournalEntry;
import net.engineeringdigest.journalApplication.entity.User;
import net.engineeringdigest.journalApplication.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class  JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    // Generate Employee:
    // Employee generateEmployee(Employee employee);

    // Take Single Employee By Id:
    // Employee takeSingleEmployeeById(String employeeId);

    // Take Overall Employee:
    // List<Employee> takeOverallEmployee();

    // Override Employee:
    // Employee overrideEmployee(String employeeId, Employee employee);

    // Remove Employee:
    // void removeEmployeeById(String employeeId);

    // deleteById:
    public void deleteById(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveData(user);
        journalEntryRepository.deleteById(id);
    }

    // findAll:
    public List<JournalEntry> findAll() {
        return journalEntryRepository.findAll();
    }

    // findById:
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    // saveData:
    public void saveData(JournalEntry journalEntry, String userName) {
        User user = userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved =  journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveData(user);
    }

    public void saveData(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

}
