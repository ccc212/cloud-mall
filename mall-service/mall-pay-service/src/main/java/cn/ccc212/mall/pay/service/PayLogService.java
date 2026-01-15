package cn.ccc212.mall.pay.service;

import cn.ccc212.mall.pay.model.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

public interface PayLogService extends IService<PayLog> {
    void add(PayLog payLog);

}
