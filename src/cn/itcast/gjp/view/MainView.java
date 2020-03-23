package cn.itcast.gjp.view;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

/**
 * @program: GuanJiaPo
 * @description: 视图层
 * @author: Wang Jun
 * @create: 2020-03-18 11:00
 */
public class MainView {
    private ZhangWuController controller = new ZhangWuController();
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        while (true){
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    //添加账务
                    addZhangWu();
                    break;
                case 2:
                    //编辑账务
                    break;
                case 3:
                    //删除账务
                    break;
                case 4:
                    //查询账务
                    selectZhangWu();
                    break;
                case 5:
                    //退出系统
                    System.out.println("谢谢使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误");
            }
        }
    }

    public void selectZhangWu(){
        System.out.println("1.查询所有      2.条件查询");
        Scanner scanner = new Scanner(System.in);
        int chooseSelect = scanner.nextInt();
        switch (chooseSelect){
            case 1:
                //查询所有
                selectAll();
                break;
            case 2:
                //条件查询
                select();
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    /**
     * 添加账务
     */
    public void addZhangWu(){
        System.out.println("您选择的是添加账务功能，请输入以下信息！");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入分类名称：");
        String flname = scanner.next();
        System.out.print("请输入金额：");
        double money = scanner.nextDouble();
        System.out.print("请输入账户：");
        String zhangHu = scanner.next();
        System.out.print("请输入时间：");
        String createtime = scanner.next();
        System.out.print("请输入描述：");
        String description = scanner.next();
        ZhangWu zhangWu = new ZhangWu(0,flname,money,zhangHu,createtime,description);
        controller.addZhangWu(zhangWu);
    }

    public void selectAll(){
        //调用控制层，查询所有账务数据
        List<ZhangWu> list = controller.selectAll();
        print(list);
    }

    public void select(){
        //按条件查询，输入开始日期和结束日期
        System.out.println("您选择的是日期条件查询，输入格式为XXXX-XX-XX");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入查询开始时间：");
        String start = scanner.next();
        System.out.print("请输入查询结束时间：");
        String stop = scanner.next();
        List<ZhangWu> list = controller.select(start,stop);
        print(list);
    }

    private void print(List<ZhangWu> list) {
        if (list.size()==0)
            System.out.println("抱歉，没有查询到符合要求的数据！");
        else {
            System.out.println("ID\t\t类别\t\t\t账户\t\t\t金额\t\t时间\t\t\t说明");
            //遍历集合,结果输出控制台
            for(ZhangWu zw : list){
                System.out.print(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu());
                if (zw.getZhanghu().length()==2)
                    System.out.print("    ");
                System.out.println("\t\t"+zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t\t"+zw.getDescription());
            }
        }

    }
}
