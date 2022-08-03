package lecom.desafio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lecom.desafio.serializable.SaleId;
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
@Table(name="Venda")
public class Sale {
	@Id
	@Column(name = "idvenda") 
	private long id;
	
	@Column(name = "enderecoentrega")
	private String deliveryAddress;
		
	@OneToMany(mappedBy="saleItem", cascade = CascadeType.ALL)
	private List<ItemSale> itemSale;	
}