package mx.voluntarios.service;

import mx.voluntarios.domain.Ong;
import mx.voluntarios.repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("ongService")
public class OngProvider implements OngService {

	@Autowired
	OngRepository ongRepository;

	@Override
	@Transactional(readOnly = true)
	public Ong getOng(Long id) {
		return ongRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Ong> getOngs(Pageable pageable) {
		return ongRepository.findAll(pageable);
	}

}
