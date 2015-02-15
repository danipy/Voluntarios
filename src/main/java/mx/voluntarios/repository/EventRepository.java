package mx.voluntarios.repository;

import java.util.Date;

import mx.voluntarios.domain.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
	Page<Event> findByDateAfter(Date date, Pageable pageable);
}
