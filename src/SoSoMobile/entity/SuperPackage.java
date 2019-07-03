//package SoSoMobile.entity;
//
///**
// * Create by mysteriousTime
// * time on 2019/7/1  22:40
// */
//
//
//
//import SoSoMobile.service.NetService;
//import SoSoMobile.service.SendService;
//import mobile.CallService;
//
///**
// * 超人套餐
// */
//public class SuperPackage extends ServicePackage implements CallService,
//        SendService, NetService {
//    private int talkTime;   //通话时长(分钟)
//    private int smsCount;   //短信条数（条）
//    private int flow;  //上网流量（MB）
//
//    public int getTalkTime() {
//        return talkTime;
//    }
//
//
//    public void setTalkTime(int talkTime) {
//        this.talkTime = talkTime;
//    }
//
//
//    public int getSmsCount() {
//        return smsCount;
//    }
//
//
//    public void setSmsCount(int smsCount) {
//        this.smsCount = smsCount;
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
//    public SuperPackage(){
//        //套餐数据初始化
//        this.talkTime = 200;
//        this.smsCount = 50;
//        this.flow = 1*1024;
//        this.price = 78.0;
//    }
//    @Override
//    public void showInfo() {
//        System.out.println("超人套餐：通话时长为"+this.talkTime+"分钟/月，短信条数为"+this.smsCount+"条/月，上网流量为"+this.flow/1024+"GB/月。");
//    }
//
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
//
//    /**
//     * 提供通话服务
//     */
//    public int call(int minCount, MobileCard card) throws Exception{
//        int temp = minCount;
//        for(int i=0;i<minCount;i++){
//            if(this.talkTime-card.getRealTalkTime()>=1){
//                //第一种情况：套餐剩余通话时长可以付1分钟通话
//                card.setRealTalkTime(card.getRealTalkTime()+1); //实际通话数据加1
//            }else if(card.getMoney()>=0.2){
//                //第二种情况:套餐通话时长已用完，账户余额可以支付1分钟通话，使用账户余额支付
//                card.setRealTalkTime(card.getRealTalkTime()+1); //实际使用通话时长1分钟
//                card.setMoney(Common.sub(card.getMoney(),0.2)); //账户余额消费0.2元（1分钟额外通话）
//                card.setConsumAmount(card.getConsumAmount() + 0.2);
//            }else{
//                temp = i; //记录实现通话分钟数
//                throw new Exception("本次已通话"+i+"分钟,您的余额不足，请充值后再使用！");
//            }
//        }
//        return temp;
//    }
//
//    /**
//     * 提供短信服务
//     */
//    public int sendMessage(int smsCount, MobileCard card) throws Exception {
//        int temp = smsCount;
//        for(int i=0;i<smsCount;i++){
//            if(this.smsCount-card.getRealSMSCount()>=1){
//                //第一种情况：套餐剩余短信条数可以付1条短信
//                card.setRealSMSCount(card.getRealSMSCount()+1); //实际使用短信条数加1
//            }else if(card.getMoney()>=0.1){
//                //第二种情况:套餐短信条数已用完，账户余额可以支付1条短信，使用账户余额支付
//                card.setRealSMSCount(card.getRealSMSCount()+1);
//                card.setMoney(Common.sub(card.getMoney(),0.1)); //账户余额消费0.1元（1条短信费用）
//                card.setConsumAmount(card.getConsumAmount() + 0.1);
//            }else{
//                temp = i;
//                throw new Exception("本次已发送短信"+i+"条,您的余额不足，请充值后再使用！");
//            }
//        }
//        return temp;
//    }
//
//    @Override
//    public int call(int minCount, mobile.MobileCard card) {
//        return 0;
//    }
//}
