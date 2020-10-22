package com.zwl.learn.dao;

import com.zwl.learn.entity.ErsxStrategyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName StrategyMapper @Description @Author 二师兄 @Date 2020-07-03 16:20 @Version V1.0
 */
@Mapper
public interface StrategyMapper {
//    @Select("select id,strategy_name strategyName ,strategy_class strategyClass from strategy where strategy_id =#{strategyId} and is_delete = 0")
    ErsxStrategyDO getByStrategyId(String strategyId,String userId);
}
