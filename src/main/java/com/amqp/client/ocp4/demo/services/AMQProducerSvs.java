package com.amqp.client.ocp4.demo.services;

import org.springframework.jms.JmsException;

import com.amqp.client.ocp4.demo.pojo.Message;

public interface AMQProducerSvs {

	public void sendMsg(Message msg) throws JmsException;
	public void sendMsg(String msg) throws JmsException;
}
