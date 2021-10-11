package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequenceGen", sequenceName = "seqDepart", allocationSize = 1)
//@TableGenerator(name="DepTableGen",
//		table = "sequences",
//		pkColumnName="SEQ_NAME", // Specify the name of the column of the primary key
//		valueColumnName="SEQ_NUMBER", // Specify the name of the column that stores the last value generated
//		pkColumnValue="LICENSE_ID" // Specify the primary key column value that would be considered as a primary key generator
////		,allocationSize=1
//)
@Table(
//		name = "Orders"
)
public class Order1 extends BaseEntity
{
	public final static String[][] headers = {{"Id", "user_id", "Status", "Created", "Modified" },};

	//@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private long userId;

	ProdStatus status = ProdStatus.IN_STOCK;


	public Order1(ProdStatus status) {
		this.status = status;
	}



	@OneToMany(//mappedBy = "orderId"
			//fetch = FetchType.LAZY
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "order_id"
	)
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
	private List<OrderItems> orderItems;


//	@ManyToMany(//mappedBy = "orders"
//			//fetch = FetchType.LAZY
//	)
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
//	private List<Product> products;



	public String[] toStringsArray() {
		return new String[] {String.valueOf(id), String.valueOf(userId), String.valueOf(status),
				String.valueOf(created), String.valueOf(modified)};
	}


	@Override
	public String toString() {
		return "Order{"
				       + id +
				       ", user_id=" + userId +
				       ", status=" + status +
				       ", created=" + created +
				       ", modified=" + modified +
				       '}';
	}

}

