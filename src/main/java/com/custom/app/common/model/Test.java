/**
 * BokeMecn
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.custom.app.common.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author robin.tian
 * @version $Id: Test.java, v 0.1 2014年11月14日 上午9:23:42 robin.tian Exp $
 */
public class Test {

    public static void main(String[] args) throws IOException {

        //        try {
        //            String jmsProviderAddress = "tcp://localhost:61616";// 地址  
        //            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(jmsProviderAddress);// 连接器  
        //            Connection connection = connectionFactory.createConnection();// 创建连接  
        //            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);// 打开会话  
        //            Destination dest = session.createQueue("demoQueue");// 消息目的地  
        //            MessageProducer producer = session.createProducer(dest);// 消息发送者  
        //            Message message = session.createTextMessage("hello world");// 消息  
        //            producer.send(message);// 发送  
        //            producer.close();// 关闭  
        //            session.close();
        //            connection.close();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }

        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> mps = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> subMap = new HashMap<String, Object>();
            subMap.put("name", "张" + i);
            subMap.put("id", i);
            subMap.put("age", 10);
            subMap.put("address", "脏水发生地方" + i);
            mps.add(subMap);
        }
        map.put("status", 1);
        map.put("message", "success");
        map.put("data", mps);
        System.out.println(map);
    }
}
