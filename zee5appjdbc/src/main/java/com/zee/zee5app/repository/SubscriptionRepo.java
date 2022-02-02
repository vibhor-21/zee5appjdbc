package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public class SubscriptionRepo {
	
	private Subscription[] subscriptions = new Subscription[10];
	private static int count=-1;
	private SubscriptionRepo() {
		
	}
	
	public String addSubscribtion(Subscription subscription) {
		if(count==subscriptions.length-1) {
			Subscription[] temp = new Subscription[2*subscriptions.length];
			System.arraycopy(subscriptions,0,temp,0,subscriptions.length);
			subscriptions = temp;
			subscriptions[++count] = subscription;
			return "success";
		}
		subscriptions[++count] = subscription;
		return "success";
	}
	
	public Subscription[] getAllSubscribtion() {
		return subscriptions;
	}
	
	public Subscription getSubscriptionById(String id) {
		for(Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id)) {
				return subscription;
			}
		}
		return null;
	}
	
	public String deleteSubscription(String id) {
		boolean flag = false;
		for(int i=0;i<subscriptions.length;i++) {
			if(subscriptions[i].getId().equals(id)) {
				while(i<subscriptions.length-1) {
					subscriptions[i] = subscriptions[i+1];
					i++;
				}
				flag=true;
			}
		}
		return flag?"Successfully deleted":"Not Matched";
	}
	
	public String modifySubscription(String id, Subscription subscription) {
		
		boolean flag = false;
		for(int i=0;i<subscriptions.length;i++) {
			if(subscriptions[i].getId().equals(id)) {
				subscriptions[i] = subscription;
				flag = true;
				break;
			}
		}
		return flag?"Updated":"Cannot update";
	}
	
	private static SubscriptionRepo subscriptionRepo;
	
	public static SubscriptionRepo getInstance() {
		if(subscriptionRepo==null) {
			subscriptionRepo = new SubscriptionRepo();
		}
		return subscriptionRepo;
	}
}
