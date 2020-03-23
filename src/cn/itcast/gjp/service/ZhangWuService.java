package cn.itcast.gjp.service;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

import java.util.List;

/**
 * @program: GuanJiaPo
 * @description: 业务层
 * @author: Wang Jun
 * @create: 2020-03-18 10:57
 */
public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    /**
     * 方法由控制层调用，由数据层实现
     */
    public List<ZhangWu> selectAll(){
        return dao.selectAll();
    }

    public List<ZhangWu> select(String start,String stop){
        return dao.select(start,stop);
    }

    public void addZhangWu(ZhangWu zhangWu){
        dao.addZhangWu(zhangWu);
    }

    public void editZhangWu(ZhangWu zhangWu){
        dao.editZhangWu(zhangWu);
    }

    public void deleteZhangWu(int zwid){
        dao.deleteZhangWu(zwid);
    }
}
