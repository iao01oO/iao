package com.shopping.bean;

import java.util.Date;

public class EcArticle {
    private Integer id;

    private String typeCode;

    private String title;

    private String supplier;

    private Double price;

    private Double discount;
     
    private String discountPrice;


	private String locality;

    private Date putawayDate;

    private Integer storage;

    private String image;

    private String description;

    private Date createDate;

    private Boolean disabled;
    
    public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality == null ? null : locality.trim();
    }

    public Date getPutawayDate() {
        return putawayDate;
    }

    public void setPutawayDate(Date putawayDate) {
        this.putawayDate = putawayDate;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

	@Override
	public String toString() {
		return "EcArticle [id=" + id + ", typeCode=" + typeCode + ", title=" + title + ", supplier=" + supplier
				+ ", price=" + price + ", discount=" + discount + ", discountPrice=" + discountPrice + ", locality="
				+ locality + ", putawayDate=" + putawayDate + ", storage=" + storage + ", image=" + image
				+ ", description=" + description + ", createDate=" + createDate + ", disabled=" + disabled + "]";
	}
    
}