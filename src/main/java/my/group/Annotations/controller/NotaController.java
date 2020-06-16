package my.group.Annotations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.group.Annotations.documents.Nota;
import my.group.Annotations.service.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {
	
	@Autowired
	private NotaService notaService;
	
	@GetMapping
	public ResponseEntity<List<Nota>> findAll(){
		List<Nota> notas = notaService.listarTodos();
		if(notas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Nota>>(notas, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nota> findById(@PathVariable(name = "id") long id){
		Optional<Nota> nota = notaService.buscarPorId(id);
		if(nota.isPresent()) {
			return new ResponseEntity<Nota>(nota.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Nota> save(@RequestBody Nota nota){
		return new ResponseEntity<Nota>(notaService.salvar(nota), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Nota> update(@RequestBody Nota nota, @PathVariable(name = "id") long id){
		Optional<Nota> nota0 = notaService.buscarPorId(id);
		if(nota0.isPresent()) {
			nota.setId(nota0.get().getId());
			return new ResponseEntity<Nota>(notaService.salvar(nota), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Nota> delete(@PathVariable(name = "id") long id){
		Optional<Nota> nota = notaService.buscarPorId(id);
		if(nota.isPresent()) {
			notaService.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
