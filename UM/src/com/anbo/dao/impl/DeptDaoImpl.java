package com.anbo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.anbo.dao.DeptDao;
import com.anbo.dao.StudentDao;
import com.anbo.po.DeptBean;
import com.anbo.util.MybatisFactory;

public class DeptDaoImpl implements DeptDao{

	@Override
	public List<Map<String,Object>> deptTree() {
		System.out.println("jieguo");
		List<Map<String,Object>> list=null;
		SqlSession session=null;
		
		try{
			session=MybatisFactory.getSqlSession();
			list=session.selectList("com.anbo.po.DeptBean.deptTree");
			System.out.println("����====="+list.size());
			/*for(int i=0;i<list.size();i++){
				System.out.println("����====="+list.size());
			}*/
		}finally{
			session.commit();
		
			session.close();
			
		}
		return list;
	}

}
