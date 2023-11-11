package br.com.stapassoli.challageTask.controller;

import br.com.stapassoli.challageTask.dto.IncidentCreateDTO;
import br.com.stapassoli.challageTask.dto.IncidentDTO;
import br.com.stapassoli.challageTask.dto.IncidentUpdateDTO;
import br.com.stapassoli.challageTask.service.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentsController {

    private final IncidentService incidentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<IncidentDTO> getIncidentById(@PathVariable(name = "id") Long id) {
        return incidentService.getIncident(id);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.FOUND)
    public Page<IncidentDTO> getAllIncidents(@PageableDefault(size = 20, sort = "createdAt", direction = Direction.DESC) Pageable pageable) {
        return incidentService.getAllIncidents(pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteByid(@PathVariable(name = "id") Long id) {
        return incidentService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IncidentDTO> update(@PathVariable(name = "id") Long id ,@RequestBody IncidentUpdateDTO incidentDTO) {
        return incidentService.update(id, incidentDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<IncidentDTO> create(@RequestBody IncidentCreateDTO incidentCreateDTO) {
        return incidentService.create(incidentCreateDTO);
    }

}
