package org.lby.kq.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 邹宇泉, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseApply<M extends BaseApply<M>> extends Model<M> implements IBean {

	public static String TABLENAME="kq_apply";
	public M setId(java.lang.String id) {
		set("id", id);
	return (M)this;
}

	public java.lang.String getId() {
		return get("id");
	}

	public M setSqr(java.lang.String sqr) {
		set("sqr", sqr);
	return (M)this;
}

	public java.lang.String getSqr() {
		return get("sqr");
	}

	public M setSpr(java.lang.String spr) {
		set("spr", spr);
	return (M)this;
}

	public java.lang.String getSpr() {
		return get("spr");
	}

	public M setState(java.lang.Integer state) {
		set("state", state);
	return (M)this;
}

	public java.lang.Integer getState() {
		return get("state");
	}

	public M setTimeStart(java.util.Date timeStart) {
		set("time_start", timeStart);
	return (M)this;
}

	public java.util.Date getTimeStart() {
		return get("time_start");
	}

	public M setTimeEnd(java.util.Date timeEnd) {
		set("time_end", timeEnd);
	return (M)this;
}

	public java.util.Date getTimeEnd() {
		return get("time_end");
	}

	public M setType(java.lang.Integer type) {
		set("type", type);
	return (M)this;
}

	public java.lang.Integer getType() {
		return get("type");
	}

	public M setReason(java.lang.String reason) {
		set("reason", reason);
	return (M)this;
}

	public java.lang.String getReason() {
		return get("reason");
	}

	public M setTimeSq(java.util.Date timeSq) {
		set("time_sq", timeSq);
	return (M)this;
}

	public java.util.Date getTimeSq() {
		return get("time_sq");
	}

	public M setTimeSp(java.util.Date timeSp) {
		set("time_sp", timeSp);
	return (M)this;
}

	public java.util.Date getTimeSp() {
		return get("time_sp");
	}

	public M setSpReason(java.lang.String spReason) {
		set("sp_reason", spReason);
	return (M)this;
}

	public java.lang.String getSpReason() {
		return get("sp_reason");
	}

}
