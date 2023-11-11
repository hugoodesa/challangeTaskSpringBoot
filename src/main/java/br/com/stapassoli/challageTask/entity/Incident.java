package br.com.stapassoli.challageTask.entity;

import br.com.stapassoli.challageTask.dto.IncidentCreateDTO;
import br.com.stapassoli.challageTask.dto.IncidentDTO;
import br.com.stapassoli.challageTask.dto.IncidentUpdateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIncident;

    @NotBlank(message = "name its a required field")
    private String name;

    @NotBlank(message = "description its a required field")
    private String description;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate closedAt;

    public Incident(IncidentCreateDTO incidentCreateDTO) {
        this.name = incidentCreateDTO.getName();
        this.description = incidentCreateDTO.getDescription();
        this.createdAt = LocalDate.now();
        this.updatedAt = null;
        this.closedAt = null;
    }

    public Incident update(IncidentUpdateDTO incidentDTO) {
        this.description = incidentDTO.getDescription();
        this.name = incidentDTO.getName();
        this.updatedAt = LocalDate.now();
        this.closedAt = LocalDate.now();

        return this;
    }

}
