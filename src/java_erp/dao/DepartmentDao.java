package java_erp.dao;

import java.util.ArrayList;

import java_erp.dto.Department;
import java_erp.dto.Title;

public interface DepartmentDao {
	ArrayList<Department> selectDepartmentByAll();
	
	Title selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	int updateDepartment(Department department);
	int deleteDepartment(Department department);
}