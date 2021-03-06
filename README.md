# JAVA SDK 接入指南 & CHANGELOG

饿了么2.0接口开发Java版SDK，当前版本为开发者维护版本。

饿了么开放平台：https://open.shop.ele.me  
饿了么官方SDK Git: https://git.coding.net/napos_openapi/eleme-openapi-java-sdk.git 

## API接入指南
  1. JAVA version >= 1.6
  2. 创建Config配置类，填入key，secret和isSandbox 参数
  3. 使用sdk提供的接口进行开发调试
  4. 上线前将Config中isSandbox值设为false以及填入正式环境的key和secret

## Maven 引入SDK
```xml
  <dependency>
      <groupId>me.ele.openapi</groupId>
      <artifactId>eleme-openapi-sdk</artifactId>
      <version>1.6.18</version>
  </dependency>
```
## 基本用法
```java
  import eleme.openapi.sdk.config.Config;
  import eleme.openapi.sdk.api.service.ShopService;

  // 变量为true: 沙箱环境 false: 生产环境
  boolean isSandbox = true;
  // 当前环境key
  String appKey = "请填写您的key";
  
  // 当前环境secret
  String appSecret = "请填写您的secret";
  
  // 实例化一个配置类
  Config config = new Config(isSandbox, appKey, appSecret);

  // 使用config和token对象，实例化一个服务对象
  ShopService shopService = new ShopService(config,token);

  // 调用服务方法，获取资源
  OShop shop = shopService.getShop(12345L);

```

## 获取Token
- 企业应用与个人应用的token获取方法略有不同。

- 实际使用过程中，在token获取成功后，该token可以使用较长一段时间，需要缓存起来，请勿每次请求都重新获取token。

> 企业应用

```java
    import eleme.openapi.sdk.config.Config;
    import eleme.openapi.sdk.oauth.OAuthClient;
    
    // 变量为true: 沙箱环境 false: 生产环境
    boolean isSandbox = true;
    
    // 当前环境key
    String appKey = "请填写您的key";
    
    // 当前环境secret
    String appSecret = "请填写您的secret";
    
    // 实例化一个配置类
    Config config = new Config(isSandbox, appKey, appSecret);
    
    // 使用config对象，实例化一个授权类
    OAuthClient client = new OAuthClient(config);
    
    // 根据OAuth2.0中的对应state，scope和callback_url，获取授权URL
    String authUrl = client.getAuthUrl(callback_url, scope, state);

  ```
  商家打开授权URL，同意授权后，跳转到您的回调页面，并返回code

  ```java
  // 通过授权得到的code，以及正确的callback_url，获取token
  Token token = client.getTokenByCode(autoCode, callback_url);
```
> 个人应用

```java
  import eleme.openapi.sdk.config.Config;
  import eleme.openapi.sdk.oauth.OAuthClient;

  // 变量为true: 沙箱环境 false: 生产环境
  boolean isSandbox = true;
  // 当前环境key
  String appKey = "请填写您的key";
  
  // 当前环境secret
  String appSecret = "请填写您的secret";
  
  // 实例化一个配置类
  Config config = new Config(isSandbox, appKey, appSecret);
  
  // 使用config对象，实例化一个授权类
  OAuthClient client = new OAuthClient(config);

  // 使用授权类获取token
  Token token = client.getTokenInClientCredentials();

```

> 刷新token

- 如果token过期，通过refresh_token换取新的token

```java
  //实例化一个配置类
  Config config = new Config(true, "app_key", "app_secret");

  //使用config对象，实例化一个授权类
  OAuthClient client = new OAuthClient(config);

  //根据refreshToken,刷新token
  Token token = client.getTokenByRefreshToken(refreshToken);

```

## Demo使用方法

该demo主要用来演示企业应用的授权流程和展示应用信息
- 在开发者中心创建企业应用，记下沙箱环境店铺的账号和密码，并在沙箱环境中填入回调地址（该地址需要https）

