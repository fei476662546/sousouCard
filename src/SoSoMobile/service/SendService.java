package SoSoMobile.service;

/**
 * Create by mysteriousTime
 * time on 2019/7/1  22:41
 */

import SoSoMobile.entity.MobileCard;

/**
 * 短信服务
 */
public interface SendService {
    //发短信
    public int sendMessage(int count, MobileCard card) throws Exception;
}
