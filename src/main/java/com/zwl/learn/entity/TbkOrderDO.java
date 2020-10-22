package com.zwl.learn.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @Description 淘宝客数据
 * @Author zmj
 * @Date 2020-04-07 14:45
 */
@Document(collection = "tbk_order")
@Data
@CompoundIndexes({
        @CompoundIndex(name = "idx_strId_tkEarningTime", def = "{'streamer_id':1, 'tk_earning_time':-1}")
})
public class TbkOrderDO {

    @Field("user_id")
    private Long userId;

    @Field("streamer_id")
    private Long streamerId;

    @Field("org_id")
    private Long orgId;

    @Field("tb_paid_time")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime tbPaidTime;

    @Field("tk_paid_time")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime tkPaidTime;

    @Field("pay_price")
    private Double payPrice;

    @Field("pub_share_fee")
    private Double pubShareFee;

    @Field("trade_id")
    @Indexed(unique = true)
    private String tradeId;

    @Field("tk_order_role")
    private Integer tkOrderRole;

    @Field("tk_earning_time")
    @Indexed(direction = IndexDirection.DESCENDING)
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime tkEarningTime;

    @Field("adzone_id")
    private Long adzoneId;

    @Field("pub_share_rate")
    private Double pubShareRate;

    @Field("unid")
    private String unid;

    @Field("refund_tag")
    private Integer refundTag;

    @Field("subsidy_rate")
    private Double subsidyRate;

    @Field("tk_total_rate")
    private Double tkTotalRate;

    @Field("item_category_name")
    private String itemCategoryName;

    @Field("seller_nick")
    private String sellerNick;

    @Field("pub_id")
    private Long pubId;

    @Field("alimama_rate")
    private Double alimamaRate;

    @Field("subsidy_type")
    private String subsidyType;

    @Field("item_img")
    private String itemImg;

    @Field("pub_share_pre_fee")
    private Double pubSharePreFee;

    @Field("alipay_total_price")
    private Double alipayTotalPrice;

    @Field("item_title")
    private String itemTitle;

    @Field("site_name")
    private String siteName;

    @Field("item_num")
    private Long itemNum;

    @Field("subsidy_fee")
    private Double subsidyFee;

    @Field("alimama_share_fee")
    private Double alimamaShareFee;

    @Field("trade_parent_id")
    private String tradeParentId;

    @Field("order_type")
    private String orderType;

    @Field("tk_create_time")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime tkCreateTime;

    @Field("flow_source")
    private String flowSource;

    @Field("terminal_type")
    private String terminalType;

    @Field("click_time")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime clickTime;

    @Field("tk_status")
    private Integer tkStatus;

    @Field("item_price")
    private Double itemPrice;

    @Field("item_id")
    private Long itemId;

    @Field("adzone_name")
    private String adzoneName;

    @Field("total_commission_rate")
    private Double totalCommissionRate;

    @Field("item_link")
    private String itemLink;

    @Field("site_id")
    private Long siteId;

    @Field("seller_shop_title")
    private String sellerShopTitle;

    @Field("income_rate")
    private Double incomeRate;

    @Field("total_commission_fee")
    private Double totalCommissionFee;

    @Field("tk_commission_pre_fee_for_media_platform")
    private Double tkCommissionPreFeeForMediaPlatform;

    @Field("tk_commission_fee_for_media_platform")
    private Double tkCommissionFeeForMediaPlatform;

    @Field("tk_commission_rate_for_media_platform")
    private Double tkCommissionRateForMediaPlatform;

    @Field("special_id")
    private Long specialId;

    @Field("relation_id")
    private Long relationId;

    @Field("deposit_price")
    private Double depositPrice;

    @Field("tb_deposit_time")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime tbDepositTime;

    @Field("tk_deposit_time")
    @JSONField(format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime tkDepositTime;

    @Field("alsc_id")
    private String alscId;

    @Field("alsc_pid")
    private String alscPid;

}
