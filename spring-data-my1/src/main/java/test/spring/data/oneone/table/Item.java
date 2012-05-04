package test.spring.data.oneone.table;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Item implements Serializable {

	@Id @GeneratedValue
	private Long id;

	private String title;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="item")
	@JoinTable(
			name = "ITEM_SHIPMENT",
			joinColumns = @JoinColumn(name = "item_id"),
			inverseJoinColumns = @JoinColumn(name = "shipment_id")
	)
	Shipment shipment;

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
		shipment.setItem(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Shipment getShipment() {
		return shipment;
	}

}
