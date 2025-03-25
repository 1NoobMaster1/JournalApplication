package net.engineeringdigest.journalApplication.service;

import net.engineeringdigest.journalApplication.entity.JournalEntry;
import net.engineeringdigest.journalApplication.entity.User;
import net.engineeringdigest.journalApplication.repository.JournalEntryRepository;
import net.engineeringdigest.journalApplication.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    // findAll:
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // findById:
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    // saveData:
    public void saveData(User user) {
        userRepository.save(user);
    }

    // findByUserName:
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
