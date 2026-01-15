package cn.ccc212.mall.pay.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import cn.ccc212.mall.pay.model.PayLog;
import cn.ccc212.mall.pay.service.PayLogService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/wx")
@RequiredArgsConstructor
public class WeChatPayController {

    private final PayLogService payLogService;
    private final RocketMQTemplate rocketMQTemplate;

    // 记录支付结果
    // 执行事务消息发送
    @GetMapping("/result")
    public RespResult payLog(){
        //1.记录支付结果到日志
        PayLog payLog = new PayLog(IdWorker.getIdStr(),1 ,"支付成功" ,"AAA" ,new Date());

        // 构建事务消息
        Message<String> message = MessageBuilder.withPayload(JSON.toJSONString(payLog)).build();
        //2. 执行事务消息发送
        this.rocketMQTemplate.sendMessageInTransaction("rocket-pay-group", "pay-log", message, null);

        return RespResult.ok();
    }
}