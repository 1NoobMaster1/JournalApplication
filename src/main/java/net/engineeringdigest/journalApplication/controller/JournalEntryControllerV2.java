package net.engineeringdigest.journalApplication.controller;

import net.engineeringdigest.journalApplication.entity.JournalEntry;
import net.engineeringdigest.journalApplication.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.findById(myId).orElse(null);
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry oldEntry = journalEntryService.findById(id).orElse(null);
        if(oldEntry != null) {
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : oldEntry.getContent());

        }
        journalEntryService.saveEntry(oldEntry);
        return oldEntry;
    }

}
