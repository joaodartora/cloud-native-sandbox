package com.joaodartora.totalizer.callers;

import com.joaodartora.totalizer.model.TwitterUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TwitterRequest {

	@Value("${TWITTER_URL}")
    private String twitterUrl;
	
	public TwitterUser getTwitterUser(String user) {
        	return new RestTemplate().getForObject(twitterUrl+user, TwitterUser.class);
	}
}
