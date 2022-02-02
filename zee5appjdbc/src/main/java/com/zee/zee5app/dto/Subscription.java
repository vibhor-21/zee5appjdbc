package com.zee.zee5app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Subscription {
	
	public Subscription(String type, String date_Of_Purchace, boolean status, String pack_Country, 
			String payment_Mode, boolean autoRenewal, String expiry_Date, String id) {
		super();
		this.setType(type);
		this.setDate_Of_Purchase(date_Of_Purchace);
		this.setStatus(status);
		this.setPack_Country(pack_Country);
		this.setPayment_Mode(payment_Mode);
		this.setAutoRenewal(autoRenewal);
		this.setExpiry_Date(expiry_Date);
		this.setId(id);
	}
	private String type;
	private String date_Of_Purchase;
	private boolean status;
	private String pack_Country;
	private String payment_Mode;
	private boolean autoRenewal;
	private String expiry_Date;
	private String id;
}
