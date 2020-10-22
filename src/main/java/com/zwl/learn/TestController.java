package com.zwl.learn;

import com.alibaba.fastjson.JSON;
import com.zwl.learn.dto.TbkSearchDTO;
import com.zwl.learn.entity.User;
import com.zwl.learn.hbase.config.HBaseClient;
import com.zwl.learn.service.UserService;
import com.zwl.learn.service.impl.MongoDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName TestController
 * @Description wapper介绍 ：
 * Wrapper ： 条件构造抽象类，最顶端父类，抽象类中提供4个方法西面贴源码展示
 * AbstractWrapper ： 用于查询条件封装，生成 sql 的 where 条件
 * AbstractLambdaWrapper ： Lambda 语法使用 Wrapper统一处理解析 lambda 获取 column。
 * LambdaQueryWrapper ：看名称也能明白就是用于Lambda语法使用的查询Wrapper
 * LambdaUpdateWrapper ： Lambda 更新封装Wrapper
 * QueryWrapper ： Entity 对象封装操作类，不是用lambda语法
 * UpdateWrapper ： Update 条件封装，用于Entity对象更新操作
 * @Author 二师兄
 * @Date 2020-07-03 15:08 @Version V1.0
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private MongoDbServiceImpl mongoDbService;

    @RequestMapping("/test")
    public String testSelect(String name, Integer startAge, Integer endAge, String email, String ages) {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        User user = new User();
//        List<User> userList = user.selectAll();

        // 分页

//        Page<User> page = user.selectPage(
//                new Page<>(1, 3), new QueryWrapper<>(user));
        //根据id查询
//        User user1 = user.selectById(1);
//        System.out.println(user1);
        //根据条件查询
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq(StrUtil.isNotBlank(name), "name", name);
//        queryWrapper.between(null != startAge && null != endAge, "age", startAge, endAge);
//        queryWrapper.like(StrUtil.isNotBlank(email), "email", email);
//        queryWrapper.in(StrUtil.isNotBlank(ages), "age", StrUtil.isNotBlank(ages) ? ages.split(",") : null);
//        User user = new User();
//        user.setName(null);
//        user.setAge(18);
//        queryWrapper.setEntity(user);
//        queryWrapper.eq("name",name);
//        List<User> users = userMapper.selectList(queryWrapper);
        //lambda
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(StrUtil.isNotBlank(name), User::getName, name);
//        List<User> users = userMapper.selectList(lambdaQueryWrapper);

//        return JSON.toJSONString(users);

//        User insert = new User();
//        insert.setName("二师兄");
//        insert.setAge(18);
//        insert.setEmail("123@qq.com");
//        userService.save(insert);
//
//        User update = new User();
//        update.setId(4L);
//        update.setName("二师兄1");
//        update.setVersion(1);
//        userService.updateById(update);

        // 链式查询 普通
        // 链式查询 lambda 式。注意：不支持 Kotlin
        List<User> users = userService.lambdaQuery()
                .like(User::getName, "二")
                .eq(User::getAge, 18)
                .list();

        User user = userService.lambdaQuery().eq(User::getId, 4).one();
//        User user = userService.lambdaQuery().eq(User::getId, 4).page(new Page<>(1, 3))
        User update = new User();


        update.setName("lambda更新");
        update.setAge(11);
        update.setEmail("test@qq.com");
        //更新乐观锁
        update.setVersion(2);
        boolean success = userService.lambdaUpdate().eq(User::getId, 4).update(update);
        System.out.println(success);
//        users.forEach(System.out::println);

//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getName, "二师兄");
//        List<User> list = userService.list(lambdaQueryWrapper);
//        list.forEach(System.out::println);
        return JSON.toJSONString(user);
    }

//    @GetMapping("/delete")
//    public String delete(Long id) {
//        return userMapper.deleteById(id) > 0 ? "success" : "fail";
//
//    }
//
//    @GetMapping("/get")
//    public String get(Long id) {
//        User user = userMapper.selectById(id);
//        return JSON.toJSONString(user);
//
//    }

//    @GetMapping("/update")
//    public String update() {
//        User user = new User();
//        user.setId(1L);
//        user.setAge(1);
//        user.setEmail("1");
//        return userMapper.updateById(user) > 0 ? "success" : "fail";
//    }

    @RequestMapping("/mo")
    public String mo(@RequestBody TbkSearchDTO searchDTO) {
        mongoDbService.export(searchDTO);
        return "";
    }

    @RequestMapping("/initdata")
    public String initdata() {
        mongoDbService.initdata();
        return "";
    }



    @Autowired
    private HBaseClient hBaseClient;

    /**
     * 测试删除、创建表
     */
    @RequestMapping("/get")
    public void testGetValue() {
        String value = hBaseClient.getValue("tbl_user", "mengday", "info", "age");
        System.out.println(value);
    }

    @RequestMapping("/add")
    public void testCreateTable() throws IOException {
        String tableName = "tbl_abc";
        hBaseClient.deleteTable(tableName);
        hBaseClient.createTable(tableName, new String[] {"cf1", "cf2"});
    }

    @RequestMapping("/drop")
    public void dropTable() throws IOException {
        hBaseClient.deleteTable("tbl_abc");
    }


    @RequestMapping("/addOrUpdate")
    public void testInsertOrUpdate() throws IOException {
        hBaseClient.insertOrUpdate("tbl_abc", "rowKey1", "cf1", new String[]{"c1", "c2"}, new String[]{"v1", "v22"});
    }

    @RequestMapping("/getOne")
    public void testSelectOneRow() throws IOException {
        hBaseClient.selectOneRow("tbl_abc", "rowKey1");
    }

    @RequestMapping("/scanTable")
    public void testScanTable() throws IOException {
        hBaseClient.scanTable("tbl_abc", "rowKey1");
    }

}
