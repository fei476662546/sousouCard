package SoSoMobile.entity;

/**
 * Create by mysteriousTime
 * time on 2019/7/1  22:38
 */




/**
 * 消费信息
 */
@SuppressWarnings("unused")
public class ConsumInfo {
    private String cardNumber;  //卡号
    private String type;  //消费类型：通话、发短信、上网
    private int consumData;   //消费数据   通话：分钟   发短信：条   上网：MB

    public ConsumInfo(){}
    public ConsumInfo(String cardNumber, String type, int consumData) {
        super();
        this.cardNumber = cardNumber;
        this.type = type;
        this.consumData = consumData;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getConsumData() {
        return consumData;
    }
    public void setConsumData(int consumData) {
        this.consumData = consumData;
    }
}
