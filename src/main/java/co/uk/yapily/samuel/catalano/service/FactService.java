package co.uk.yapily.samuel.catalano.service;

import co.uk.yapily.samuel.catalano.dto.FactDTO;
import co.uk.yapily.samuel.catalano.exception.YapilyException;
import co.uk.yapily.samuel.catalano.json.FactJSON;
import co.uk.yapily.samuel.catalano.json.MessageTranslatedJSON;
import co.uk.yapily.samuel.catalano.json.StatusMessageJSON;
import co.uk.yapily.samuel.catalano.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Samuel Catalano
 */

@Service
public class FactService implements BaseService<FactDTO> {

    @Autowired
    private RestTemplate template;

    @Value("${base.url}")
    private String baseUrl;

    @Value("${yandex.base.url}")
    private String yandexBaseUrl;

    @Value("${default.fetches}")
    private int fetches;

    @Value("${yandex.api.key}")
    private String API_KEY;

    private HttpHeaders headers;

    public static final String JSON_EXTENSION = ".json";

    public static final String RANDOM_JSON = "random.json";

    /**
     * Returns the list of unique ids from a thousand fetches to a random API.
     * @return the list of unique ids from a thousand fetches to a random API
     */
    @Override
    public StatusMessageJSON getStatus() throws YapilyException {
        final Set<String> factIds = new HashSet<>();

        this.fetchRandomApi(factIds);

        final StatusMessageJSON message = new StatusMessageJSON();
        final FactJSON facts = new FactJSON();

        facts.setTotal(this.fetches);
        facts.setUnique(factIds.size());

        message.setStatus("COMPLETED");
        message.setFactJson(facts);

        return message;
    }

    /**
     * Returns all the fact id’s as a JSON array of strings.
     * @return all the fact id’s as a JSON array of strings
     */
    @Override
    public List<String> getFacts() throws YapilyException{
        final List<String> factIds = new ArrayList<>();
        this.fetchRandomApi(factIds);
        return factIds;
    }

    /**
     * Returns a specific fact by id.
     * @param id the id to be returned
     * @param lang the language code if is available
     * @return a specific fact by id
     */
    @Override
    public FactDTO getFactsById(final String id, final String lang) throws YapilyException {
        this.headers = this.getHttpHeaders();

        final HttpEntity<FactDTO> entity = new HttpEntity<>(this.headers);
        final ResponseEntity<FactDTO> responseEntity = this.getResponseEntity(entity, id, lang);

        return responseEntity.getBody();
    }

    /**
     * Fetche random facts from the Random Useless Facts API.
     * @param factIds the {@link Collection} type
     */
    private void fetchRandomApi(final Collection<String> factIds) {
        IntStream.range(0, this.fetches).parallel().forEach(i -> {
            this.headers = this.getHttpHeaders();

            final HttpEntity<FactDTO> entity = new HttpEntity<>(this.headers);
            final ResponseEntity<FactDTO> responseEntity = this.getResponseEntity(entity, null, null);

            final FactDTO response = responseEntity.getBody();
            factIds.add(response.getId());
        });
    }

    /**
     * Returns the ResponseEntity<E>.
     * @param entity the generic entity
     * @return the ResponseEntity<E>
     */
    private ResponseEntity<FactDTO> getResponseEntity(final HttpEntity<FactDTO> entity, final String id, final String lang) {
        if (id == null) {
            return this.template.exchange(this.baseUrl + RANDOM_JSON,
                    HttpMethod.GET,
                    entity,
                    FactDTO.class);
        } else {
            if (lang == null) {
                return this.template.exchange(this.baseUrl + id + JSON_EXTENSION,
                        HttpMethod.GET,
                        entity,
                        FactDTO.class);
            } else {
                final ResponseEntity<FactDTO> response = this.template.exchange(this.baseUrl + id + JSON_EXTENSION,
                        HttpMethod.GET,
                        entity,
                        FactDTO.class);

                final FactDTO factDTO = response.getBody();

                final ResponseEntity<MessageTranslatedJSON> responseEntity = this.template.exchange(
                        this.getTranslateUrl(factDTO.getText(),
                        factDTO.getLanguage(), lang),
                        HttpMethod.GET,
                        entity,
                        MessageTranslatedJSON.class);

                final String textTranslated = responseEntity.getBody().getText()[0];
                factDTO.setText(textTranslated);
                factDTO.setLanguage(lang);

                return ResponseEntity.ok(factDTO);
            }
        }
    }

    /**
     * Returns the translate url.
     * @param text the text to be translated
     * @param sourceLang the source language
     * @param targetLang the target language
     * @return the translate url
     */
    private String getTranslateUrl(final String text, final String sourceLang, final String targetLang) {
        return this.yandexBaseUrl + this.API_KEY + "&text=" + text + "&lang=" + sourceLang + "-" + targetLang;
    }

    /**
     * Defines the basic HttpHeaders.
     * @return the basic HttpHeaders
     */
    private HttpHeaders getHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", "application/json");

        return headers;
    }
}