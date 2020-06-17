package my.group.Annotations.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Nota {
	
	@Id
	private String id;
	private String titulo;
	private String conteudo;
	private String marcador;
	
}
