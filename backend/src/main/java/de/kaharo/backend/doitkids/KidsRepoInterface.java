package de.kaharo.backend.doitkids;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidsRepoInterface extends MongoRepository<Kids, String> {
}
