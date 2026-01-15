package cn.ccc212.mall.pay.service.Impl;

import cn.ccc212.mall.pay.model.PayLog;
import cn.ccc212.mall.pay.mapper.PayLogMapper;
import cn.ccc212.mall.pay.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {
    // 本地事务
    @Override
    @Transactional
    public void add(PayLog payLog) {
        this.baseMapper.insert(payLog);
    }
}
