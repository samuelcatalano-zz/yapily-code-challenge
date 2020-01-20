package co.uk.yapily.samuel.catalano.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Samuel Catalano
 */

@Data
public class StatusMessageJSON implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("facts")
    private FactJSON factJson;

}
