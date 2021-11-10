package common.lib.services;

import lombok.Getter;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakApiService {
    @Value("${keycloak.auth-server-url}")
    private String serverUrl;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${profiles.keycloak.admin.username}")
    private String usernameAdmin;
    @Value("${profiles.keycloak.admin.password}")
    private String passwordAdmin;
    @Value("${keycloak.credentials.secret}")
    private String secret;

    public Keycloak getKeycloakClientAdmin(){
        return getKeycloakClient(usernameAdmin, passwordAdmin);
    }

    public Keycloak getKeycloakClient(String username, String password){
        return getBuilderWithoutUserCredentials()
                .username(username)
                .password(password)
                .build();
    }

    private KeycloakBuilder getBuilderWithoutUserCredentials(){
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .grantType(OAuth2Constants.PASSWORD)
                .clientId(clientId)
                .clientSecret(secret);
    }

    public String getAccessToken(String username, String password){
        return getKeycloakClient(username, password).tokenManager().getAccessTokenString();
    }
}
