package com.amqp.client.ocp4.demo.pojo;

import java.io.Serializable;

public class Message implements Serializable {
	
	private String msgName;
	private String value;
	
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
