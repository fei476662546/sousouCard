package mobile;

import java.util.Scanner;

/**
 * Create by mysteriousTime
 * time on 2019/6/28  16:22
 */
public  class TalkPackage extends ServicePackage implements CallService, SendService {//话痨套餐
    private int talkTime;//通话时间
    private int smsCount;//短信条数

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

    public TalkPackage() {
        this.talkTime = 500;
        this.smsCount = 30;
        this.price = 58.0;
    }



    public TalkPackage(int talkTime, int smsCount) {
        super();
        this.talkTime = talkTime;
        this.smsCount = smsCount;
    }

    public void showInfo() {//显示套餐详情
        System.out.println("话唠套餐：通话时长为" + this.talkTime + "分钟/月，短信条数为"
                + this.smsCount + "条/月，资费为" + this.price + "元/月。");
    }

    @Override
    public int call(int minCount, MobileCard card) {//打电话
        return this.talkTime -= minCount;
    }


    @Override
    public int sendMessage(int count, MobileCard card) throws Exception {
        return 0;
    }
}


