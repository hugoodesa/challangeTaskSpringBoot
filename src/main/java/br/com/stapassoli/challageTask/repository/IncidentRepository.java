package br.com.stapassoli.challageTask.repository;

import br.com.stapassoli.challageTask.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {


}
