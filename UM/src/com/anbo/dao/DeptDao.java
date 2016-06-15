package com.anbo.dao;

import java.util.List;
import java.util.Map;

import com.anbo.po.DeptBean;

/**
 * 获得树集合
 * @author wm
 *
 */
public interface DeptDao {
  /**
   * 获得组织好的树的数据
   * @return List<Map<String,Object>>
   * 不直接返回List<DeptBean>却返回List<Map<String,Object>>的原因是为了方便访问数据中不是部门表中(或者是先未定义)的字段，比如level，
   * map<String,Object>中用了object是因为：为了访问数据中的每一个字段，而正好object是所有类的父类，避免了查询出的字段数据存在类型转换的错误
   */
  public List<Map<String,Object>> deptTree();
}
