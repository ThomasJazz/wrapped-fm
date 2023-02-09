package fm.wrapped.musicgator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.servlet.ServletContext;
import java.util.List;

@Import({
        org.springdoc.core.SpringDocConfigProperties.class,
        org.springdoc.core.SpringDocConfiguration.class,
        org.springdoc.webmvc.core.SpringDocWebMvcConfiguration.class,
        org.springdoc.webmvc.core.MultipleOpenApiSupportConfiguration.class,
        org.springdoc.core.SwaggerUiConfigProperties.class, org.springdoc.core.SwaggerUiOAuthProperties.class,
        org.springdoc.webmvc.ui.SwaggerConfig.class,
        org.springdoc.core.CacheOrGroupedOpenApiCondition.class,
        org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class })
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8081/music-gator/api/v1");
        return new OpenAPI().servers(List.of(server));
    }
}
