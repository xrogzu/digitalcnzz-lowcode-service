package com.pig.easy.bpm.auth.dto.request;

import com.pig.easy.bpm.common.generator.dto.request.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
    * 公司表
    * </p>
 *
 * @author pig
 * @since 2021-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CompanyQueryDTO extends BaseRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司编码
     */
    private Long  companyId;


    /**
     * 部门编码
     */
    private String  companyCode;


    /**
     * 上级公司编号
     */
    private Long  companyParentId;


    /**
     * 上级公司编码
     */
    private String  companyParentCode;


    /**
     * 公司名称
     */
    private String  companyName;


    /**
     * 公司简称
     */
    private String  companyAbbr;


    /**
     * 公司承继
     */
    private Integer  companyLevel;


    /**
     * 排序
     */
    private Integer  companyOrder;


    /**
     * 公司展示图标
     */
    private String  companyIcon;


    /**
     * 公司展示url
     */
    private String  companyUrl;


    /**
     * 租户编号
     */
    private String  tenantId;


    /**
     * 1 正常开业  2 拟筹 2 已关停
     */
    private Integer  companyStatus;


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
