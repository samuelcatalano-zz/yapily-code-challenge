package co.uk.yapily.samuel.catalano.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Samuel Catalano
 */

@Data
public class FactJSON implements Serializable {

    @JsonProperty("total")
    private int total;

    @JsonProperty("unique")
    private int unique;
}