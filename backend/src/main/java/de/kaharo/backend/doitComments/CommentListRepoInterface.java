package de.kaharo.backend.doitComments;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentListRepoInterface extends MongoRepository<CommentList, String> {
}
