package com.scorpios.amqp;

import com.scorpios.amqp.bean.MyBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitAdmin rabbitAdmin;


    @Test
    public void createExchange() {

        //rabbitAdmin.declareExchange(new DirectExchange("RabbitAdmin.exchange"));
        //System.out.println("创建完成");

//        rabbitAdmin.declareQueue(new Queue("RabbitAdmin.queue",true));
//        System.out.println("创建完成");

        rabbitAdmin.declareBinding(new Binding("RabbitAdmin.queue", Binding.DestinationType.QUEUE, "RabbitAdmin.exchange", "RabbitAdmin.key", null));


    }


    @Test
    public void contextLoads() {

        Map<String, Object> map = new HashMap<>();
//
//        map.put("msg","the first message from springboot");
//        map.put("data","来自SpringBoot");

        rabbitTemplate.convertAndSend("exchange.direct", "scorpios", new MyBook("西游记", "吴承恩"));
//        rabbitTemplate.convertAndSend("exchange.direct","scorpios",map);
    }


    //接收数据，如何将数据自动的转为json发送出去
    @Test
    public void receive() {

        Object o = rabbitTemplate.receiveAndConvert("scorpios");

        System.out.println(o.getClass());

        System.out.println(o);

    }


    /**
     * 广播
     */

    @Test
    public void sendMessage() {

        rabbitTemplate.convertAndSend("exchange.fanout", "", new MyBook("红楼梦", "曹雪芹"));

    }

}

