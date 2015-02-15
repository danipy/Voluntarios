package mx.voluntarios.repository;

import mx.voluntarios.domain.Volunteer;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
