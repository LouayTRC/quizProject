package louuu.quiz.models;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "qsts")
public class qst {
    @Id
    private String id;
    private String question;
    private rep[] responses;

    public qst() {
    }

    public qst(String question, rep[] responses) {
        this.question = question;
        this.responses = responses;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public rep[] getResponses() {
        return responses;
    }

    public void setResponses(rep[] responses) {
        this.responses = responses;
    }
}
