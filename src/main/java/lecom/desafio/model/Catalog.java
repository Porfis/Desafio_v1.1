package lecom.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "Produto")
public class Catalog {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idproduto") 
	private long id;
	
	@Column(name = "Categoria")
	private String Category;
	
	@Column(name = "Nome")
	private String Name;
	
	@Column(name = "Valor")
	private Double Value;	
}
