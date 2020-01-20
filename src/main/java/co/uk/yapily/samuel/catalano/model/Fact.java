package co.uk.yapily.samuel.catalano.model;

import co.uk.yapily.samuel.catalano.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Samuel Catalano
 */

@Data
@EqualsAndHashCode
public class Fact extends BaseEntity {

    private String id;
    private String text;
    private String source;
    private String sourceUrl;
    private String language;
    private String permlink;

    private Fact() {
    }

    public Fact(final String id, final String text, final String source, final String sourceUrl, final String language, final String permlink) {
        this.id = id;
        this.text = text;
        this.source = source;
        this.sourceUrl = sourceUrl;
        this.language = language;
        this.permlink = permlink;
    }
}