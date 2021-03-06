package org.lby.kq.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by 邹宇泉, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSalary<M extends BaseSalary<M>> extends Model<M> implements IBean {

	public static String TABLENAME="kq_salary";
	public M setId(java.lang.String id) {
		set("id", id);
	return (M)this;
}

	public java.lang.String getId() {
		return get("id");
	}

	public M setYx(java.lang.String yx) {
		set("yx", yx);
	return (M)this;
}

	public java.lang.String getYx() {
		return get("yx");
	}

	public M setTimeDj(java.util.Date timeDj) {
		set("time_dj", timeDj);
	return (M)this;
}

	public java.util.Date getTimeDj() {
		return get("time_dj");
	}

	public M setFy(java.lang.String fy) {
		set("fy", fy);
	return (M)this;
}

	public java.lang.String getFy() {
		return get("fy");
	}

	public M setDeptId(java.lang.String deptId) {
		set("deptId", deptId);
	return (M)this;
}

	public java.lang.String getDeptId() {
		return get("deptId");
	}

	public M setConfid(java.lang.String confid) {
		set("confid", confid);
	return (M)this;
}

	public java.lang.String getConfid() {
		return get("confid");
	}

	public M setType(java.lang.Integer type) {
		set("type", type);
	return (M)this;
}

	public java.lang.Integer getType() {
		return get("type");
	}

}