- 启动Demo服务 (eleme/openapi/demo)
  - `HttpServerDemo.java` 中启动 start方法

- 打开SDK生成的授权URL，使用沙箱店铺的账号和密码进行授权，成功后调转回调接口，输出页面，展示店铺信息

- 使用沙箱店铺的账号密码在napos客户端登陆，会发现刚刚授权的应用已安装，并能够打开应用跳转回调页，展示店铺信息

## CHANGELOG:

### [1.11.21]
```
  Release Date : 2017-11-24
```
- [Feature] OSubState 类型中新增 noSubstate
- [FIX] 为向下兼容 Java 版本，将 UGC 服务中类型为 LocalDateTime 的参数变更为 String

### [1.10.21]
```
  Release Date : 2017-11-21
```
- [Feature] 新增众包查询配送费接口
- [Feature] eleme.order.getRefundOrder 返回新增申请退单原因字段 applyRefundReason

### [1.9.21]
```
  Release Date : 2017-11-02
```
- [Fix] 金融服务类型命名错误 OBalanceLogVO -> OBalanceLogV0
- [Feature] 新增了商品服务部分新版接口，老接口将于一个月后下线

### [1.8.21]
```
  Release Date : 2017-10-30
```
- [Fix] 修复 eleme-request-id 和 requestId 不统一的问题

### [1.8.20]
```
  Release Date : 2017-10-29
```
- [Feature] 统一了 eleme-request-id 和 requestId

### [1.8.19]
```
  Release Date : 2017-10-29
```
- [Feature] 增加了 eleme-request-id 用于排障

### [1.7.19]
```
  Release Date : 2017-10-27
```
- [Fix] 修复了 eleme.product.item.getItemsByShopIdAndBarCode 返回值的错误

### [1.7.18]
```
  Release Date : 2017-10-27
```
- [Fix] 增加了零元试吃接口

### [1.6.18]
```
  Release Date : 2017-10-13
```
- [Feature] 增加代金券接口


### [1.6.17]
```
  Release Date : 2017-09-28
```
- [Bugfix] jackson版本降至2.2.0兼容JDK1.6，修正时区默认设置东8区。


### [1.5.17]
```
  Release Date : 2017-09-11
```
- [Bugfix] 忽略对象反序列化不匹配字段解析出错


### [1.5.16]
```
  Release Date : 2017-09-10
```
- [Bugfix]  修复日期反序列化格式问题
- [Feature] 增加订单评论服务


### [1.5.15]
```
  Release Date : 2017-09-01
```
- [Feature] 新增了限时抢购活动服务的接口
- [Feature] 新增了订单评论服务的接口


### [1.5.14]
```
  Release Date : 2017-08-30
```
[bugfix] 替换JSON解析工具包为jackson,解决和平台工具包不一致导致验签失败


### [1.4.14]
```
  Release Date : 2017-08-21
```
[Feature] 在订单服务中增加了三个关于索赔的接口


### [1.4.13]
```
  Release Date : 2017-08-07
```
- [Feature] 在金融服务中增加了五个用来查询账单的特权接口
- [Bugfix] 修复Map<Long,Integer>泛型Long Key转换json出错


### [1.3.13]
```
  Release Date : 2017-07-21
``` 
- [Feature] OOrder新增字段vipDeliveryFeeDiscount(会员减配送费)


### [1.3.12]
```
  Release Date : 2017-07-17
``` 
- [Bugfix] 增加调用API接口网络请求超时异常


### [1.3.11]
```
  Release Date : 2017-07-07
``` 
- [Feature] 新增了两个金融服务的特权接口 eleme.finance.queryBalance 和 eleme.finance.queryBalanceLog
- [Feature] 在商品服务中添加了查看活动商品的接口 eleme.product.item.getItemIdsHasActivityByShopId
- [Feature] 在商品服务中 OItem 实体类中 specs 里新增了一个 activityLevel 的属性
- [Feature] 订单服务中 shopId 由原来的 int 变为 long
- [BugFix] 替换JSON工具包为FASTJSON，修复UserID反序列化丢失精度问题


