package louuu.quiz;

import org.springframework.boot.CommandLineRunner;

import louuu.quiz.models.qst;
import louuu.quiz.models.rep;
import louuu.quiz.repos.qstRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner{
	private final qstRepo qstRepo;
	
	public QuizApplication(qstRepo qstRepo) {
        this.qstRepo = qstRepo;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(qstRepo.findAll().isEmpty()) {
			qstRepo.save(new qst("ssss", new rep[]{new rep("aaaa", false)}));


		}
	}
}
