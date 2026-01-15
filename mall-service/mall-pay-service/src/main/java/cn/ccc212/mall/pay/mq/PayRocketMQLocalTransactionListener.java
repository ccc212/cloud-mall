package cn.ccc212.mall.pay.mq;

import cn.ccc212.mall.pay.model.PayLog;
import cn.ccc212.mall.pay.service.PayLogService;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RocketMQTransactionListener(txProducerGroup = "rocket-pay-group")
public class PayRocketMQLocalTransactionListener implements RocketMQLocalTransactionListener{
    
    @Autowired
    private PayLogService payLogService;
    
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        try {
            String msg = new String ((byte[])message.getPayload(), "utf-8");
            PayLog payLog = JSON.parseObject(msg, PayLog.class);
            payLogService.add(payLog);
        } catch (Exception e) {
            e.printStackTrace();
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        return RocketMQLocalTransactionState.COMMIT;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        try {
            String msg = new String ((byte[])message.getPayload(), "utf-8");
            PayLog payLog = JSON.parseObject(msg, PayLog.class);
            PayLog payLog1 = payLogService.getById(payLog.getId());
            if (payLog1 != null) {
                return RocketMQLocalTransactionState.COMMIT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
