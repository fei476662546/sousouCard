package mobile;

import sun.plugin.security.Broken11ClassFixer;

import java.util.*;


/**
 * Create by mysteriousTime
 * time on 2019/6/30  14:22
 */
public class MenuDemo {
    CardUtil cardUtil = new CardUtil();
    Scanner input = new Scanner(System.in);

    public void showLoginMenu() {
        int menuChoose = 0;
        String mobileNumber = "";
        String password = "";
        cardUtil.initScene();
        cardUtil.initScenes();
        do {
            System.out.println("*****************欢迎来到嗖嗖移动业务大厅********************");
            System.out.println("1.用户登录\t2.用户注册\t3.使用嗖嗖\t4.话费充值\t5.资费说明\t6.退出系统");
            Scanner input = new Scanner(System.in);
            System.out.println("请选择：");//选择进入导航项
            menuChoose = input.nextInt();
            switch (menuChoose) {
                case 1://进入用户登录项

                        System.out.print("请输入手机号码：");
                        String s1 = input.next();
                        System.out.print("请输入密码：");
                        String s2 = input.next();
                        if (cardUtil.isExistCard(s1, s2)) {
                            showMainMenu(s1);
                            continue;
                        } else {
                            System.out.println("密码错误！");
                        }
                    continue;
                case 2:
                    showRegisterMenu();
                    continue;
                case 3:
                    System.out.print("请输入号码：");
                    String s = input.next();
                    cardUtil.userSoso(s);
                    continue;
                case 4:
                    System.out.print("请输入号码：");
                    String s4 = input.next();
                    System.out.println("请输入充值金额：");
                    double d = input.nextDouble();
                    cardUtil.chargeMoney(s4, d);
                    continue;
                case 5:
                    System.out.println("\n*****资费说明******");
                    cardUtil.showDescription();
                    continue;
                case 6:
                    System.out.println("退出系统！！");
                    break;
                default:
                    break;
            }
            break;
        } while (true);

    }

    public int showMainMenu(String Number) {
        Scanner input = new Scanner(System.in);
        int menuChoose = 0;
        do {
            System.out.println("欢迎登录!");
            System.out.println(".....嗖嗖移动用户菜单.....");
            System.out.println("1.本月账单查询\t2.套餐余量查询\t3.打印消费记录\t4.套餐变更\t5.办理退网\t按任意键返回上一级菜单");
            menuChoose = input.nextInt();
            switch (menuChoose) {//二级菜单
                case 1:
                    System.out.println("-----本月账单查询------");
                    cardUtil.showAmountDetail(Number);
                    break;
                case 2:
                    System.out.println("-------本月套餐余量查询-------");
                    cardUtil.showRemainDetail(Number);
                    System.out.println("套餐余量为xxx");
                    break;
                case 3:
                    System.out.println("-------本月消费记录详情--------");
                    cardUtil.printConsumInfo(Number);
                    break;
                case 4:
                    System.out.println("----套餐变更----");
                    System.out.println("请选择要变更的套餐：1.话痨套餐，2.网虫套餐，3.超人套餐");
                    cardUtil.changingPack(Number, input.next());

                    break;
                case 5:
                    System.out.println("为你退网");
                    cardUtil.delCard(Number);
                    System.out.println("谢谢使用！");
                    System.exit(1);
                    break;
                default:
                    break;
            }

            break;
        } while (true);
        return menuChoose;
    }

