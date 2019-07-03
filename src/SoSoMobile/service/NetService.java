package SoSoMobile.service;

/**
 * Create by mysteriousTime
 * time on 2019/7/1  22:41
 */


import SoSoMobile.entity.MobileCard;

/**
 * 上网服务
 */
public interface NetService {
    //上网
    public int netPlay(int flow, MobileCard card) throws Exception;
}
