package br.com.stapassoli.challageTask.service;

import br.com.stapassoli.challageTask.dto.IncidentCreateDTO;
import br.com.stapassoli.challageTask.dto.IncidentDTO;
import br.com.stapassoli.challageTask.dto.IncidentUpdateDTO;
import br.com.stapassoli.challageTask.entity.Incident;
import br.com.stapassoli.challageTask.repository.IncidentRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    private Incident findIncident(Long id) {
        Incident incident = incidentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("not possible to find indicent with the given id"));
        return incident;
    }

    public ResponseEntity<IncidentDTO> getIncident(Long id) {
        Incident incident = findIncident(id);

        IncidentDTO incidentDTO = new ModelMapper().map(incident, IncidentDTO.class);

        return ResponseEntity.ok(incidentDTO);
    }

    public Page<IncidentDTO> getAllIncidents(Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();

        List<IncidentDTO> incidents = this.incidentRepository.findAll().stream().map(incident -> modelMapper.map(incident, IncidentDTO.class))
            .toList();

        return new PageImpl<>(incidents, pageable, incidents.size());
    }

    public ResponseEntity<String> deleteById(Long id) {

        try {
            this.incidentRepository.deleteById(id);
        } catch (Exception exception) {
            throw new EntityNotFoundException("not possible to find incident ID not found");
        }

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<IncidentDTO> update(Long id, IncidentUpdateDTO incidentDTO) {
        Incident updatedIncident = this.incidentRepository.save(findIncident(id).update(incidentDTO));
        return ResponseEntity.ok(new ModelMapper().map(updatedIncident, IncidentDTO.class));
    }

    public ResponseEntity<IncidentDTO> create(IncidentCreateDTO incidentCreateDTO) {
        Incident incident = this.incidentRepository.save(new Incident(incidentCreateDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ModelMapper().map(incident, IncidentDTO.class));
    }
}
