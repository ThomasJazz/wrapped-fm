package fm.wrapped.aggregator.payload.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAuthorization {
    @JsonProperty("client_id")
    public String clientId;
}
