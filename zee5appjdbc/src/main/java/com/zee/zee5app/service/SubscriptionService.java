package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo;

public class SubscriptionService {
	
	private SubscriptionRepo repo = SubscriptionRepo.getInstance();
	
	private SubscriptionService() {
		
	}
	
	static SubscriptionService subserve = null;
	
	public static SubscriptionService getInstance() {
		if(subserve==null) {
			subserve = new SubscriptionService();
		}
		return subserve;
	}
	
	public String addSubscription(Subscription subscription) {
			return this.repo.addSubscribtion(subscription);
	}
	
	public Subscription getSubscriptionById(String id) {
		return this.repo.getSubscriptionById(id);
	}
	
	public Subscription[] getAllSubscriptions() {
		return this.repo.getAllSubscribtion();
	}
	
	public String deleteSubscription(String id) {
		return this.repo.deleteSubscription(id);
	}
	
	public String modifySubscription(String id, Subscription subscription) {
		return this.repo.modifySubscription(id, subscription);
	}
}
