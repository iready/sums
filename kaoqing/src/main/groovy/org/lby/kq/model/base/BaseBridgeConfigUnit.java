package org.lby.kq.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 邹宇泉, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBridgeConfigUnit<M extends BaseBridgeConfigUnit<M>> extends Model<M> implements IBean {

	public static String TABLENAME="kq_bridge_config_unit";
	public M setId(java.lang.String id) {
		set("id", id);
	return (M)this;
}

	public java.lang.String getId() {
		return get("id");
	}

	public M setUnit(java.lang.String unit) {
		set("unit", unit);
	return (M)this;
}

	public java.lang.String getUnit() {
		return get("unit");
	}

	public M setUnitType(java.lang.Integer unitType) {
		set("unitType", unitType);
	return (M)this;
}

	public java.lang.Integer getUnitType() {
		return get("unitType");
	}

	public M setConfId(java.lang.String confId) {
		set("confId", confId);
	return (M)this;
}

	public java.lang.String getConfId() {
		return get("confId");
	}

	public M setUnitName(java.lang.String unitName) {
		set("unitName", unitName);
	return (M)this;
}

	public java.lang.String getUnitName() {
		return get("unitName");
	}

}