    public void showRegisterMenu() {//二级菜单注册页面
        String[] newNumbers = cardUtil.getNewNumbers(9);
        //显示可供选择的手机号列表
        System.out.println("*****可选择的卡号*****");

        for (int i = 0; i < 9; i++) {
            System.out.print((i + 1) + "." + newNumbers[i] + "\t\t");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        //选择手机号
        System.out.print("请选择卡号（输入1~9的序号）：");
        String number = newNumbers[input.nextInt() - 1];

        //选择套餐类型
        System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐，  ");
        System.out.print("请选择套餐(输入序号)：");
        //utils.getPackList();
        //获取套餐对象
        ServicePackage pack = cardUtil.createPack(input.nextInt());

        //输入用户名
        System.out.print("请输入姓名：");
        String name = input.next();

        //输入密码
        System.out.print("请输入密码：");
        String password = input.next();

        //输入预存话费金额
        double money = 0;
        System.out.print("请输入预存话费金额：");
        money = input.nextDouble();
        while (money < pack.getPrice()) {
            System.out.print("您预存的话费金额不足以支付本月固定套餐资费，请重新充值：");
            money = input.nextDouble();
        }

        //创建新卡对象并添加
        MobileCard newCard = new MobileCard(number, name, password, pack, pack.getPrice(), money - pack.getPrice());
        cardUtil.addCard(newCard);
    }
//        System.out.println("............欢迎注册嗖嗖卡界面..............");
//        Scanner input = new Scanner(System.in);
//        System.out.println(".....请选择卡号(输入1到9的序号).....");
//        String[] string = {"139", "139", "139", "139", "139", "139", "139", "139", "139"};
//        int nub = 1;//计数器，也是哈希集合的key
//        Map<Integer, String> map = new HashMap();//创建哈希集合
//        for (int j = 0; j < string.length; j++) {
//            StringBuffer sb = new StringBuffer(string[j]);//构造8个初始化为指定字符串内容的字符串缓冲区。
//            Random random = new Random();//随机生成8个数加入到sb对象中
//            for (int x = 0; x < 8; x++) {
//                int s = random.nextInt(10);
//                sb.append(s);//得到的字符串是以String[]数组的中元素打头的字符串，如：139xxxxxxxx
//            }
//
//
////            String str=sb.substring(3);//将前三个字符串切割掉，得到电话号码
//            String str = sb.toString();//将缓冲区转化为字符串
//            map.put(nub, str);//添加
//            System.out.println(nub + ":" + str);//打印
//            nub++;//计算加一
//        }
//        int number = input.nextInt();
//        Set<Map.Entry<Integer, String>> set = map.entrySet();//将Map转化为Set
//        for (Map.Entry<Integer, String> entry : set) {//遍历这随机得到的9个号码
//            if (number == entry.getKey()) {//如果输入的number等于key,将key指向的电话号码添加到mobileCard
//                cardUtil.cards.put(entry.getValue(), mobileCard);//将其添加到hashMap中
//                mobileCard.setCardNumber(entry.getValue());
//                System.out.println("您选择的号码为：" + mobileCard.getCardNumber());
//            }
//        }
//        System.out.println("1.话痨套餐\t2.网虫套餐\t3.超人套餐\t,请选择套餐（输入序号：）：");
//        int m = input.nextInt();
//        switch (m) {
//            case 1:
//                System.out.println("请输入姓名：");
//                String s = input.next();
//                mobileCard.setUserName(s);//创建姓名
//                System.out.println("请输入密码：");
//                String s1 = input.next();
//                mobileCard.setPassword(s1);//密码
//                System.out.println("请输入预存金额：");
//                int i = input.nextInt();
//                mobileCard.setConsumAmount(i);
//                while (i < servicePackage.getPrice()) {
//                    System.out.println("您预存的金额不足以支付本月固定套餐话费，请重新充值：");
//                    i = input.nextInt();
//                    if (i > servicePackage.getPrice()) {
//                        break;
//                    }
//                }
//                System.out.println("话痨套餐：通话时长" + talkPackage.getTalkTime() + "短信" + talkPackage.getSmsCount());
//
//                break;
//            case 2:
//                System.out.println("请输入姓名：");
//                String st = input.next();
//                mobileCard.setUserName(st);//创建姓名
//                System.out.print("请输入密码：");
//                String st1 = input.next();
//                mobileCard.setPassword(st1);
//                System.out.print("请输入预存金额：");
//                int i1 = input.nextInt();
//                mobileCard.setConsumAmount(i1);
//                while (i1 < servicePackage.getPrice()) {
//                    System.out.println("您预存的金额不足以支付本月固定套餐话费，请重新充值：");
//                    i1 = input.nextInt();
//                    if (i1 > servicePackage.getPrice()) {
//                        mobileCard.setSetPackage(servicePackage);
//                        break;
//                    }
//                }
//                System.out.println("网虫套餐：上网流量" + netPackage.getFlow() + "/月");
//
//                break;
//            case 3:
//                ServicePackage servicePackage = new ServicePackage(78);
//                System.out.print("请输入姓名：");
//                String str = input.next();
//                mobileCard.setUserName(str);//创建姓名
//                System.out.print("请输入密码：");
//                String str1 = input.next();
//                mobileCard.setPassword(str1);
//                System.out.print("请输入预存金额：");
//                int i2 = input.nextInt();
//                mobileCard.setConsumAmount(i2);
//                while (i2 < servicePackage.getPrice()) {
//                    System.out.println("您预存的金额不足以支付本月固定套餐话费，请重新充值：");
//                    i2 = input.nextInt();
//                    if (i2 > servicePackage.getPrice()) {
//                        break;
//                    }
//                }
//                System.out.println("超人套餐：通话时长" + superPackage.getTalkTime() + "短信" + superPackage.getSmsCount() + "，上网流量" + superPackage.getFlow());
//                break;
//            default:
//                showLoginMenu();//返回移动大厅
//        }

}

