package br.com.stapassoli.challageTask.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncidentDTO {

    private String name;

    private String description;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate closedAt;

}
