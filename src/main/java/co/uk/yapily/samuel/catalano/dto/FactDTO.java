package co.uk.yapily.samuel.catalano.dto;

import co.uk.yapily.samuel.catalano.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Samuel Catalano
 */

@Data
public class FactDTO extends BaseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private String text;

    @JsonProperty("source")
    private String source;

    @JsonProperty("source_url")
    private String sourceUrl;

    @JsonProperty("language")
    private String language;

    @JsonProperty("permalink")
    private String permlink;

}