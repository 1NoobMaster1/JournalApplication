package net.engineeringdigest.journalApplication.service;

import net.engineeringdigest.journalApplication.entity.JournalEntry;
import net.engineeringdigest.journalApplication.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

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

    // saveEntry:
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    // getAll:
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    // findById:
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    // deleteById:
    public void deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

}
