package com.cluster.wms.api.vo;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-26 10:21:16
 * @version 1.0.0
 */
public class OrderMqApiVo {

    private static final long serialVersionUID = 1L;

	private String id;
    
    /**
     * 用户ID.
     */
    private String userId;

    /**
     * 商品编码.
     */
    private String comCode;

    /**
     * sku商品编码.
     */
    private String skuCode;

    /**
     * sku商品条码.
     */
    private String barcode;

    /**
     * 商品标题.
     */
    private String title;

    /**
     * 商品名称.
     */
    private String name;

    /**
     * 订单数量.
     */
    private Integer qty;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
     * 
     * {@linkplain #userId}
     *
     * @return the value of order.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * {@linkplain #userId}
     * @param userId the value for order.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 
     * {@linkplain #comCode}
     *
     * @return the value of order.com_code
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * {@linkplain #comCode}
     * @param comCode the value for order.com_code
     */
    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    /**
     * 
     * {@linkplain #skuCode}
     *
     * @return the value of order.sku_code
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * {@linkplain #skuCode}
     * @param skuCode the value for order.sku_code
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    /**
     * 
     * {@linkplain #barcode}
     *
     * @return the value of order.barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * {@linkplain #barcode}
     * @param barcode the value for order.barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    /**
     * 
     * {@linkplain #title}
     *
     * @return the value of order.title
     */
    public String getTitle() {
        return title;
    }

    /**
     * {@linkplain #title}
     * @param title the value for order.title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of order.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for order.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * {@linkplain #qty}
     *
     * @return the value of order.qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * {@linkplain #qty}
     * @param qty the value for order.qty
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }
}