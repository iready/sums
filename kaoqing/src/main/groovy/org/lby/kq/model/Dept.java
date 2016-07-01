package org.lby.kq.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;
import org.lby.kq.common.SysVar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 门户部门表
 * 
 * @author 周武 2016-3-16 下午3:42:10
 */
public class Dept extends Model<Dept> implements SysVar {
	private static final long serialVersionUID = -4182350066393091765L;
	public static final String TABLE_NAME = "org_orginfo";
	public static final Dept dao = new Dept();
	public static final DbPro db = Db.use(BASE);
	public static Map<String, String> fyMap = new TreeMap<String, String>();
	public static Map<String, String> rever_Map = new TreeMap<String, String>();
	public static List<Record> fyList = new ArrayList<Record>();

	public List<Record> getAllFy() {
		return db.find("SELECT FJM,MC FROM org_fyxx");
	}

	/**
	 * 关系法院名称
	 * 
	 * @return
	 * @author 周武 2016-3-25 上午10:08:59
	 */
	public List<Record> gxCourtName() {
		String sql = "SELECT t.*,x.DM FROM (SELECT MC,FY FROM org_orginfo WHERE parentOrgId IN (SELECT orgId FROM org_orginfo WHERE FY = '' AND jgbs = 0) OR orgId = 32 ORDER BY parentOrgId,PXH,orgId) t LEFT JOIN org_fyxx x ON t.FY = x.FJM";
		return db.find(sql);
	}

	/**
	 * 查找部门名称
	 * 
	 * @param deptId
	 * @return
	 * @author 周武 2016-3-25 下午7:21:44
	 */
	public String queryDeptName(Integer deptId) {
		String sql = "SELECT FIND_DEPTS_By_DeptId(orgId,'>') deptName FROM org_orginfo where orgId = ?";
		return db.queryStr(sql, deptId);
	}

	public String queryFyName(String fy) {
		String sql = "SELECT MC FROM " + TABLE_NAME + " WHERE FY = ? AND JGBS = 0 AND FY IS NOT NULL AND FY <> ''";
		return db.queryStr(sql, fy);
	}

	/**
	 * 查找法院代码
	 * 
	 * @param fy
	 * @return
	 * @author 周武 2016-4-18 上午8:20:47
	 */
	public Integer queryDm(String fy) {
		String sql = "select dm from org_fyxx where fjm = ?";
		return db.queryInt(sql, fy);
	}

	/**
	 * 通过分级码查找法院
	 * 
	 * @param fy
	 * @return
	 * @author 周武 2016-5-30 上午9:34:11
	 */
	public Dept queryFyByFjm(String fy) {
		String sql = "select * from " + TABLE_NAME + " where fy = ? and jgbs = 0";
		return findFirst(sql, fy);
	}

	/**
	 * 第一级部门（全部）
	 * 
	 * @return
	 * @author 周武 2016-5-31 上午10:42:43
	 */
	public List<Dept> firstDept() {
		String sql = "SELECT * from " + TABLE_NAME + " where jgbs = 0 and parentOrgId = 0 ORDER BY PXH";
		return find(sql);
	}

	/**
	 * 通过父ID查找部门
	 * 
	 * @param parentId
	 * @return
	 * @author 周武 2016-5-31 上午11:15:42
	 */
	public List<Dept> queryByParent(Integer parentId) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE parentOrgId = ? ORDER BY PXH";
		return find(sql, parentId);
	}

	/**
	 * 查找
	 * 
	 * @param fy
	 * @return
	 * @author 周武 2016-5-31 上午11:18:42
	 */
	public Dept queryParent(String fy) {
		String sql = "select * from " + TABLE_NAME + " where jgbs = 0 and fy = ?";
		return findFirst(sql, fy);
	}

	/**
	 * 查找分级码
	 * 
	 * @param deptId
	 * @return
	 * @author 周武 2016-5-31 下午3:06:52
	 */
	public String queryFyByParent(Integer deptId) {
		String sql = "select FY from " + TABLE_NAME + " where parentOrgId = ? and JGBS = 0";
		return db.queryStr(sql, deptId);
	}

	/**
	 * 查询根据法院分级吗查询部门的名称，使用函数
	 * 
	 * @return
	 */
	public List<Record> getDeptName(String fjm) {
		return db.find("");
	}

	/**
	 * 根据法院的分级码和部门名字查出该法院的部门
	 * 
	 * @return
	 */
	public Dept get_fjm_by_fjm_and_fy(String fjm, String fy) {
		return dao.findFirst("select * from " + TABLE_NAME + " where FY=? and mc=?", fjm, fy);
	}
}