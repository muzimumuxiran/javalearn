package Perpetualcalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * 需求：创建一个日历类
 * @author 刘玲
 * @date   2021年10月2日  15：20
 * @version V.LL.1.0.1
 */
public class Perpetualcalendar {
    /**
     *需求:主函数--程序的入口
     */
    public static void main(String[] args) {
        //打印提示
        System.out.println("请输入一个年份，月份：");
        //初始化对象
        int a = 0;
        //实例化输入对象
        Scanner scan = new Scanner(System.in);
        //接收键盘的输入信息
        int year = scan.nextInt();
        int month = scan.nextInt()-1;
        //判断是否是润年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            //打印提示
            System.out.println(year + "年是闰年！");
            //改变a的值
            a = 1;
        } else {
            System.out.println(year + "年是平年！");
        }
        //根据是否是润年做出选择
        if(a == 1){
            //根据是几月得到天数
            if(month == 2){
                //打印提示
                System.out.println("这个月有29天。");
            }else if (month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12){
                //打印提示
                System.out.println("这个月有31天。");
            }else {
                //打印提示
                System.out.println("这个月有30天。");
            }
        }else{
            //根据是几月得到天数
            if(month == 2){
                //打印提示
                System.out.println("这个月有28天。");
            }else if (month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12){
                //打印提示
                System.out.println("这个月有31天。");
            }else {
                //打印提示
                System.out.println("这个月有30天。");
            }
        }
        //获取一个日历实例
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        //设定日历的日期
        c1.set(1900, 1, 1);
        c2.set(year, month, 1);
        c3.set(year,1,1);
        //获取时间
        Date date1 = c1.getTime();
        Date date2 = c2.getTime();
        Date date3 = c3.getTime();
        //计算相差的日期
        int days1 = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        int days2 = (int) ((date2.getTime() - date3.getTime()) / (1000*3600*24));
        //打印提示
        System.out.println("这个月离1990.1.1有"+(days1+2)+"天");
        System.out.println("这个月离"+year+".1.1有"+(days2+2)+"天");
        //构造一个日历对象，对当前的日期和时间进行初始化
        GregorianCalendar d = new GregorianCalendar();
        //调用日历对象的 set 方法，获得当前的日期
        d.set(year,month,1);
        //将 d 设置为这个月的第一天并获得这一天的星期
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        //输出标题和空格作为日历的第一行
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        //不存在的日期打空格
        for(int i = Calendar.SUNDAY; i < weekday; i++){
            System.out.print("    ");
        }
        //循环输出日期
        do{
            //获取月份
            int day = d.get(Calendar.DAY_OF_MONTH);
            //打印日期
            System.out.printf("%3d", day);
            //打印空格
            System.out.print(" ");
            //换行
            if(weekday == Calendar.SATURDAY){
                System.out.println();
            }
            //日期前进
            d.add(Calendar.DAY_OF_MONTH, 1);
            //获取星期
            weekday = d.get(Calendar.DAY_OF_WEEK);
            //判断是否在这个月
        }while(d.get(Calendar.MONTH) == month);
        //判断是否要换行
        if(weekday != Calendar.SUNDAY){
            System.out.println();
        }

    }
}
