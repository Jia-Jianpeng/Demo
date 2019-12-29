package com.jjp.service.impl;

import org.springframework.stereotype.Service;

import com.jjp.model.User;
import com.jjp.service.HostHolder;
import com.jjp.utils.ConcurrentUtils;

@Service
public class HostHolderImpl implements HostHolder {
	
	@Override
	public User getUser() {
		return ConcurrentUtils.getHost();
	}

	@Override
	public void setUser(User user) {
		ConcurrentUtils.setHost(user);
	}

}
