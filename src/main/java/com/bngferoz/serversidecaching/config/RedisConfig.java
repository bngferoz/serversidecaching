 package com.bngferoz.serversidecaching.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
		redisConfig.setHostName("192.168.3.37");
		redisConfig.setPort(6379);
		redisConfig.setUsername("default");
		redisConfig.setPassword("egp12345");
		return new JedisConnectionFactory(redisConfig);
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;
	}
}
