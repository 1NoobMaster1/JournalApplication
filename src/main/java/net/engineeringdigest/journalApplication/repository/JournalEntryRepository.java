package net.engineeringdigest.journalApplication.repository;

import net.engineeringdigest.journalApplication.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
}
