package eleme.openapi.sdk.api.entity.packs;

import eleme.openapi.sdk.api.enumeration.packs.*;
import eleme.openapi.sdk.api.entity.packs.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ShopContract{

    /**
     * 店铺生效的合同类型名称
     */
    private String contractTypeName;
    public String getContractTypeName() {
        return contractTypeName;
    }
    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }
    
}