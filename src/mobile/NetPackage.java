package mobile;

/**
 * Create by mysteriousTime
 * time on 2019/6/28  16:23
 */
public class NetPackage extends ServicePackage implements NetService{//网虫套餐
    public int flow;//上网流量
    public int getFlow() {
        return flow;
    }
    public NetPackage() {
        //套餐数据初始化
        this.flow = 1024 * 3;
        this.price = 68.0;
    }
    public void setFlow(int flow) {
        this.flow = flow;
    }

    public NetPackage( int flow) {
        super();
        this.flow = flow;
    }

    public void showInfo(){
        System.out.println("网虫套餐：上网流量是" + flow / 1024 + "GB/月,月资费是"
                + this.price + "元/月。");
    }

    @Override
    public int netPlay(int flow, MobileCard card) {//消耗流量
        return this.flow-=flow;
    }


}
