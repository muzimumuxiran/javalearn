package learn1;

import java.util.Scanner;
import java.util.Random;
import java.lang.Exception;
/**
 需求：彩票投注站的彩票投注系统---双色球
 要点提取：
 主界面--显示所有功能
 分发功能模块
 手动投注
 自动投注
 兑奖
 退出
 游戏规则：6+1
 在33个红球中选择6个，在16个蓝球中选择1个
 不包括0号球
 兑奖规则：
 兑奖规则
 一等奖	6+1
 二等奖	6+0
 三等奖	5+1
 四等奖	5+0或中4+1
 五等奖	4+0或中3+1
 六等奖	2+1或中1+1或中0+1
 思路分析
 1.游戏主界面
 2.进入选择功能界面
 3.通过获取注入信息--进入相应模块
 3.1人工模块
 通过手动输入彩票号码--判断是否合法
 打印彩票
 注意:可以一次手动输入5注一张彩票是5注
 3.2机选模块
 确定选几注【1-5】随机获取号码
 获取红球  获取蓝球
 打印彩票
 3.3兑奖
 【正常服务同一生成中奖号码，各个客户端只要输入买的彩票信息兑奖就可以了】
 获取中奖号码
 手动录入
 或者随机生成
 录入多买彩票号码
 判断兑奖
 步骤:
 1.创建类
 2.主函数--程序入口3.欢迎界面
 4.功能选择
 5.通过输入信息判断确定进入哪一个模块Scanner if
 5.1进入人工模块
 5.1.1 模块的欢迎界面
 5.1.2模块功能选择
 投注  或者  结束当前模块回到主界面
 确定投几注
 提示手动输入对应的号码
 打印投注的彩票信息
 5.2.进入机选模块
 5.2.1 机选模块的欢迎界面
 5.2.2机选模块的功能选择模块
 投注 或者 退出
 确定投几注?
 随机取对应的彩票信息
 打印彩票信息
 5.3 兑奖模块
 5.3.0欢迎界面
 5.3.1 功能选择
 兑奖 或者 退出模块
 5.3.2获取获取号码【随机或者录入】
 5.3.3录入彩票号码
 5.3.4 兑奖判断
 5.3.5 得出结果输出
 */
