package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.message.*;
import eleme.openapi.sdk.api.enumeration.message.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.message")
public class MessageService extends BaseNopService {
    public MessageService(Config config,Token token) {
        super(config, token, MessageService.class);
    }

    /**
     * 获取未到达的推送消息
     *
     * @param appId
     * @return List<String>
     * @throws ServiceException
     */
    public List<String> getNonReachedMessages(int appId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", appId);
        return call(params);
    }

    /**
     * 获取未到达的推送消息实体
     *
     * @param appId
     * @return List<OMessage>
     * @throws ServiceException
     */
    public List<OMessage> getNonReachedOMessages(int appId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", appId);
        return call(params);
    }
}
