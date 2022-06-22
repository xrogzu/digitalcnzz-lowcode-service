package com.pig.easy.bpm.web.vo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
 * 字典详细表
 * </p>
 *
 * @author pig
 * @since 2021-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictItemQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long  itemId;


    /**
     * 字典编号
     */
    private Long  dictId;


    /**
     * 字典项值
     */
    private String  itemValue;


    /**
     * 字典项文本
     */
    private String  itemText;


    /**
     * 父级编号
     */
    private Long  parentId;


    /**
     * 租户编号
     */
    private String  tenantId;


    /**
     * 排序
     */
    private Integer  sort;


    /**
     * 备注
     */
    private String  remark;


    /**
     * 有效状态；0表示无效，1表示有效
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
     * 更新时间
     */
    private LocalDateTime  updateTime;


    /**
     * 创建时间
     */
    private LocalDateTime  createTime;



    /**
     *  当前页码
     */
    private Integer pageIndex;

    /**
     * 每页展示数量
     */
    private Integer pageSize;

}
