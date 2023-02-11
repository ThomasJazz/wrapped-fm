package fm.wrapped.musicgator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAuthorization {
    @JsonProperty("client_id")
    public String clientId;

    @JsonProperty("response_type")
    public String responseType="code";

    @JsonProperty("redirect_uri")
    public String redirectUri="code";

    @JsonProperty("scope")
    public String scope="code";
}
