package cn.itcast.gjp.controller;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

import java.util.List;

/**
 * @program: GuanJiaPo
 * @description: 控制器层
 * @author: Wang Jun
 * @create: 2020-03-18 10:59
 */
public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();

    /**
     * 方法由视图层调用，由服务层实现
     */
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }

    /**
     * 同上，只是只是改为条件查询
     * @param start
     * @param stop
     * @return
     */
    public List<ZhangWu> select(String start,String stop){
        return service.select(start,stop);
    }

    /**
     * 添加账务，由5个参数,返回的数据集为一个Int类型的数，即数据库的影响行数
     */
    public void addZhangWu(ZhangWu zhangWu){
        service.addZhangWu(zhangWu);
    }

    /**
     * 编辑账务
     */
    public void editZhangWu(ZhangWu zhangWu){
        service.editZhangWu(zhangWu);
    }

    /**
     * 删除账务
     */
    public void deleteZhangWu(int zwid){
        service.deleteZhangWu(zwid);
    }
}
