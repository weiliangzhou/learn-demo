package com.zwl.learn.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @Description 淘客订单搜索
 * @Author zmj
 * @Date 2020-04-16 10:49
 */
@Data
//@ApiModel("淘客订单搜索")
public class TbkSearchDTO {
    //@ApiModelProperty("主播id")
    private Long streamerId;

    //@ApiModelProperty("用户d")
    private Long userId;

    //@ApiModelProperty("淘宝子订单号")
    private String tradeId;

    //@ApiModelProperty("店铺名称")
    private String shopName;

    //@ApiModelProperty("类目名称")
    private String categoryName;

    //@ApiModelProperty("付款开始时间")
    private LocalDateTime payStart;

    //@ApiModelProperty("付款结束时间")
    private LocalDateTime payEnd;

    //@ApiModelProperty("结算开始时间")
    private LocalDateTime settledStart;

    //@ApiModelProperty("结算结束时间")
    private LocalDateTime settledEnd;

    //@ApiModelProperty("机构id，前端不用传")
    private Long orgId;

    //@ApiModelProperty("订单状态")
    private Integer tkStatus;

    //@ApiModelProperty("分页参数")
    private PageInfo page;

    //@ApiModelProperty("分页页数")
    private List<Integer> pageList;

    //@ApiModelProperty("分页页数")
    private Integer size;

    //@ApiModelProperty("查询总数")
    private Long total;

    //@ApiModelProperty("商品id")
    private Set<Long> itemIds;

    //@ApiModelProperty("根据字段查询")
    private String orderBy;

    //@ApiModelProperty("排序顺序，asc or desc")
    private String order;

}
