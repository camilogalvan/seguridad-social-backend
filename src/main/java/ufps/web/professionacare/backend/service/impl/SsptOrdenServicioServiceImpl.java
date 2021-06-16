package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptOrdenServicio;
import ufps.web.professionacare.backend.repository.SsptOrdenServicioRepository;
import ufps.web.professionacare.backend.service.SsptOrdenServicioService;

@Service
@Transactional
public class SsptOrdenServicioServiceImpl implements SsptOrdenServicioService {

	@Autowired
	private SsptOrdenServicioRepository s;

	@Override
	public SsptOrdenServicio getById(int id) {

		return s.findById(id).orElse(null);
	}

	@Override
	public SsptOrdenServicio getByCliente(SsptCliente cliente) {
		return s.findLastByCliente(cliente);
	}

	@Override
	public List<SsptOrdenServicio> getAll() {

		return (List<SsptOrdenServicio>) s.findAll();
	}

	@Override
	public SsptOrdenServicio save(SsptOrdenServicio entrada) {

		return s.save(entrada);
	}

}
