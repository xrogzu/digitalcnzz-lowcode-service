package com.pig.easy.bpm.web.vo.request;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.math.*;
/**
 * <p>
 * 流程表
 * </p>
 *
 * @author pig
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProcessQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流程编码
     */
    private Long  processId;


    /**
     * 流程key
     */
    private String  processKey;


    /**
     * 流程名称
     */
    private String  processName;


    /**
     * 流程归属菜单编号
     */
    private Long  processMenuId;


    /**
     * 流程简称
     */
    private String  processAbbr;


    /**
     * 流程分类 1 正常
     */
    private Integer  processType;


    /**
     * 所属公司
     */
    private Long  companyId;


    /**
     * 公司编码
     */
    private String  companyCode;


    /**
     * 排序
     */
    private Integer  sort;


    /**
     * 租户编号
     */
    private String  tenantId;


    /**
     * 默认流程详细编号
     */
    private Long  processDetailId;


    /**
     * 流程状态: 1 未发布 2 已发布
     */
    private Integer  processStatus;


    /**
     * 流程备注
     */
    private String  remarks;


    /**
     * 状态 1 有效 0 失效
     */
    private Integer  validState;


    /**
     * 操作人工号
     */
    private Long  operatorId;


    /**
     * 操作人姓名
     */
    private String  operatorName;


    /**
     * 创建时间
     */
    private LocalDateTime  createTime;


    /**
     * 更新时间
     */
    private LocalDateTime  updateTime;



    /**
     *  当前页码
     */
    private Integer pageIndex;

    /**
     * 每页展示数量
     */
    private Integer pageSize;

}
