package com.ciecc.fire.download.config;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.ciecc.fire.download.redis.Receiver;

@Configuration
public class RedisConfig {

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	/*
	 * @Bean Receiver receiver(CountDownLatch latch) { return new
	 * Receiver(latch); }
	 */

	@Bean
	Receiver receiver() {
		return new Receiver();
	}

	@Bean
	CountDownLatch latch() {
		return new CountDownLatch(1);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
	
	@Bean
	  public RedisTemplate<byte[], byte[]> byteTemplate(RedisConnectionFactory connectionFactory) {

	    RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
	    template.setConnectionFactory(connectionFactory);
	    return template;
	  }
	
}
