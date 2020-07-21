package my.group.Annotations.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import my.group.Annotations.documents.Nota;

public interface NotaRepository extends MongoRepository<Nota, String> {
    
    List<Nota> findByTituloContainingIgnoreCase(String titulo);

}
