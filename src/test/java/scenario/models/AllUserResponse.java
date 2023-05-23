package scenario.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllUserResponse {

    private List<User> data;

    public List<User> getData() {
        return data;
    }

}
