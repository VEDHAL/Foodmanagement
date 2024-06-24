package com.example.FoodDelivery.model;

	import java.util.List;

	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Entity;
	import jakarta.persistence.FetchType;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table (name="order_table")

	public class OrderTable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int orderitemid;
		
		@ManyToOne
	    @JoinColumn(name = "userid")
	    private UserTable user;
		
		@ManyToOne
	    @JoinColumn(name = "orderid")
	    private OrderTable order;
		
		private int quantity;

		public OrderTable() {
			super();
		}

		public OrderTable(int orderitemid, UserTable user, OrderTable order, int quantity) {
			super();
			this.orderitemid = orderitemid;
			this.user = user;
			this.order = order;
			this.quantity = quantity;
		}

		public int getOrderitemid() {
			return orderitemid;
		}

		public void setOrderitemid(int orderitemid) {
			this.orderitemid = orderitemid;
		}

		public UserTable getUser() {
			return user;
		}

		public void setUser(UserTable user) {
			this.user = user;
		}

		public OrderTable getOrder() {
			return order;
		}

		public void setOrder(OrderTable order) {
			this.order = order;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "OrderItemTable [orderitemid=" + orderitemid + ", user=" + user + ", order=" + order + ", quantity="
					+ quantity + "]";
		}
	    
	    
		
		

}
