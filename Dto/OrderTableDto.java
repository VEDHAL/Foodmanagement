package com.example.FoodDelivery.Dto;


	import java.util.List;

import com.example.FoodDelivery.model.OrderTable;
import com.example.FoodDelivery.model.UserTable;


	public class OrderTableDto {
		
		private int orderitemid;
		
		private UserTable user;
		
		private OrderTable order;
		
		private int quantity;

		public OrderTableDto() {
			super();
		}

		public OrderTableDto(int orderitemid, UserTable user, OrderTable order, int quantity) {
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

