package med.voll.api.infrastructure.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Voll.Med API", description = "Este é um projeto Java com Spring Boot 3 que está sendo desenvolvido durante o curso \"Spring Boot 3: desenvolva uma API Rest em Java\" da Alura.",
                version = "v1",
                contact = @Contact(name = "Vinicius de Souza Avansini")
        ),
        servers = {
                @Server(url = "http://localhost:8080/")
        }
)
public class OpenApiConfig {
}
