package com.bngferoz.serversidecaching.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("Name")
public class Name  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4069745594390823671L;
	private int id;
	private String name;
}
