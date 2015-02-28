package mx.voluntarios.repository;

import java.util.Date;
import java.util.List;

import mx.voluntarios.domain.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	Page<Event> findByDateAfter(Date date, Pageable pageable);
	
	List<Event> findByOngId(Long id);

	@Query("SELECT e FROM Event e JOIN e.volunteers v WHERE v.id = :eventId")
	List<Event> findByVolunteer(@Param("eventId") Long eventId);

}
