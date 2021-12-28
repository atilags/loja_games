package com.semnome.lojajogos.entities.Enum;

public enum OrderStatus {
	
	WAINTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int codigo;
	
	private OrderStatus(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getCodigo() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
	}
	
}
