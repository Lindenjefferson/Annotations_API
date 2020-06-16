package my.group.Annotations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.group.Annotations.documents.Nota;
import my.group.Annotations.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	public List<Nota> listarTodos() {
		return notaRepository.findAll();
	}
	
	public Optional<Nota> buscarPorId(long id) {
		return notaRepository.findById(id);
	}
	
	public Nota salvar(Nota nota) {
		return notaRepository.save(nota);
	}
	
	public void deletar(long id) {
		notaRepository.deleteById(id);
	}
	
}
