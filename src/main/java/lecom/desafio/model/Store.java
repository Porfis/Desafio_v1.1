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
@Table(name = "Loja")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idloja")
	private long id;	
		
	private String cnpj;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "endereco")
	private String address;
	
	@Column(name = "fone")
	private String phoneNumber;
}
