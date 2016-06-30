package org.lby.kq.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 邹宇泉, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseConfig<M extends BaseConfig<M>> extends Model<M> implements IBean {

	public static String TABLENAME="kq_config";
	public M setId(java.lang.String id) {
		set("id", id);
	return (M)this;
}

	public java.lang.String getId() {
		return get("id");
	}

	public M setTimeDK(java.lang.String timeDK) {
		set("timeDK", timeDK);
	return (M)this;
}

	public java.lang.String getTimeDK() {
		return get("timeDK");
	}

	public M setTimeSXB(java.lang.String timeSXB) {
		set("timeSXB", timeSXB);
	return (M)this;
}

	public java.lang.String getTimeSXB() {
		return get("timeSXB");
	}

	public M setTimeCD(java.lang.String timeCD) {
		set("timeCD", timeCD);
	return (M)this;
}

	public java.lang.String getTimeCD() {
		return get("timeCD");
	}

}
