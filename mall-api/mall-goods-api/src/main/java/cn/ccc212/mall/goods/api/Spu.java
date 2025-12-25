package cn.ccc212.mall.goods.api;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("spu")
public class Spu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * SPU名
     */
    private String name;

    /**
     * 简介
     */
    private String intro;

    /**
     * 品牌ID
     */
    private Integer brandId;

    /**
     * 一级分类
     */
    private Integer categoryOneId;

    /**
     * 二级分类
     */
    private Integer categoryTwoId;

    /**
     * 三级分类
     */
    private Integer categoryThreeId;

    /**
     * 图片列表
     */
    private String images;

    /**
     * 售后服务
     */
    private String afterSalesService;

    /**
     * 介绍
     */
    private String content;

    /**
     * 规格列表
     */
    private String attributeList;

    /**
     * 是否上架,0已下架，1已上架
     */
    private Integer isMarketable;

    /**
     * 是否删除,0:未删除，1：已删除
     */
    private Integer isDelete;

    /**
     * 审核状态，0：未审核，1：已审核，2：审核不通过
     */
    private Integer status;


}
