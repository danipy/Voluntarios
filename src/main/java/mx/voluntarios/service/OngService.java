package mx.voluntarios.service;

import mx.voluntarios.domain.Ong;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OngService {
	
	Ong getOng(Long id);

	Page<Ong> getOngs(Pageable pageable);
}
