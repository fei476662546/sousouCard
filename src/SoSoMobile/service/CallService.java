package SoSoMobile.service;

/**
 * Create by mysteriousTime
 * time on 2019/7/1  22:41
 */


import SoSoMobile.entity.MobileCard;

/**
 * 通话服务接口
 */
public interface CallService {
    //打电话
    public int call(int minCount, MobileCard card) throws Exception;
}
