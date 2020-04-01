package com.tyw.es;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tboss
 * <p>
 * Description: 解决同时引用redis与es启动时报错
 * </p>
 * @date 2020/4/1
 * @see com.tyw.es
 */
@Configuration
public class ElasticSearchConfig {
	@PostConstruct
	void init() {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}
}
