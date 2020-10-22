package com.zwl.learn.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.zwl.learn.dto.TbkSearchDTO;
import com.zwl.learn.entity.TbkOrderDO;
import com.zwl.learn.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-20 09:50
 * @Description:
 */
@Service
@Slf4j
public class MongoDbServiceImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    private

    public void export(TbkSearchDTO searchDTO) {
        int size = 10000; //每次多少条数据
        long start = System.currentTimeMillis();
        for (int i = 1; i < 21; i++) {
            long start1 = System.currentTimeMillis();
            List<TbkOrderDO> tbkOrderDOSNew = getDataNew(searchDTO, i, size);
            long end1 = System.currentTimeMillis();
            log.info("大小：：" + tbkOrderDOSNew.size());
            log.info("新耗费时间[{}]", end1 - start1);
        }
        long total = System.currentTimeMillis();
        log.info("新耗费总时间[{}]", total - start);


        long start2 = System.currentTimeMillis();
        for (int i = 1; i < 21; i++) {
            long start3 = System.currentTimeMillis();
            List<TbkOrderDO> tbkOrderDOS = getData(searchDTO, i, size);
            long end3 = System.currentTimeMillis();
            log.info("大小：：" + tbkOrderDOS.size());
            log.info("耗费时间[{}]", end3 - start3);
        }

        long total1 = System.currentTimeMillis();
        log.info("耗费总时间[{}]", total1 - start2);
//        log.info("大小" + tbkOrderDOSNew.size());
//        log.info("大小" + tbkOrderDOS.size());
    }

    private List<TbkOrderDO> getData(TbkSearchDTO searchDTO, int page, int size) {
        Criteria criteria = this.getOrderCriteria(searchDTO);
        Sort sort = new Sort(Sort.Direction.DESC, "tkEarningTime");
        if (StrUtil.isNotBlank(searchDTO.getOrder()) && StrUtil.isNotBlank(searchDTO.getOrderBy())) {
            if ("asc".equals(searchDTO.getOrder())) {
                sort = new Sort(Sort.Direction.ASC, searchDTO.getOrderBy());
            } else if ("desc".equals(searchDTO.getOrder())) {
                sort = new Sort(Sort.Direction.DESC, searchDTO.getOrderBy());
            }
        }
        Query query = Query.query(criteria);
        query.with(sort);
        query.skip(page * size);
        query.limit(size);


        List<TbkOrderDO> items = mongoTemplate.find(query, TbkOrderDO.class, "tbk_order");
        return items;

    }


    private List<TbkOrderDO> getDataNew(TbkSearchDTO searchDTO, int page, int size) {

        List<TbkOrderDO> excelVOS = new ArrayList<>();
        int i = 1;
        DBCollection collection = mongoTemplate.getMongoDbFactory().getLegacyDb().getCollection("tbk_order");
//        DBObject query = new BasicDBObject();
//        DBObject sortDBObject = new BasicDBObject();
//        BasicDBObject basicDBObject = new BasicDBObject("$gte", formatter.format(searchDTO.getSettledStart())).append("$lt", formatter.format(searchDTO.getSettledEnd()));
//        query.put("tkEarningTime", basicDBObject);
//        query.put("tkEarningTime", basicDBObject);
//        MongoClient mongoClient = new MongoClient(new ServerAddress("47.110.163.218", 28018));
//        DB db = mongoClient.getDB("link-common");
//        DBCollection collection = db.getCollection("tbk_order");

//        DBObject query = new BasicDBObject(); //setup the query criteria 设置查询条件
        // 时间区间
        DBObject queryObj = getQuery(searchDTO);
//        DBObject fields = new BasicDBObject(); //only get the needed fields. 设置需要获取哪些域
//        fields.put("itemTitle", 1);
//        fields.put("sellerNick", 1);
//        fields.put("sellerShopTitle", 1);
//        fields.put("itemId", 1);
//        fields.put("itemNum", 1);
        DBCursor dbObjects = collection.find(queryObj);
//        DBCursor dbObjects = collection.find(queryObj, fields);
        //排序
        DBObject sortDBObject = new BasicDBObject();
        sortDBObject.put("tk_earning_time", -1);
        dbObjects.sort(sortDBObject);
        //分页查询
        dbObjects.skip(page).limit(size);
        while (dbObjects.hasNext()) {
            DBObject obj = dbObjects.next();
//            TbkOrderDO tbkOrderDO = excelStructMapper.do2VO(obj);
            //            tbkExcelVO.setNum(i++);
//            tbkExcelVO.setTkCreateTime(obj.get("tkCreateTime"));
//            tbkExcelVO.setTkPaidTime((LocalDateTime) obj.get("tkPaidTime"));
//            tbkExcelVO.setTkEarningTime((LocalDateTime) obj.get("tkEarningTime"));
//            tbkExcelVO.setItemTitle(obj.get("item_title").toString());
//            tbkExcelVO.setSellerNick(obj.get("seller_nick").toString());
//            tbkExcelVO.setSellerShopTitle(obj.get("seller_shop_title").toString());
//            tbkExcelVO.setItemId(obj.get("item_id").toString());
//            tbkExcelVO.setItemNum(obj.get("item_num").toString());
//            tbkExcelVO.setItemPrice(obj.get("item_price").toString());
//                tbkExcelVO.setAlipayTotalPrice();
//                tbkExcelVO.setItemCategoryName();
//                tbkExcelVO.setTradeParentId();
//                tbkExcelVO.setTradeId();
//                tbkExcelVO.setTkStatus();
//                tbkExcelVO.setOrderType();
//                tbkExcelVO.setPayPrice();
//                tbkExcelVO.setTotalCommissionRate();
//                tbkExcelVO.setTotalCommissionFee();
//                tbkExcelVO.setSubsidyRate();
//                tbkExcelVO.setSubsidyFee();
//                tbkExcelVO.setIncomeRate();
//                tbkExcelVO.setTkTotalRate();
//                tbkExcelVO.setAlimamaRate();
//                tbkExcelVO.setAlimamaShareFee();
//                tbkExcelVO.setPubSharePreFee();
//                tbkExcelVO.setPubShareFee();
//                tbkExcelVO.setFlowSource();
//                tbkExcelVO.setTkOrderRole();
//                tbkExcelVO.setSiteName();
//                tbkExcelVO.setAdzoneName();
//                tbkExcelVO.setRefundTag();
//                tbkExcelVO.setTkCommissionRateForMediaPlatform();
//                tbkExcelVO.setTkCommissionPreFeeForMediaPlatform();
//                tbkExcelVO.setTkCommissionFeeForMediaPlatform();
//                tbkExcelVO.setTkDepositTime();
//                tbkExcelVO.setTbDepositTime();
//                tbkExcelVO.setDepositPrice();
//            excelVOS.add(tbkOrderDO);

        }

        return excelVOS;
    }

    private DBObject getQuery(TbkSearchDTO searchDTO) {

        DBObject query = new BasicDBObject();
        try {
            query.put("$gte", simpleDateFormat.parse("2020-04-01 00:00:00"));
            query.put("$lte", simpleDateFormat.parse("2020-05-01 00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DBObject ageCompare = new BasicDBObject();
        ageCompare.put("tk_earning_time", query);

        if (searchDTO.getStreamerId() != null) {
            ageCompare.put("streamer_id", searchDTO.getStreamerId());
        }

        if (searchDTO.getOrgId() != null) {
            ageCompare.put("org_id", searchDTO.getOrgId());
        }

        if (StrUtil.isNotBlank(searchDTO.getTradeId())) {
            ageCompare.put("trade_id", searchDTO.getTradeId());
        }
        if (StrUtil.isNotBlank(searchDTO.getCategoryName())) {
            ageCompare.put("item_category_name", searchDTO.getCategoryName());
        }
        if (StrUtil.isNotBlank(searchDTO.getShopName())) {
            //模糊查询
            Pattern pattern = Pattern.compile(".*" + searchDTO.getShopName() + ".*", Pattern.CASE_INSENSITIVE);
            ageCompare.put("seller_shop_title", pattern);
        }
        return ageCompare;
    }

    public Criteria getOrderCriteria(TbkSearchDTO searchDTO) {
        Criteria criteria = new Criteria();

        if (searchDTO.getStreamerId() != null) {
            criteria.and("streamerId").is(searchDTO.getStreamerId());
        }
        try {
            criteria.andOperator(
                    criteria.where("tkEarningTime").gte(simpleDateFormat.parse("2020-04-01 00:00:00")),
                    criteria.where("tkEarningTime").lte(simpleDateFormat.parse("2020-05-01 00:00:00"))
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (searchDTO.getOrgId() != null) {
            criteria.and("orgId").is(searchDTO.getOrgId());
        }

        if (StrUtil.isNotBlank(searchDTO.getTradeId())) {
            criteria.and("tradeId").is(searchDTO.getTradeId());
        }

        if (StrUtil.isNotBlank(searchDTO.getCategoryName())) {
            criteria.and("itemCategoryName").is(searchDTO.getCategoryName());
        }

        if (StrUtil.isNotBlank(searchDTO.getShopName())) {
            criteria.and("sellerShopTitle").regex(".*" + searchDTO.getShopName() + ".*");
        }


//        if (searchDTO.getPayStart() != null && searchDTO.getPayEnd() == null) {
//            criteria.and("tkDepositTime").gte(searchDTO.getPayStart());
//        } else if (searchDTO.getPayEnd() != null && searchDTO.getPayStart() == null) {
//            criteria.and("tkDepositTime").lte(searchDTO.getPayEnd());
//        } else if (searchDTO.getPayEnd() != null && searchDTO.getPayStart() != null) {
//            criteria.andOperator(
//                    criteria.where("tkDepositTime").gte(searchDTO.getPayStart()),
//                    criteria.where("tkDepositTime").lte(searchDTO.getPayEnd())
//            );
//        }
        return criteria;


    }

    public void initdata() {
        for (int i = 0; i < 1500000; i++) {
            LocalDateTime localDateTime = DateUtil.randomDate("2020-04-01", "2020-5-01");
            String randomString = RandomUtil.randomString(8);
            double randomDouble = RandomUtil.randomDouble(2, 2, RoundingMode.UP);
            long randomLong = RandomUtil.randomLong(8);
            int randomInt = RandomUtil.randomInt(8);

            TbkOrderDO tbkOrderDO = new TbkOrderDO();
            tbkOrderDO.setUserId(2260L);
            tbkOrderDO.setStreamerId(122L);
            tbkOrderDO.setOrgId(62L);
            tbkOrderDO.setTbPaidTime(localDateTime);
            tbkOrderDO.setTkPaidTime(localDateTime);
            tbkOrderDO.setPayPrice(randomDouble);
            tbkOrderDO.setPubShareFee(randomDouble);
            tbkOrderDO.setTradeId(RandomUtil.randomNumbers(17));
            tbkOrderDO.setTkOrderRole(2);
            tbkOrderDO.setTkEarningTime(localDateTime);
            tbkOrderDO.setAdzoneId(randomLong);
            tbkOrderDO.setPubShareRate(randomDouble);
            tbkOrderDO.setRefundTag(0);
            tbkOrderDO.setSubsidyRate(randomDouble);
            tbkOrderDO.setTkTotalRate(randomDouble);
            tbkOrderDO.setItemCategoryName("家庭/个人清洁工具");
            tbkOrderDO.setSellerNick(randomString);
            tbkOrderDO.setPubId(randomLong);
            tbkOrderDO.setAlimamaRate(randomDouble);
            tbkOrderDO.setSubsidyType("--");
            tbkOrderDO.setItemImg("//img.alicdn.com/tfscom/i2/4229252307/O1CN01rpVYec1SueIJUi56G_!!4229252307.jpg");
            tbkOrderDO.setPubSharePreFee(randomDouble);
            tbkOrderDO.setAlipayTotalPrice(randomDouble);
            tbkOrderDO.setItemTitle(randomString);
            tbkOrderDO.setSiteName(randomString);
            tbkOrderDO.setItemNum(randomLong);
            tbkOrderDO.setSubsidyFee(randomDouble);
            tbkOrderDO.setAlimamaShareFee(randomDouble);
            tbkOrderDO.setTradeParentId(randomString);
            tbkOrderDO.setOrderType(randomString);
            tbkOrderDO.setTkCreateTime(localDateTime);
            tbkOrderDO.setFlowSource(randomString);
            tbkOrderDO.setTerminalType(RandomUtil.randomNumbers(2));
            tbkOrderDO.setClickTime(localDateTime);
            tbkOrderDO.setTkStatus(randomInt);
            tbkOrderDO.setItemPrice(randomDouble);
            tbkOrderDO.setItemId(randomLong);
            tbkOrderDO.setAdzoneName(randomString);
            tbkOrderDO.setTotalCommissionRate(randomDouble);
            tbkOrderDO.setItemLink(randomString);
            tbkOrderDO.setSiteId(randomLong);
            tbkOrderDO.setSellerShopTitle(randomString);
            tbkOrderDO.setIncomeRate(randomDouble);
            tbkOrderDO.setTotalCommissionFee(randomDouble);
            tbkOrderDO.setTkCommissionPreFeeForMediaPlatform(randomDouble);
            tbkOrderDO.setTkCommissionFeeForMediaPlatform(randomDouble);
            tbkOrderDO.setTkCommissionRateForMediaPlatform(randomDouble);
            tbkOrderDO.setSpecialId(randomLong);
            tbkOrderDO.setRelationId(randomLong);
            tbkOrderDO.setDepositPrice(randomDouble);
            tbkOrderDO.setTbDepositTime(localDateTime);
            tbkOrderDO.setTkDepositTime(localDateTime);
            tbkOrderDO.setAlscId(randomString);
            tbkOrderDO.setAlscPid(randomString);
            mongoTemplate.save(tbkOrderDO);
            log.info(i + "成功保存");
        }


    }
}
