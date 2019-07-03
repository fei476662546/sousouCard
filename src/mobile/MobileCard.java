package mobile;

/**
 * Create by mysteriousTime
 * time on 2019/6/28  16:09
 */
public class MobileCard {//嗖嗖移动卡
    private String cardNumber;//电话号码
    private String userName;//使用人姓名
    private String password;//密码
    private ServicePackage serPackage;
    private double consumAmount;//
    private double money;  //账户余额
    private int realTalkTime;//真正通话时长
    private int realSMSCount;//真正短信次数
    private int realFlow;//真正使用流量

public MobileCard(){}
    public MobileCard(String cardNumber, String userName, String password, ServicePackage serPackage,
                      double consumAmount,double money ) {
       super();
        this.userName = userName;
        this.password = password;
        this.cardNumber = cardNumber;
        this.serPackage = serPackage;
        this.consumAmount = consumAmount;
        this.money = money;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setSerPackage(ServicePackage setPackage) {
        this.serPackage = setPackage;
    }

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }

    public void showMeg(){
        System.out.println("卡号："+this.cardNumber+" 用户名："+this.userName+" 当前余额："+this.money+"元。");
        this.serPackage.showInfo();
    }
}
