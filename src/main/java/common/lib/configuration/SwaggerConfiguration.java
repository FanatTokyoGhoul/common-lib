package common.lib.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfiguration {
    @Value("${keycloak.auth-server-url}")
    private String authServer;
    @Value("${keycloak.realm}")
    private String realm;

    @Bean
    public OpenAPI customOpenAPI() {
        OAuthFlows flows = new OAuthFlows();
        OAuthFlow flow = new OAuthFlow();

        flow.setAuthorizationUrl(authServer + "/realms/" + realm + "/protocol/openid-connect/auth");

        Scopes scopes = new Scopes();
        flow.setScopes(scopes);
        flows = flows.implicit(flow);

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("keycloak",
                        new SecurityScheme().type(SecurityScheme.Type.OAUTH2).flows(flows)))
                .addSecurityItem(new SecurityRequirement().addList("keycloak",
                        Arrays.asList("read", "write")));
    }
}
