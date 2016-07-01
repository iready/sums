package org.lby.kq.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 邹宇泉, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseConfigTime<M extends BaseConfigTime<M>> extends Model<M> implements IBean {

	public static String TABLENAME="kq_config_time";
	public M setId(java.lang.String id) {
		set("id", id);
	return (M)this;
}

	public java.lang.String getId() {
		return get("id");
	}

	public M setFirst(java.lang.String first) {
		set("first", first);
	return (M)this;
}

	public java.lang.String getFirst() {
		return get("first");
	}

	public M setSecond(java.lang.String second) {
		set("second", second);
	return (M)this;
}

	public java.lang.String getSecond() {
		return get("second");
	}

	public M setThird(java.lang.String third) {
		set("third", third);
	return (M)this;
}

	public java.lang.String getThird() {
		return get("third");
	}

	public M setFourth(java.lang.String fourth) {
		set("fourth", fourth);
	return (M)this;
}

	public java.lang.String getFourth() {
		return get("fourth");
	}

	public M setAfterSb(java.lang.Integer afterSb) {
		set("afterSb", afterSb);
	return (M)this;
}

	public java.lang.Integer getAfterSb() {
		return get("afterSb");
	}

	public M setBeforeSb(java.lang.Integer beforeSb) {
		set("beforeSb", beforeSb);
	return (M)this;
}

	public java.lang.Integer getBeforeSb() {
		return get("beforeSb");
	}

	public M setAfterXb(java.lang.Integer afterXb) {
		set("afterXb", afterXb);
	return (M)this;
}

	public java.lang.Integer getAfterXb() {
		return get("afterXb");
	}

	public M setBeforeXb(java.lang.Integer beforeXb) {
		set("beforeXb", beforeXb);
	return (M)this;
}

	public java.lang.Integer getBeforeXb() {
		return get("beforeXb");
	}

	public M setHcXb(java.lang.Integer hcXb) {
		set("hcXb", hcXb);
	return (M)this;
}

	public java.lang.Integer getHcXb() {
		return get("hcXb");
	}

	public M setHcSb(java.lang.Integer hcSb) {
		set("hcSb", hcSb);
	return (M)this;
}

	public java.lang.Integer getHcSb() {
		return get("hcSb");
	}

	public M setProvider(java.lang.String provider) {
		set("provider", provider);
	return (M)this;
}

	public java.lang.String getProvider() {
		return get("provider");
	}

}
