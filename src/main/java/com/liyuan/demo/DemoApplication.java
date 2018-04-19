package com.liyuan.demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class DemoApplication {

	//定义一个Redis模板
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory factory){
		// 创建一个模板类
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		// 将刚才的redis连接工厂设置到模板类中
		template.setConnectionFactory(factory);
		// 设置key的序列化器
		template.setKeySerializer(new StringRedisSerializer());
		// 设置value的序列化器
		//使用Jackson 2，将对象序列化为JSON
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		//json转对象类，不设置默认的会将json转成hashmap
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