### [1.2.10]
```
  Release Date : 2017-06-22
``` 
- [Feature] 新增枚举类InvoiceType


### [1.2.10]
```
  Release Date : 2017-06-13
``` 
- [Bugfix] 修复图片上传接口签名


### [1.1.10]
```
  Release Date : 2017-05-27
``` 
- [Feature]在订单服务中增加了若干订单操作的轻量接口 
- [Feature]在店铺服务中增加了 eleme.shop.setOnlineRefund 设置是否支持在线退单


### [1.0.10]
```
  Release Date : 2017-05-23
```
- [Feature] 在商品服务中增加了eleme.user.getPhoneNumber 获取当前授权帐号的手机号,特权接口仅部分帐号可以调用


### [1.0.9]
```
  Release Date : 2017-05-18
```
- [Feature] 在商品服务中增加了eleme.product.item.getItemByShopIdAndExtendCode 根据商品扩展码获取商品和eleme.product.item.getItemsByShopIdAndBarCode 根据商品条形码获取商品这两个新接口
- [Feature] 在订单服务中增加了 eleme.order.getUnreplyReminders 获取店铺未回复的催单；eleme.order.getUnprocessOrders 查询店铺未处理订单；eleme.order.getCancelOrders 查询店铺未处理的取消单；eleme.order.getRefundOrders 查询店铺未处理的退单；eleme.order.getAllOrders 查询全部订单这五个新接口


### [1.0.8]
```
  Release Date : 2017-05-15
```
- [Feature] 在商品服务中增加了 eleme.product.item.batchUpdatePrices 批量修改商品价格的接口
- [Feature] 在订单服务中增加了 eleme.order.cancelDelivery 取消呼叫配送和 eleme.order.callDelivery 呼叫配送这两个接口
- [Feature] 在订单服务中修改了 `OOrder` 类的定义，增加了一个`List<OActivity>`的属性。
- [Feature] 在商品服务中增加了 eleme.product.category.getShopCategoriesWithChildren 查询店铺商品分类，包含二级分类；eleme.product.category.getCategoryWithChildren 查询商品分类详情，包含二级分类；eleme.product.category.createCategoryWithChildren 添加商品分类，支持二级分类；eleme.product.category.updateCategoryWithChildren 更新商品分类，包含二级分类；eleme.product.category.setCategoryPositionsWithChildren 设置二级分类排序这五个接口。


### [v1.0.7]
```
  Release Date : 2017-05-08
```
- [Feature] 增加签约服务; 
- [Feature] 订单服务中新增了 
   - eleme.order.replyReminder 
   - eleme.order.getCommodities 
   - eleme.order.mgetCommodities 
   - eleme.order.getRefundOrder 
   - eleme.order.mgetRefundOrders 
- [Feature] 增加接口查询商品后台分类 
   - eleme.product.category.getBackCategory

### [v1.0.6]
```
  Release Date : 2017-05-03
```
- [Bugfix] 修复消息推送验签失败


### [v1.0.5]
```
  Release Date : 2017-04-21
```
- [Feature] ShopService新增setDeliveryTime(设置送达时间)接口

### [v1.0.4]
```
  Release Date : 2017-04-21
```
- [Feature] 新增UGC(订单评论服务)接口
- [bugfix] 修复接口签名


### [v1.0.3]
```
  Release Date : 2017-04-19
``` 
- [Feature] 订单服务(OrderService)中新增"订单确认送达接口(receivedOrder)"
- [Bugfix] 修复SDK中使用JAVA 8提供的java.time.LocalDateTime 改为java.util.Date


### [v1.0.1]
```
  Release Date : 2017-04-10
```
- [Feature] SDK完整实现
