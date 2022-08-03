package lecom.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="vendaitem")
public class ItemSale {
	@Id
	@Column(name="idvendaitem")
	private Long id;
	
	@Column(name="idvenda")
	private Long saleItem;
			
	@Column(name = "numitem")
	private int numItem;
	
	@Column(name = "idproduto")
	private long product;
	
	@Column(name = "qtde")
	private int quantity;
		
	private double subtotal;		 
}
