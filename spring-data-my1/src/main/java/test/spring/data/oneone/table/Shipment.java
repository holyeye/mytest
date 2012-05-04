package test.spring.data.oneone.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Shipment {

	@Id @GeneratedValue
	private Long id;

	@OneToOne
	@JoinTable(
			name = "ITEM_SHIPMENT",
			joinColumns = @JoinColumn(name = "shipment_id"),
			inverseJoinColumns = @JoinColumn(name = "item_id")
	)
	private Item item;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	public Item getItem() {
		return item;
	}

}
