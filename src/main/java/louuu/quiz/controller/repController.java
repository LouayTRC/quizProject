package louuu.quiz.controller;


import org.springframework.web.bind.annotation.*;

import louuu.quiz.models.rep;
import louuu.quiz.repos.repRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responses")
public class repController {
	private final repRepo repRepo;
	
	
    public repController(repRepo responseRepository) {
        this.repRepo = responseRepository;
    }

    @GetMapping("/")
    public List<rep> getAllResponses() {
        return repRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<rep> getResponseById(@PathVariable String id) {
        return repRepo.findById(id);
    }

    @PostMapping("/")
    public rep createResponse(@RequestBody rep response) {
        return repRepo.save(response);
    }

    @PutMapping("/{id}")
    public rep updateResponse(@PathVariable String id, @RequestBody rep updatedResponse) {
        Optional<rep> existingResponse = repRepo.findById(id);
        if (existingResponse.isPresent()) {
            rep response = existingResponse.get();
            response.setResponse(updatedResponse.getResponse());
            response.setValidity(updatedResponse.isValidity());
            return repRepo.save(response);
        } else {
            throw new IllegalArgumentException("Response not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteResponse(@PathVariable String id) {
    	repRepo.deleteById(id);
    }
}
