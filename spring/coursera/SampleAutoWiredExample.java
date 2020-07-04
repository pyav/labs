package spring.coursera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

class BeanClass {

}

@Controller
class VideoSvc {

	@Autowired
	public void auroWired(BeanClass beanClass) {

	}
}

@Configuration
class ConfigurationProvider {

	@Bean
	public BeanClass bean() {
		return new BeanClass();
	}

}

public class SampleAutoWiredExample {

	public static void main(String[] args) {

	}

}

