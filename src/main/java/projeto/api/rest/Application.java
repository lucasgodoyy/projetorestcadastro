package projeto.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"projeto.api.rest.model"}) // varre pacotes de modelo
@ComponentScan(basePackages = { "projeto.*" }) // varre todo o projeto - injeção de dependências
@EnableJpaRepositories(basePackages = { "projeto.api.rest.repository" }) // habilita persistência
@EnableTransactionManagement // controle transacional (gerência de transações)
@EnableWebMvc // habilita MVC
@RestController // habilita REST (retorno de JSON)
@EnableAutoConfiguration // configuração automática do projeto
@EnableCaching // Habilita o cache
public class Application extends SpringBootServletInitializer implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
		
	}
	
	/*mapeamento global que reflete todo sistema*/
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/usuario/**")
		.allowedMethods("*")
		.allowedOrigins("localhost:8080");
		/*liberando apenas requisições post para o usuário do servidor localhost:8080*/
		
	}
	
	
}
