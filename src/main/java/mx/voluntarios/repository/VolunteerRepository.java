package mx.voluntarios.repository;

import java.util.List;

import mx.voluntarios.domain.Volunteer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

	Volunteer findOneByUsername(String username);

	@Query("SELECT v FROM Volunteer v JOIN v.ongs o WHERE o.id = :ongId")
	List<Volunteer> findByOng(@Param("ongId") Long ongId);

	@Query("SELECT v FROM Volunteer v JOIN v.events e WHERE e.id = :eventId")
	List<Volunteer> findByEvent(@Param("eventId") Long eventId);

}
