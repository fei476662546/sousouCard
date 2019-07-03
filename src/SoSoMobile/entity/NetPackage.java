//package SoSoMobile.entity;
//
///**
// * Create by mysteriousTime
// * time on 2019/7/1  22:39
// */
//
//
//import SoSoMobile.common.Common;
//import SoSoMobile.service.NetService;
//
///**
// * 网虫套餐
// */
//public class NetPackage extends ServicePackage implements NetService {
//    private int flow; // 上网流量（MB）
//
//    public NetPackage() {
//        //套餐数据初始化
//        this.flow = 1024 * 3;
//        this.price = 68.0;
//    }
//
//    public NetPackage(int flow) {
//        super();
//        this.flow = flow;
//    }
//
//    public int getFlow() {
//        return flow;
//    }
//
//    public void setFlow(int flow) {
//        this.flow = flow;
//    }
//
//
//
//    @Override
//    public void showInfo() {
//        System.out.println("网虫套餐：上网流量是" + flow / 1024 + "GB/月,月资费是"
//                + this.price + "元/月。");
//    }
//
//    /**
//     * 提供上网服务
//     */
//    @SuppressWarnings("unused")
//    public void netPlay2(int flow, MobileCard card) throws Exception {
//        int reminFlow = this.flow - card.getRealFlow();  //卡中可支付的免费流量
//        // 判断套餐中的上网流量是否足够支付本次上网服务
//        if (this.flow <= reminFlow) {
//            // 套餐中上网流量足够：修改该卡实际上网流量数据
//            card.setRealFlow(card.getRealFlow() + flow);
//        } else {
//            // 套餐中上网流量不够：额外消费需按0.1元/条付费，额外消费金额=0.1*（该卡实际消费上网流量+本次消费上网流量-套餐包含的上网流量）
//            double consumeMoney = 0.1 * (flow-reminFlow);
//            // 该卡账户余额足够支付：修改该卡实际使用的上网流量、账户余额、当月消费金额
//            if (card.getMoney() >= consumeMoney) {
//                //消耗的流量增加
//                card.setRealFlow(card.getRealFlow() + flow);
//                // 当前账户余额＝当前账户余额－额外消费金额
//                card.setMoney(card.getMoney() - consumeMoney);
//                // 当月消费金额＝当月消费金额＋额外消费金额
//                card.setConsumAmount(card.getConsumAmount() + consumeMoney);
//            } else {
//
//                int temp = (int)(card.getMoney()/0.1); //当前余额够大
//                throw new Exception("您的余额不足，请充值后再使用！");
//            }
//        }
//    }
//
//    /**
//     * 提供上网服务
//     */
//    public int netPlay(int flow, MobileCard card) throws Exception {
//        int temp = flow;
//        for(int i=0;i<flow;i++){
//            if(this.flow-card.getRealFlow()>=1){
//                //第一种情况：套餐剩余流量可以支持使用1M流量
//                card.setRealFlow(card.getRealFlow()+1); //实际使用流量加1MB
//            }else if(card.getMoney()>=0.1){
//                //第二种情况:套餐流量已用完，账户余额可以支付1M流量，使用账户余额支付
//                card.setRealFlow(card.getRealFlow()+1); //实际使用流量加1MB
//                card.setMoney(Common.sub(card.getMoney(),0.1)); //账户余额消费0.1元（1M流量费用）
//                card.setConsumAmount(card.getConsumAmount() + 0.1);
//            }else{
//                temp = i;
//                throw new Exception("本次已使用流量"+i+"MB,您的余额不足，请充值后再使用！");
//            }
//        }
//        return temp;
//    }
//}
