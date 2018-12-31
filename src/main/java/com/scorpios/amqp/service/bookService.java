package com.scorpios.amqp.service;

import com.scorpios.amqp.bean.MyBook;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Think
 * @Title: bookService
 * @ProjectName springboot-data-amqp
 * @Description: TODO
 * @date 2018/12/1420:57
 */

@Service
public class bookService {

    @RabbitListener(queues = "scorpios")
    public void receiveMessage(MyBook myBook) {

        System.out.println("收到消息为：" + myBook);

    }

}
