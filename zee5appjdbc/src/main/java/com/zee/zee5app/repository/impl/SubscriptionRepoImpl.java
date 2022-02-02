package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepo2;

public class SubscriptionRepoImpl implements SubscriptionRepo2 {

	private List<Subscription> subscription_list = new ArrayList<>();
	
	private SubscriptionRepoImpl() {
		
	}
	
	private static SubscriptionRepo2 subscription;
	
	public static SubscriptionRepo2 getInstance() {
		
		if(subscription==null)
			subscription = new SubscriptionRepoImpl();
		return subscription;
	}
	
	
	
	@Override
	public String addSubscribtion(Subscription subscription) {

		return this.subscription_list.add(subscription)?"Success":"Fail";
	}

	@Override
	public List<Subscription> getAllSubscribtion() {

		return subscription_list;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {

		Subscription subscription2 = null;
		for(Subscription subscription:subscription_list) {
			if(subscription.getId().equals(id)) {
				subscription2 = subscription;
				break;
			}
		}
		return Optional.ofNullable(Optional.of(subscription2).orElseThrow(()-> new IdNotFoundException("id not found ")));
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		
		Optional<Subscription> optional = this.getSubscriptionById(id);
		
		if(optional.isPresent()) {
			boolean result = subscription_list.remove(optional.get());
			if(result) {
				return "Success";
			}else
				return "Fail";
		}
		else {
			throw new IdNotFoundException("id not found");
		}
		
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

}
