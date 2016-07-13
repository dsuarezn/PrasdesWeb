package co.gov.ideam.prasdes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories("co.gov.ideam.prasdes.dataservices.entidades")
@EntityScan("co.gov.ideam.prasdes.dataservices.entidades")
public class PrasdesServiciosDeDatosApplicationJboss extends SpringBootServletInitializer 
{

// Descomentar codigo comentado para poder habilitar la instancia para jboss			
//	public static void main(String[] args) {
//		SpringApplication.run(PrasdesServiciosDeDatosApplicationJboss.class, args);
//	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrasdesServiciosDeDatosApplicationJboss.class);
    }
}