public class DuotoneBallLottery {
    /**
     需求:主函数--程序的入口
     游戏业务的所有功能都写在里面author
     教头
     date
     2021年09月14日9:06
     */
    public static void main(String[] args) {
        //定义键盘接收器对象
        Scanner sc = new Scanner(System.in);
        //定义随机数对象
        Random rd = new Random();
        //定义变量存放手选注数
        int sxzs = 0;
        //定义变量存放机选注数
        int jxzs = 0;
        //定义数组存放手选结果
        int[][] sx = new int[5][7];
        //定义数组存放机选结果
        int[][] jx = new int[5][7];
        //提示游戏的欢迎界面
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" $$$~~~~~~~~~欢迎您进入双色球彩票投注站~~~~~~~~~~~$$$");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        //等待提示
        System.out.println("正在进入系统... ");
        //等待三秒
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        //循环让以下代码重复运行
        while (true) {

            //进入功能选择模块
            System.out.println("======================================================");
            System.out.println("            输入1-进入手选模块       输入2-进入机选模块         ");
            System.out.println("            输入3-进入兑奖模块       输入其他-退出系统    ");
            System.out.println("======================================================");

            //提示信息
            System.out.println("请输入对应整数，进入您需要的功能模块：");
            //要求输入信息
            int index = sc.nextInt();

            //进行判断 --- if
            //判断是否进入手动模块
            if (index == 1) {
                //欢迎界面
                System.out.println("*******************欢迎进入人工模块******************");
                while (true) {
                    //选择功能
                    System.out.println("   -----------------------------------------------");
                    System.out.println("              1-开始投注    其他-返回主页        ");
                    System.out.println("   -----------------------------------------------");
                    //提示输入选择
                    System.out.println("请输入对应整数，进入相应操作：");
                    //键盘接收输入的数据
                    int inp1 = sc.nextInt();

                    //判断操作方式
                    if (inp1 == 1) {
                        //提示信息
                        System.out.println("您已进入投注状态，开始投注！！！！！");
                        //提示输入注数
                        System.out.println("请输入你需要投的注数（整数1~5）：");
                        int stakes = 0;
                        //循环控制
                        while (true) {
                            //键盘接收注数
                            stakes = sc.nextInt();


                            //判断输入信息是否合法
                            if (stakes >= 1 && stakes <= 5) {
                                System.out.println("输入信息合法，请继续..........");
                                //将键盘接收的数据给手选注数赋值
                                sxzs = stakes;
                                //结束循环
                                break;
                            } else {
                                //提示信息
                                System.out.println("输入信息不合法，请重新输入：");
                            }
                        }

                        //获取彩票信息
                        //定义数组存储彩票信息
                        int[][] douballarr = new int[stakes][7];

                        //手动接收信息--确定注数
                        for (int st = 0; st < stakes; st++) {
                            //---------接收每注信息---------
                            //提示信息--录入第几注
                            System.out.println("请开始录入第【" + (st + 1) + "】注信息");
                            //手动输入红球信息  h1--红球个数
                            for (int h1 = 0; h1 < 6; h1++) {
                                //提示出入
                                System.out.println("请输入第【" + (h1 + 1) + "】个红球信息");

                                //定义变量  hh --红球数组
                                int hh = 0;

                                //循环接收红球信息
                                while (true) {
                                    //接收红球信息
                                    hh = sc.nextInt();
                                    //定义计数变量
                                    int count = 0;

                                    //判断当前的数据是否已经使用过---在当前这一注中
                                    for (int z = 0; z < h1; z++) {

                                        //判断输入的数据在这一注中是否已经输入过
                                        if (hh == douballarr[st][z]) {
                                            //记录
                                            count++;
                                        }
                                    }

                                    //判断数据是否合法
                                    if (hh < 34 && hh >= 1 && count == 0) {
                                        //提示信息合法
                                        System.out.println("输入的信息合法，请继续输入：");
                                        //结束当前循环
                                        break;
                                    } else {
                                        //提示
                                        System.out.println("输入数据有误，请重新输入");

                                    }
                                }
                                //将合法的数据存入数组
                                douballarr[st][h1] = hh;
                            }//红球信息录入结束

                            //----录入蓝球信息----
                            //提示信息
                            System.out.println("请输入蓝球信息（整数1~16）：");
                            //定义变量
                            int blueball = 0;
                            //循环控制次数
                            while (true) {
                                //键盘接收数据
                                blueball = sc.nextInt();
                                //判断数据是否合法
                                if (blueball <= 16 && blueball >= 1) {
                                    //提示
                                    System.out.println("输入的信息合法，请继续输入：");
                                    break;
                                } else {
                                    //提示
                                    System.out.println("输入数据有误，请重新输入");
                                }
                            }

                            //将合法的蓝球数据存入数组
                            douballarr[st][6] = blueball;

                            //将手选结果存入手选数组
                            for (int i = 0; i < stakes; i++) {
                                for (int j = 0; j < 7; j++) {
                                    //把数组douballarr的值赋给手选数组sx
                                    sx[i][j] = douballarr[i][j];
                                }
                            }
                        }
                        //打印所录入的彩票信息
                        for (int m = 0; m < douballarr.length; m++) {
                            System.out.println("第【" + (m + 1) + "】注：");
                            System.out.print("红球：");
                            for (int n = 0; n < douballarr[m].length; n++) {
                                //输出红球信息
                                if (n < 6) {
                                    System.out.print(douballarr[m][n] + "   ");
                                } else {
                                    System.out.println("   蓝球：" + douballarr[m][n]);
                                }
                            }
                            //换行
                            System.out.println();
                        }


                    } else {
                        //提示信息，退出当前模块，返回主页面
                        System.out.println("即将退出人工模块，返回主页面..............");
                        //结束
                        break;
                    }
                }

            } else if (index == 2) {//判断是否进入机选模块
                //欢迎界面
                System.out.println("*******************欢迎进入机选模块******************");
                //循环控制执行次数
                while (true) {
                    //选择功能
                    System.out.println("   -----------------------------------------------");
                    System.out.println("              1-开始投注    其他-返回主页        ");
                    System.out.println("   -----------------------------------------------");
                    //提示输入选择
                    System.out.println("请输入对应整数，进入相应操作：");
                    //键盘接收输入的数据
                    int inp2 = sc.nextInt();

                    //判断输入的数据
                    if (inp2 == 1) {
                        //提示输入注数
                        System.out.println("请输入您需要投的注数（整数1~5）：");

                        //定义注数变量
                        int stakes2 = 0;
                        while (true) {
                            //接收信息
                            stakes2 = sc.nextInt();
                            //判断输入是否合法
                            if (stakes2 <= 5 && stakes2 >= 1) {
                                //提示合法
                                System.out.println("您的输入合法，请继续..........");
                                //将键盘接收的数据给机选注数赋值
                                jxzs = stakes2;
                                //结束循环
                                break;
                            } else {
                                //提示不合法
                                System.out.println("输入信息不合法，请重新输入：");
                            }
                        }

                        //定义数组变量存储数据
                        int[][] douballarr1 = new int[stakes2][7];

                        //循环控制注数，获取数据
                        for (int zs = 0; zs < stakes2; zs++) {
                            //循环获取红球
                            for (int hq = 0; hq < 6; hq++) {
                                //定义红球
                                int rdhq = 0;
                                //循环控制
                                while (true) {
                                    //随机数获取红球
                                    rdhq = rd.nextInt(33) + 1;
                                    //定义计数变量
                                    int count = 0;
                                    //判断数据是否在该注重复
                                    for (int i = 0; i < hq; i++) {
                                        //
                                        if (rdhq == douballarr1[zs][i]) {
                                            //计数
                                            count++;
                                        }
                                    }

                                    //判断并显示是否重复
                                    if (count == 0) {

                                        //结束
                                        break;
                                    }
                                }
                                //将获取的随机数存入数组
                                douballarr1[zs][hq] = rdhq;
                            }

                            //随机获取蓝球信息存入数组
                            douballarr1[zs][6] = rd.nextInt(16) + 1;
                        }

                        //控制注数，显示数据
                        for (int k = 0; k < douballarr1.length; k++) {
                            //显示
                            System.out.println("第【" + (k + 1) + "】注：");
                            System.out.print("红球：");
                            for (int j = 0; j < 6; j++) {
                                //获取红球数据并显示
                                System.out.print(douballarr1[k][j] + "    ");
                            }
                            //获取蓝球数据并显示
                            System.out.println("   蓝球：" + douballarr1[k][6]);
                        }
                        //换行
                        System.out.println();
                        //将机选结果存机选数组
                        for (int i = 0; i < stakes2; i++) {
                            for (int j = 0; j < 7; j++) {
                                //把数组douballarr1的值赋给机选数组jx
                                jx[i][j] = douballarr1[i][j];
                            }
                        }
                    } else {
                        //提示信息，退出当前模块，返回主页面
                        System.out.println("即将退出机选模块，返回主页面..............");
                        //结束
                        break;
                    }
                }


            } else if (index == 3) {//判断是否兑奖
                //欢迎界面
                System.out.println("*******************欢迎进入兑奖模块*******************");

                //定义变量--开奖结果
                int[] resultArr = new int[7];
                //判断是否生成了重复数字
                for (int i = 0; i < 6; i++) {
                    //定义变量存放红球信息
                    int rshq = 0;
                    while (true) {
                        //获取随机数--红球
                        rshq = rd.nextInt(33) + 1;
                        //定义变量a作为判定标记
                        int a = 0;
                        for (int j = 0; j <= i; j++) {
                            if (rshq == resultArr[j]) {
                                a = 1;
                            }
                        }
                        //没有重复数据时
                        if (a == 0) {
                            //结束
                            break;
                        }
                    }
                    //将不重复的随机数存入表示开奖结果的数组中
                    resultArr[i] = rshq;
                }
                //显示今日开奖结果
                System.out.println("---------【开奖结果公示】---------");
                System.out.print("红球：");
                for (int i = 0; i < 6; i++) {
                    System.out.print(resultArr[i] + "    ");
                }
                //随机获取蓝球信息存入数组
                resultArr[6] = rd.nextInt(16) + 1;
                //获取蓝球数据并显示
                System.out.println("   蓝球：" + resultArr[6]);
                //判断是否有手选信息
                if (sxzs != 0) {
                    //红球匹配的个数
                    int sum = 0;
                    //如果有，显示机选信息
                    for (int m = 0; m < sxzs; m++) {
                        System.out.println("第【" + (m + 1) + "】注：");
                        System.out.print("红球：");
                        for (int n = 0; n < sx[m].length ; n++) {
                            //输出红球信息
                            if (n < 6) {
                                System.out.print(sx[m][n] + "   ");
                            } else {//输出蓝球信息
                                System.out.println("   蓝球：" + sx[m][n]);
                            }
                            if (sx[m][n] == resultArr[n]) {
                                sum++;
                            }
                        }
                        if (sx[m][6] == resultArr[6]) {
                            System.out.print("第【" + (m + 1) + "】注：");
                            switch (sum) {
                                case 6:
                                    System.out.println("一等奖！");
                                    break;
                                case 5:
                                    System.out.println("三等奖！");
                                    break;
                                case 4:
                                    System.out.println("四等奖！");
                                    break;
                                case 3:
                                    System.out.println("五等奖！");
                                    break;
                                case 2:
                                    System.out.println("六等奖！");
                                    break;
                                case 1:
                                    System.out.println("六等奖！");
                                    break;
                                case 0:
                                    System.out.println("六等奖！");
                                    break;
                                default:
                                    System.out.println("没中奖！");
                            }
                        } else {
                            System.out.println("第【" + (m + 1) + "】注：");
                            switch (sum) {
                                case 6:
                                    System.out.println("二等奖！");
                                    break;
                                case 5:
                                    System.out.println("四等奖！");
                                    break;
                                case 4:
                                    System.out.println("五等奖！");
                                    break;
                                default:
                                    System.out.println("没中奖！");
                            }
                        }
                    }

                } //判断是否有机选信息
                else if (jxzs != 0) {
                    int sum = 0;
                    //如果有，显示机选信息
                    for (int m = 0; m < jxzs; m++) {
                        System.out.println("第【" + (m + 1) + "】注：");
                        System.out.print("红球：");
                        for (int n = 0; n < jx[m].length ; n++) {
                            //输出红球信息
                            if (n < 6) {
                                System.out.print(jx[m][n] + "   ");
                            } else {//输出蓝球信息
                                System.out.println("   蓝球：" + jx[m][n]);
                            }
                            if (jx[m][n] == resultArr[n]) {
                                sum++;
                            }
                        }
                        if (jx[m][6] == resultArr[6]) {
                            System.out.print("第【" + (m + 1) + "】注：");
                            switch (sum) {
                                case 6:
                                    System.out.println("一等奖！");
                                    break;
                                case 5:
                                    System.out.println("三等奖！");
                                    break;
                                case 4:
                                    System.out.println("四等奖！");
                                    break;
                                case 3:
                                    System.out.println("五等奖！");
                                    break;
                                case 2:
                                    System.out.println("六等奖！");
                                    break;
                                case 1:
                                    System.out.println("六等奖！");
                                    break;
                                case 0:
                                    System.out.println("六等奖！");
                                    break;
                                default:
                                    System.out.println("没中奖！");
                            }
                        } else {
                            System.out.println("第【" + (m + 1) + "】注：");
                            switch (sum) {
                                case 6:
                                    System.out.println("二等奖！");
                                    break;
                                case 5:
                                    System.out.println("四等奖！");
                                    break;
                                case 4:
                                    System.out.println("五等奖！");
                                    break;
                                default:
                                    System.out.println("没中奖！");
                            }
                        }
                    }
                }
                //如果都没有
                else {
                    //显示未投注
                    System.out.println("您还未投注哦！投注之后再来吧！");
                    //等待三秒
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                    //退出兑奖模块提示
                    System.out.println("即将返回主页面..........");
                    //等待三秒
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    break;
                }
            }else{
                //如果以上都不是--退出系统
                //退出系统提示
                System.out.println("*******   您即将退出系统，欢迎下次再来    **********");
                break;
            }
        }
    }
}
