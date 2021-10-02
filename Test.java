package Supermarket;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 需求：创建一个测试类
 */
public class Test {
    /**
     *需求:主函数--程序的入口
     */
    public static void main(String[] args) {
        //初试化对象
        int[][] goods = new int[30][3];
        int[][] goods1 = new int[30][3];
        int sum = 0;
        //实例化对象
        function fun = new function();
        ArrayList<User> arrayuser = new ArrayList<>();
        //实例化输入对象
        Scanner sc = new Scanner(System.in);
        //添加初始账户
        User user = new User("root","root");
        arrayuser.add(user);
        //循环使用系统
        while(true) {
            //打印提示
            System.out.println("欢迎使用系统，请选择下一步：1.登录；2.注册");
            //接收键盘输入的信息
            int a = sc.nextInt();
            if(a==1){
                    //调用登录函数
                    if(fun.login(arrayuser) == 1){
                        while (true) {
                            //循环使用系统
                            //提示菜单
                            System.out.println("-------输入1，添加商品---------");
                            System.out.println("-------输入2，购买商品---------");
                            System.out.println("-------输入3，结账-------------");
                            System.out.println("-------输入4，查看商品库存------");
                            System.out.println("-------输入5，查看商品订单------");
                            System.out.println("-------输入6，退出-------------");
                            //把键盘录入的值赋值给input
                            int input = sc.nextInt();
                            //根据input的值进行相关操作
                            switch (input) {
                                case 1:
                                    //调用添加方法
                                    fun.addgoods(goods);
                                    break;
                                case 2:
                                    //调用购买方法
                                    sum = fun.buy(goods,goods1);
                                    break;
                                case 3:
                                    //调用结账方法
                                    fun.get(sum);
                                    break;
                                case 4:
                                    //调用查询方法
                                    fun.see1(goods);
                                    break;
                                case 5:
                                    //调用查询方法
                                    fun.see2(goods1);
                                    break;
                                case 6:
                                    //退出系统
                                    System.exit(0);
                                default:
                                    System.out.println("输入错误！");
                            }
                        }

                    }else {
                        //提示错误信息
                        System.out.println("信息错误！无法登录");
                    }
                }
            else if(a == 2){
                //调用注册方法
                fun.registere(arrayuser);
            }else{
                //提示信息
                System.out.println("输入错误！");
            }

        }
    }
}
