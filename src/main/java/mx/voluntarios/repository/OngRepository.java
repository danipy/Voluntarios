package mx.voluntarios.repository;

import java.util.List;

import mx.voluntarios.domain.Ong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OngRepository extends JpaRepository<Ong, Long> {

	Ong findOneByUsername(String username);

	@Query("SELECT o FROM Ong o JOIN o.volunteers v WHERE v.id = :ongId")
	List<Ong> findByVolunteer(@Param("ongId") Long ongId);

}
