package com.tyw.redis;

/**
 * @author tboss
 */
public interface RedisService {
	/**
	 *
	 * @param key
	 * @param value
	 */
	void set(String key, Object value);

	/**
	 *
	 * @param key
	 * @param value
	 * @param seconds
	 */
	void set(String key, Object value, int seconds);

	/**
	 *
	 * @param key
	 */
	void del(String key);

	/**
	 *
	 * @param key
	 * @return
	 */
	Object get(String key);

}
