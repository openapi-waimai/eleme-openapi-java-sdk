package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OLabel{

    /**
     * 是否招牌菜
     */
    private int isFeatured;
    public int getIsFeatured() {
        return isFeatured;
    }
    public void setIsFeatured(int isFeatured) {
        this.isFeatured = isFeatured;
    }
    
    /**
     * 是否配菜
     */
    private int isGum;
    public int getIsGum() {
        return isGum;
    }
    public void setIsGum(int isGum) {
        this.isGum = isGum;
    }
    
    /**
     * 是否新菜
     */
    private int isNew;
    public int getIsNew() {
        return isNew;
    }
    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }
    
    /**
     * 是否辣
     */
    private int isSpicy;
    public int getIsSpicy() {
        return isSpicy;
    }
    public void setIsSpicy(int isSpicy) {
        this.isSpicy = isSpicy;
    }
    
}