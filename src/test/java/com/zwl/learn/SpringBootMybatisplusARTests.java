package com.zwl.learn;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-12 15:51
 * @Description: 测试AR
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisplusARTests {
    @Autowired
    private Connection hbaseConnection;

    @Test
    public void aaaa() throws IOException {
        try (Table table = hbaseConnection.getTable(TableName.valueOf("user"))) {//获取表连接
            //配置一条数据
            // 行键
            Put put = new Put(Bytes.toBytes("id"));
            put.addColumn(Bytes.toBytes("sys_user"), Bytes.toBytes("id"), Bytes.toBytes("1"));
            //每个有数据的列都要一个addColumn
            //put插入数据
            table.put(put);
        }
    }


//    try(
//    Table table = hbaseConnection.getTable(TableName.valueOf("表名")))
//
//    {
//        Result result = table.get(new Get(asRowKey(date, acid)));
//        if (result == null) return null;
//
//        // 列名为starttime，最后一条就是该航班最新的航迹
//        Cell latestCell = Iterables.getLast(result.listCells());
//        return AdsbTrackProto.AdsbTrack.parseFrom(CellUtil.cloneValue(latestCell));
//    }


//    /**
//     * 添加
//     */
//    @Test
//    public void insertAR() {
//        User user = new User();
//        user.setEmail("ar123@qq.com");
//        user.setAge(22);
//
//        boolean insert = user.insert();
//        System.err.println(insert);
//        System.err.println(user.getId());
//    }
//
//    /**
//     * 修改
//     */
//    @Test
//    public void updateAR() {
//        User user = new User();
//        user.setId(10L);
//        user.setAge(0);
//        boolean b = user.updateById();
//        System.err.println(b);
//    }
//
//
//    /**
//     * 查询
//     */
//    @Test
//    public void selectAR() {
//        // 根据Id查询
//        User user = new User();
//        User user1 = user.selectById(1);
//        // System.err.println(employee1);
//
//        // 查询全部
//        List<User> employeesAll = user.selectAll();
//        // System.err.println(employeesAll);
//
//        // 查询名字带有M的
////        List<User> employees = user.selectList(new EntityWrapper().like("last_name", "M"));
//        // System.err.println(employees);
//
//        // 查询总数量
//        int count = user.selectCount(null);
//        // System.err.println(count);
//
//        // 分页
//        Page<User> page = user.selectPage(
//                new Page<>(1, 2), null);
//        System.err.println(page);
//        /**
//         *  Page:{ [Pagination { total=0 ,size=2 ,pages=0 ,current=1 }], records-size:2 }
//         */
//        List<User> emps = page.getRecords();
//        System.err.println("数据：" + emps);
//    }
//
//    /**
//     * 删除
//     * <p>
//     * 注意:删除不存在的数据在逻辑上也是成功的；
//     */
//    @Test
//    public void deleteAR() {
//        User user = new User();
//        boolean b = user.deleteById(10);
//        System.err.println(b);
//    }

}
