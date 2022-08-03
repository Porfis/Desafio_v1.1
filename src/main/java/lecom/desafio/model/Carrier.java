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
//@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name="Entrega")
public class Carrier {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identrega")	
	private long id;
	
	@Column(name = "idvenda")
	private long idVenda;
	
	@Column(name = "enderecoloja")
	private String senderAddress;
	
	@Column(name = "enderecodestinatario")
	private String deliveryAddress;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigorastreio")
	private int rasterCode;
	private String status;
	
	public Carrier() {
		this.status = "Aprovação do pagamento"; 		
	}
}
