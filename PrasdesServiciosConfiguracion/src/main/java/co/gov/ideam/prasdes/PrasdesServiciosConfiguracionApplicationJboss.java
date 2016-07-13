package co.gov.ideam.prasdes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//@Configuration
//@SpringBootApplication
//@EnableJpaRepositories("co.gov.ideam.prasdes.dataservices.entidades")
//@EntityScan("co.gov.ideam.prasdes.dataservices.entidades")
public class PrasdesServiciosConfiguracionApplicationJboss extends SpringBootServletInitializer 
{
// Descomentar codigo comentado para poder habilitar la instancia para jboss
//	public static void main(String[] args) {
//		SpringApplication.run(PrasdesServiciosConfiguracionApplicationJboss.class, args);
//	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrasdesServiciosConfiguracionApplicationJboss.class);
    }
}
