package co.uk.yapily.samuel.catalano.service.base;

import co.uk.yapily.samuel.catalano.dto.base.BaseDTO;
import co.uk.yapily.samuel.catalano.exception.YapilyException;
import co.uk.yapily.samuel.catalano.json.StatusMessageJSON;

import java.util.List;

/**
 * @author Samuel Catalano
 */

public interface BaseService<D extends BaseDTO> {

    /**
     * Returns the list of unique ids from a thousand fetches to a random API.
     * @return the list of unique ids from a thousand fetches to a random API
     */
    StatusMessageJSON getStatus() throws YapilyException;

    /**
     * Returns all the fact id’s as a JSON array of strings.
     * @return all the fact id’s as a JSON array of strings
     */
    List<String> getFacts() throws YapilyException;

    /**
     * Returns a specific fact by id.
     * @param id the id to be returned
     * @param lang the language code if is available
     * @return a specific fact by id
     */
    D getFactsById(final String id, final String lang) throws YapilyException;
}