package mx.voluntarios.repository;

import mx.voluntarios.domain.Ong;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {

}
