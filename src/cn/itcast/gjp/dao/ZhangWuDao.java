package cn.itcast.gjp.dao;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @program: GuanJiaPo
 * @description: 对数据的增删改查，用DBUtils工具类完成
 * @author: Wang Jun
 * @create: 2020-03-18 10:55
 */
public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 查询所有账务数据
     * 由业务层去调用
     */
    public List<ZhangWu> selectAll(){
        String sql = "SELECT * FROM gjp_zhangwu;";
        try {
            List<ZhangWu> list = qr.query(sql,new BeanListHandler<>(ZhangWu.class));
            return list;
        }catch (Exception ex){
            System.out.println(ex);
            throw new RuntimeException("查询所有账务失败！");
        }
    }

    public List<ZhangWu> select(String start,String stop){
        String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?;";
        try {
            List<ZhangWu> list = qr.query(sql,new BeanListHandler<>(ZhangWu.class),start,stop);
            return list;
        }catch (Exception ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败！");
        }
    }

    /**
     * 添加账务
     */
    public void addZhangWu(ZhangWu zhangWu){
        String sql = "INSERT INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES(?,?,?,?,?);";
        try {
            int number = qr.update(sql,zhangWu.getFlname(),zhangWu.getMoney(),zhangWu.getZhanghu(),zhangWu.getCreatetime(),zhangWu.getDescription());
            if (number>0)
                System.out.println("添加账务成功！");
        }catch (Exception ex){
            System.out.println(ex);
            throw new RuntimeException("添加账务失败！");
        }


    }
}
