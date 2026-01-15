package cn.ccc212.mall.pay.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//MyBatisPlus表映射注解
@TableName(value = "pay_log")
public class PayLog {

    // 日志id
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    // 支付状态
    private Integer status;
    // message内容
    private String content;
    // payid
    private String payId;
    // 创建时间
    private Date createTime;
}