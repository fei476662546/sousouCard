//package SoSoMobile.biz;
//
///**
// * Create by mysteriousTime
// * time on 2019/7/1  22:37
// */
//
//
//import SoSoMobile.entity.MobileCard;
//import SoSoMobile.entity.ServicePackage;
//import SoSoMobile.utils.CardUtil;
//
//import java.util.Scanner;
//
//
//
///**
// * 业务类
// */
//@SuppressWarnings("unused")
//public class SosoMgr {
//    Scanner input = new Scanner(System.in);
//    CardUtil utils = new CardUtil();
//
//    public static void main(String[] args) {
//        SosoMgr soso = new SosoMgr();
//        soso.mainMenu();
//        System.out.println("谢谢使用！");
//    }
//
//    /**
//     * 主流程
//     */
//    public void mainMenu() {
//        int menuChoose = 0;
//        String mobileNumber= "";
//        String password = "";
//        utils.init();
//        utils.initScenes();
//        //Common.typesInit();
//        do {
//            System.out.println("\n*************欢迎使用嗖嗖移动业务大厅***************");
//            System.out.println("1.用户登录   2.用户注册   3.使用嗖嗖   4.话费充值  5.资费说明  6.退出系统");
//            System.out.print("请选择：");
//            menuChoose = input.nextInt();
//            // 分支语句：根据功能编号执行相应功能
//            switch (menuChoose) {
//                case 1:
//                    //用户登录
//                    System.out.print("请输入手机卡号：");
//                    mobileNumber = input.next();
//                    System.out.print("请输入密码：");
//                    password = input.next();
//                    if (utils.isExistCard(mobileNumber, password)) {
//                        cardMenu(mobileNumber);
//                    }else{
//                        System.out.println("对不起，您输入的信息有误，无法登录！");
//                    }
//                    continue;
//                case 2:
//                    //用户注册
//                    registCard();
//                    continue;
//                case 3:
//
//                    //使用嗖嗖
//                    System.out.print("请输入手机卡号：");
//                    mobileNumber = input.next();
//
//                    if (utils.isExistCard(mobileNumber)) {
//                        try {
///*                        System.out.println("****使用之前****");
//                        utils.showRemainDetail(mobileNumber);
//                        utils.showAmountDetail(mobileNumber);*/
//                            utils.userSoso(mobileNumber);
//                        } catch (Exception e) {
//                            System.err.println(e.getMessage());
//                        }
//                    }else{
//                        System.out.println("对不起，该卡号未注册，不能使用！");
//                    }
//
//                /*System.out.println("****使用之后****");
//                utils.showRemainDetail(mobileNumber);
//                utils.showAmountDetail(mobileNumber);*/
//                    continue;
//                case 4:
//                    //话费充值
//                    System.out.print("请输入充值卡号：");
//                    mobileNumber = input.next();
//                    if (utils.isExistCard(mobileNumber)) {
//                        System.out.print("请输入充值金额：");
//                        double money = input.nextDouble();
//                        utils.chargeMoney(mobileNumber, money);
//                    }else{
//                        System.out.println("对不起，要充值的卡号未注册，无法充值！");
//                    }
//                    continue;
//                case 5:
//                    System.out.println("\n*****资费说明******");
//                    utils.showDescription();
//                    continue;
//                case 6:
//                    //退出系统
//                    break;
//                default:
//                    //选择其他数字退出系统
//                    break;
//            }
//            break;
//        } while (true);
//    }
//
//    /**
//     * 手机卡功能菜单
//     *
//     * @param number
//     * @return
//     */
//    public int cardMenu(String mobileNumber) {
//        int menuChoose = 0;
//        do {
//            System.out.println("\n*****嗖嗖移动用户菜单*****");
//            System.out.println("1.本月账单查询");
//            System.out.println("2.套餐余量查询");
//            System.out.println("3.打印消费详单");
//            System.out.println("4.套餐变更");
//            System.out.println("5.办理退网");
//            System.out.print("请选择(输入1~5选择功能，其他键返回上一级)：");
//            menuChoose = input.nextInt();
//            switch (menuChoose) {
//                case 1:
//                    System.out.println("\n*****本月账单查询******");
//                    utils.showAmountDetail(mobileNumber);
//                    continue;
//                case 2:
//                    System.out.println("\n*****套餐余量查询******");
//                    utils.showRemainDetail(mobileNumber);
//                    continue;
//                case 3:
//                    System.out.println("\n*****消费详单查询******");
//                    utils.printConsumInfo(mobileNumber);
//                    continue;
//                case 4:
//                    System.out.println("\n*****套餐变更******");
//                    System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐  请选择（序号）：");
//                    utils.changingPack(mobileNumber, input.next());
//                    continue;
//                case 5:
//                    System.out.println("\n*****办理退网******");
//                    utils.delCard(mobileNumber);
//                    System.out.println("谢谢使用！");
//                    System.exit(1);     //办理退网后退出系统
//
//            }
//
//            break;
//        } while (true);
//        return menuChoose;
//    }
//
//    /**
//     * 注册新卡流程
//     */
//    public void registCard(){
////        String[] newNumbers = utils.getNewNumbers(9);
////        //显示可供选择的手机号列表
////        System.out.println("*****可选择的卡号*****");
////
////        for(int i=0;i<9;i++){
////            System.out.print((i+1)+"."+newNumbers[i]+"\t\t");
////            if((i+1)%3==0){
////                System.out.println();
////            }
////        }
////        //选择手机号
////        System.out.print("请选择卡号（输入1~9的序号）：");
////        String number = newNumbers[input.nextInt()-1];
////
////        //选择套餐类型
////        System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐，  ");
////        System.out.print("请选择套餐(输入序号)：");
////        //utils.getPackList();
////        //获取套餐对象
////        ServicePackage pack = utils.createPack(input.nextInt());
////
////        //输入用户名
////        System.out.print("请输入姓名：");
////        String name = input.next();
////
////        //输入密码
////        System.out.print("请输入密码：");
////        String password = input.next();
////
////        //输入预存话费金额
////        double money = 0;
////        System.out.print("请输入预存话费金额：");
////        money = input.nextDouble();
////        while(money<pack.getPrice()){
////            System.out.print("您预存的话费金额不足以支付本月固定套餐资费，请重新充值：");
////            money = input.nextDouble();
////        }
////
////        //创建新卡对象并添加
////        MobileCard newCard = new MobileCard(name,password,number,pack,pack.getPrice(),money-pack.getPrice());
////        utils.addCard(newCard);
////    }
//}
