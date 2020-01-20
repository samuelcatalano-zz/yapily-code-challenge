package co.uk.yapily.samuel.catalano.controller;

import co.uk.yapily.samuel.catalano.dto.FactDTO;
import co.uk.yapily.samuel.catalano.exception.YapilyException;
import co.uk.yapily.samuel.catalano.json.StatusMessageJSON;
import co.uk.yapily.samuel.catalano.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Samuel Catalano
 */

@RestController
@RequestMapping(value = "")
public class FactController {

    @Autowired
    private FactService service;

    @GetMapping(value = "status", produces = "application/json")
    public ResponseEntity<StatusMessageJSON> status() throws YapilyException {
        final StatusMessageJSON response = this.service.getStatus();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "facts", produces = "application/json")
    public ResponseEntity<List<String>> facts() throws YapilyException {
        final List<String> ids = this.service.getFacts();
        return ResponseEntity.ok(ids);
    }

    @GetMapping(value = "facts/{factId}", produces = "application/json")
    public ResponseEntity<FactDTO> factsById(@PathVariable(value = "factId") final String id, @RequestParam(value = "lang", required = false) final String lang)
    throws YapilyException
    {
        final FactDTO dto = this.service.getFactsById(id, lang);
        return ResponseEntity.ok(dto);
    }
}