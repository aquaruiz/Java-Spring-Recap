import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.service.SpeakerService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Appconfig.class);
		
//		SpeakerService service = new SpeakerServiceImpl();
		SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
		
		System.out.println(service.findAll().get(0).getFirstName());
	}
	
}
