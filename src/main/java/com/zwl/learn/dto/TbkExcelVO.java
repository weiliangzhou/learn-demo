package com.zwl.learn.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
//@ApiModel("淘宝客导出")
public class TbkExcelVO {

    //@Excel(name = "序号", width = 18.0)
    private Integer num;

    //@Excel(name = "创建时间", width = 18.0, exportFormat = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime tkCreateTime;

    //@Excel(name = "付款时间", width = 18.0, exportFormat = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime tkPaidTime;

    //@Excel(name = "结算时间", width = 18.0, exportFormat = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime tkEarningTime;

    //@Excel(name = "商品标题", width = 18.0)
    private String itemTitle;

    //@Excel(name = "掌柜旺旺", width = 18.0)
    private String sellerNick;

    //@Excel(name = "店铺名称", width = 18.0)
    private String sellerShopTitle;

    //@Excel(name = "商品ID", width = 18.0)
    private String itemId;

    //@Excel(name = "商品数量", width = 18.0)
    private String itemNum;

    //@Excel(name = "商品单价", width = 18.0)
    private String itemPrice;

    //@Excel(name = "付款金额", width = 18.0)
    private String alipayTotalPrice;

    //@Excel(name = "类目名称", width = 18.0)
    private String itemCategoryName;

    //@Excel(name = "淘宝订单编号", width = 18.0)
    private String tradeParentId;

    //@Excel(name = "淘宝子订单号", width = 18.0)
    private String tradeId;

    //@Excel(name = "订单状态", width = 18.0)
    private String tkStatus;

    //@Excel(name = "订单类型", width = 18.0)
    private String orderType;

    //@Excel(name = "结算金额", width = 18.0)
    private String payPrice;

    //@Excel(name = "佣金比率", width = 18.0)
    private String totalCommissionRate;

    //@Excel(name = "佣金金额", width = 18.0)
    private String totalCommissionFee;

    //@Excel(name = "补贴比率", width = 18.0)
    private String subsidyRate;

    //@Excel(name = "补贴金额", width = 18.0)
    private String subsidyFee;

    //@Excel(name = "收入比率", width = 18.0)
    private String incomeRate;

    //@Excel(name = "提成", width = 18.0)
    private String tkTotalRate;

    //@Excel(name = "技术服务费率", width = 18.0)
    private String alimamaRate;

    //@Excel(name = "技术服务费", width = 18.0)
    private String alimamaShareFee;

    //@Excel(name = "付款预估收入", width = 18.0)
    private String pubSharePreFee;

    //@Excel(name = "结算预估收入", width = 18.0)
    private String pubShareFee;

    //@Excel(name = "产品类型", width = 18.0)
    private String flowSource;

    //@Excel(name = "推广者身份", width = 18.0)
    private String tkOrderRole;

    //@Excel(name = "媒体名称", width = 18.0)
    private String siteName;

    //@Excel(name = "推广位名称", width = 18.0)
    private String adzoneName;

    //@Excel(name = "维权标签", width = 18.0)
    private String refundTag;

    //@Excel(name = "专项服务费率", width = 18.0)
    private String tkCommissionRateForMediaPlatform;

    //@Excel(name = "预估专项服务费", width = 18.0)
    private String tkCommissionPreFeeForMediaPlatform;

    //@Excel(name = "结算专项服务费", width = 18.0)
    private String tkCommissionFeeForMediaPlatform;

    //@Excel(name = "定金付款时间", width = 18.0, exportFormat = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime tkDepositTime;

    //@Excel(name = "定金淘宝付款时间", width = 18.0, exportFormat = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime tbDepositTime;

    //@Excel(name = "定金付款金额", width = 18.0)
    private String depositPrice;


}
