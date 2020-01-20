package co.uk.yapily.samuel.catalano.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Samuel Catalano
 */

@Data
public class MessageTranslatedJSON implements Serializable {

    @JsonProperty("code")
    private int code;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("text")
    private String[] text;
}