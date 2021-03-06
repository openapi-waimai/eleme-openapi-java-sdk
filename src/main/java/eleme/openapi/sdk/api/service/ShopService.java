package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.shop.*;
import eleme.openapi.sdk.api.enumeration.shop.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 店铺服务
 */
@Service("eleme.shop")
public class ShopService extends BaseNopService {
    public ShopService(Config config,Token token) {
        super(config, token, ShopService.class);
    }

    /**
     * 查询店铺信息
     *
     * @param shopId 店铺Id
     * @return 店铺
     * @throws ServiceException 服务异常
     */
    public OShop getShop(long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call("eleme.shop.getShop", params);
    }

    /**
     * 更新店铺基本信息
     *
     * @param shopId 店铺Id
     * @param properties 店铺属性
     * @return 店铺
     * @throws ServiceException 服务异常
     */
    public OShop updateShop(long shopId, Map<OShopProperty,Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("properties", properties);
        return call("eleme.shop.updateShop", params);
    }

    /**
     * 批量获取店铺简要
     *
     * @param shopIds 店铺Id的列表
     * @return 店铺简要列表
     * @throws ServiceException 服务异常
     */
    public Map<Long,OSimpleShop> mgetShopStatus(List<Long> shopIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopIds", shopIds);
        return call("eleme.shop.mgetShopStatus", params);
    }

    /**
     * 设置送达时间
     *
     * @param shopId 店铺Id
     * @param deliveryBasicMins 配送基准时间(单位分钟)
     * @param deliveryAdjustMins 配送调整时间(单位分钟)
     * @throws ServiceException 服务异常
     */
    public void setDeliveryTime(long shopId, int deliveryBasicMins, int deliveryAdjustMins) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("deliveryBasicMins", deliveryBasicMins);
        params.put("deliveryAdjustMins", deliveryAdjustMins);
        call("eleme.shop.setDeliveryTime", params);
    }

    /**
     * 设置是否支持在线退单
     *
     * @param shopId 店铺Id
     * @param enable 是否支持
     * @throws ServiceException 服务异常
     */
    public void setOnlineRefund(long shopId, boolean enable) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("enable", enable);
        call("eleme.shop.setOnlineRefund", params);
    }
}
