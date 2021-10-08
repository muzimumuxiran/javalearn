package Supermarket;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 需求：创建一个方法类
 */
public class function {
    //初始化
    int count = 0;
    //实例化输入对象
    Scanner sc = new Scanner(System.in);
    /**
     * 需求：注册功能
     */
    public void registere(ArrayList<User> arryuser){
        //打印提示信息
        System.out.println("请输入用户名以及密码：");
        //接收键盘信息
        String usernaem = sc.next();
        String password = sc.next();
        //实例化对象
        User user = new User(usernaem,password);
        //添加到集合中
        arryuser.add(user);
        //打印提示信息
        System.out.println("注册成功!");
    }
    /**
     * 需求：登录功能
     */
    public int login(ArrayList<User> arryuser){
        //提示信息
        System.out.println("请输入账户，密码：");
        //获取键盘输入信息
        String uname = sc.next();
        String pas = sc.next();
        //初始化i
        int i = 0;
        //循环遍历，查找用户信息
        for(i=0;i<arryuser.size();i++){
            //判断用户名是否正确
            if(uname.equals(arryuser.get(i).password)){
                //判断密码是否正确
                if(pas.equals(arryuser.get(i).password)){
                    System.out.println("登录成功！");
                    return 1;
                }
            }
        }
        return -1;
    }
    /**
     * 需求：添加商品功能
     */
    public void addgoods(int[][] goods){
        //打印提示
        System.out.println("请输入商品编号，商品价格，商品数量");
        //获取键盘输入的值
        int gno = sc.nextInt();
        int price = sc.nextInt();
        int count = sc.nextInt();

        //存储数据
        goods[count][0] = gno;
        goods[count][1] = price;
        goods[count][2] = count;
        //计数
        count++;
        System.out.println("添加成功！");
    }
    /**
     * 需求：购买商品功能
     */
    public int buy(int[][] good,int[][] goods){
        //初始化信息
        int j = 0;
        //打印提示
        System.out.println("请输入想要购买的商品编号，商品数量");
        //获取键盘输入的值
        int gno = sc.nextInt();
        int number = sc.nextInt();
        //查询商品
        for(int i=0;i<good.length;i++){
            //查找编号
            if(good[i][0] == gno){
                //查看数量
                if(number <= good[i][2]){
                    //更新商品数量
                    good[i][2] = good[i][2]-number;
                    //更新销售信息
                    goods[j][0] = gno;
                    goods[j][1] = good[i][1];
                    goods[j][2] = number;
                    //更新j
                    j++;
                    //设置返回值
                    return number*good[i][1];
                }else{
                    //打印提示
                    System.out.println("商品数量不足");
                }
            }
        }
        return -1;
    }
    /**
     * 需求：结账功能
     */
    public void get(int sum){
        //打印提示
        System.out.println("应付"+sum+"元。");
        System.out.println("请输入要收的钱：");
        //接收键盘输入的值
        int re = sc.nextInt();
        //打印提示
        System.out.println("实收"+re+"元");
        System.out.println("找零"+(re-sum)+"元");
    }
    /**
     * 需求：查看库存功能
     */
    public void see1(int[][] goods){
        //循环打印
        for(int i=0;i<goods.length;i++){
            //判断是否存在
            if(goods[i][0] != 0){
                //打印提示
                System.out.println("商品编号："+goods[i][0]+"商品数量："+goods[i][1]+"商品价格："+goods[i][2]);
            }
        }
    }
    /**
     * 需求：查看订单功能
     */
    public void see2(int[][] goods1){
        //循环打印
        for(int i=0;i<goods1.length;i++){
            //判断是否存在
            if(goods1[i][0] != 0){
                //打印提示
                System.out.println("商品编号："+goods1[i][0]+"商品数量："+goods1[i][1]+"商品价格："+goods1[i][2]);
            }
        }
    }
}
