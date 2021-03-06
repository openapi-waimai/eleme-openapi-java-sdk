package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CategoryWithChildrenIds{

    /**
     * 一级分类ID
     */
    private long parentId;
    public long getParentId() {
        return parentId;
    }
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
    
    /**
     * 二级分类ID列表
     */
    private List<Long> childrenIds;
    public List<Long> getChildrenIds() {
        return childrenIds;
    }
    public void setChildrenIds(List<Long> childrenIds) {
        this.childrenIds = childrenIds;
    }
    
}