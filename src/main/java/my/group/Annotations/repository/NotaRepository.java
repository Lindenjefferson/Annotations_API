package my.group.Annotations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import my.group.Annotations.documents.Nota;

public interface NotaRepository extends MongoRepository<Nota, String> {

}
