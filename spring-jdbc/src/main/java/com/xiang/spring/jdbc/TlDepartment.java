package com.xiang.spring.jdbc;

public class TlDepartment {

	private Integer departId;
	private String departmentName;
	private String remark;
	
	public TlDepartment() {
		super();
	}
	public TlDepartment(Integer departId, String departmentName, String remark) {
		super();
		this.departId = departId;
		this.departmentName = departmentName;
		this.remark = remark;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "TlDepartment [departId=" + departId + ", departmentName=" + departmentName + ", remark=" + remark + "]";
	}
	
	
	
}
