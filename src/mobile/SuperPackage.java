package mobile;

/**
 * Create by mysteriousTime
 * time on 2019/6/28  16:25
 */
public  class SuperPackage extends ServicePackage implements CallService,SendService,NetService{//超人套餐
    private int talkTime;
    private int smsCount;
    private int flow;
    MobileCard mobileCard;

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }
public SuperPackage(){
    //套餐数据初始化
    this.talkTime = 200;
    this.smsCount = 50;
    this.flow = 1*1024;
    this.price = 78.0;
}
    public SuperPackage( int talkTime, int smsCount, int flow) {
        super();
        this.talkTime = talkTime;
        this.smsCount = smsCount;
        this.flow = flow;
    }

    public void showInfo(){
        System.out.println("超人套餐：通话时长为"+this.talkTime+"分钟/月，短信条数为"+this.smsCount+"条/月，上网流量为"+this.flow/1024+"GB/月。");

    }

    @Override
    public int call(int minCount, MobileCard card) {

        return this.talkTime-=minCount;
    }

    @Override
    public int netPlay(int flow, MobileCard card) {
        return this.flow-=flow;
    }

    @Override
    public int sendMessage(int count, MobileCard card) throws Exception {
        return 0;
    }
}
