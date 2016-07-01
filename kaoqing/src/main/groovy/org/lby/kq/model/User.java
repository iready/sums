package org.lby.kq.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import org.lby.kq.common.SysVar;

/**
 * 门户用户表
 * 
 * @author 周武 2016-3-16 下午3:42:19
 */
public class User extends Model<User> implements SysVar {
	private static final long serialVersionUID = 2648221167762351569L;
	public static final String TABLE_NAME = "org_user";
	public static final User dao = new User();

	/**
	 * 通过邮箱查询
	 * 
	 * @author 周武 2016-3-16 下午7:01:08
	 * @param email
	 * @return
	 */
	public User queryByEmail(String email) {
		String sql = "select * from " + TABLE_NAME + " where yx = 1 and youxiang = ?";
		return findFirst(sql, email);
	}

	/**
	 * 查找部门ID
	 * 
	 * @author 周武 2016-4-15 上午10:22:56
	 * @param userId
	 * @return
	 */
	public Integer deptId(Integer userId) {
		String sql = "select orgId from " + TABLE_NAME + " where userId = ?";
		return Db.use(BASE).queryInt(sql, userId);
	}
}
