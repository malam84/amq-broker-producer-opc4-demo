package com.amqp.client.ocp4.demo.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.amqp.client.ocp4.demo.pojo.Message;
import com.amqp.client.ocp4.demo.services.AMQProducerSvs;

@EnableJms
@Service
public class AMQProducerSvsImpl implements AMQProducerSvs{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMsg(Message msg) throws JmsException  {
		    this.jmsTemplate.convertAndSend("TEST", msg);
	}

	@Override
	public void sendMsg(String txt) throws JmsException{
		System.out.println(String.format("Sending '%s'", txt));
		this.jmsTemplate.convertAndSend("TEST", txt);
		
	}

}
