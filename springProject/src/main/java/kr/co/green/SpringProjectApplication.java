package kr.co.green;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SpringProjectApplication.class);

	public static void main(String[] args) {
		LOGGER.info("스프링 프로젝트가 시작중입니다.");
		SpringApplication.run(SpringProjectApplication.class, args);
		LOGGER.info("스프링 프로젝트가 성공적으로 시작되었습니다.");
	}

}
