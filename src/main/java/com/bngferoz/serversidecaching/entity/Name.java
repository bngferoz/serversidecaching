package com.bngferoz.serversidecaching.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("Name")
public class Name  implements Serializable{
	private int id;
	private String name;
}
