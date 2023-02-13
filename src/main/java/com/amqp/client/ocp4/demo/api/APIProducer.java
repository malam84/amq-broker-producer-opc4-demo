package com.amqp.client.ocp4.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.JmsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amqp.client.ocp4.demo.pojo.Message;
import com.amqp.client.ocp4.demo.services.AMQProducerSvs;


@RestController
@RequestMapping("/api")
public class APIProducer {

	@Autowired
	private AMQProducerSvs aMQProducerSvs;
	
	@RequestMapping(value = "/producer/obj", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sendMsg(@RequestBody Message msg) {
		System.out.println("--------Name--------" +msg.getMsgName());
		System.out.println("-------Value---------" +msg.getValue());
		try {
	       	aMQProducerSvs.sendMsg(msg);
		} catch(JmsException e) {
			System.out.println("=======" +e.getStackTrace());
			return "404";
		}
		return "200";
	}
	
	@RequestMapping(value="/producer")
	public String sendMsg(@RequestParam("hello") String hello) {
		System.out.println("--------Simple Message--------" +hello);
		try {
			aMQProducerSvs.sendMsg(hello);
		} catch(JmsException e) {
			System.out.println("=======" +e.getStackTrace());
			return "404";
		}
		return "200";
	}
	
//	@RequestMapping(value="/producer")
//	public String method9(@RequestParam("text") String text){
//		System.out.println("--------Simple Message--------" +text);
//		aMQProducerSvs.sendMsg(text);
//		return "Ok";
//	}
	
	 @RequestMapping("/hello")
	 public String hello() {
		 try {
			 aMQProducerSvs.sendMsg("Hey, How are you?");
		 } catch(JmsException e) {
			    System.out.println("=======" +e.getStackTrace());
				return "404";
			}
			return "200";
	 }  

}
