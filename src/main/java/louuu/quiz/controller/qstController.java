package louuu.quiz.controller;



import louuu.quiz.models.qst;
import louuu.quiz.repos.qstRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qsts")
public class qstController {
    private final qstRepo qstRepository;

    public qstController(qstRepo qstRepository) {
        this.qstRepository = qstRepository;
    }

    @GetMapping
    public List<qst> getAllqsts() {
        return qstRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<qst> getqstById(@PathVariable String id) {
        return qstRepository.findById(id);
    }

    @PostMapping
    public qst createqst(@RequestBody qst qst) {
        return qstRepository.save(qst);
    }

    @PutMapping("/{id}")
    public qst updateqst(@PathVariable String id, @RequestBody qst updatedqst) {
        Optional<qst> existingqst = qstRepository.findById(id);
        if (existingqst.isPresent()) {
            qst qst = existingqst.get();
            qst.setQuestion(updatedqst.getQuestion());
            qst.setResponses(updatedqst.getResponses());
            return qstRepository.save(qst);
        } else {
            throw new IllegalArgumentException("qst not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteqst(@PathVariable String id) {
        qstRepository.deleteById(id);
    }
}
