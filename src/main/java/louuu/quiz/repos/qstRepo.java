package louuu.quiz.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import louuu.quiz.models.qst;

public interface qstRepo extends MongoRepository<qst, String> {

}
