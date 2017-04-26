package com.cluster.wms.model;

import com.cluster.framework.model.BaseEntity;

/**
 * 
 * @author  liangdong.yao
 * @date    2017-04-26 11:12:10
 * @version 1.0.0
 */
public class CommoditySku extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
     * 商品数量.
     */
    private Integer qty;

    /**
     * 
     * {@linkplain #comCode}
     *
     * @return the value of commodity_sku.com_code
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * {@linkplain #comCode}
     * @param comCode the value for commodity_sku.com_code
     */
    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    /**
     * 
     * {@linkplain #skuCode}
     *
     * @return the value of commodity_sku.sku_code
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * {@linkplain #skuCode}
     * @param skuCode the value for commodity_sku.sku_code
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    /**
     * 
     * {@linkplain #barcode}
     *
     * @return the value of commodity_sku.barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * {@linkplain #barcode}
     * @param barcode the value for commodity_sku.barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    /**
     * 
     * {@linkplain #title}
     *
     * @return the value of commodity_sku.title
     */
    public String getTitle() {
        return title;
    }

    /**
     * {@linkplain #title}
     * @param title the value for commodity_sku.title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of commodity_sku.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for commodity_sku.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * {@linkplain #qty}
     *
     * @return the value of commodity_sku.qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * {@linkplain #qty}
     * @param qty the value for commodity_sku.qty
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }
}