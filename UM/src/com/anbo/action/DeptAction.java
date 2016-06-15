package com.anbo.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.anbo.dao.DeptDao;
import com.anbo.dao.impl.DeptDaoImpl;
import com.anbo.po.DeptBean;

public class DeptAction {
    private DeptBean dept;
    private DeptDaoImpl deptDaoImpl=new DeptDaoImpl();
    
    
	public String showDeptTree(){
		System.out.println("======================================");
		HttpServletRequest request=ServletActionContext.getRequest();
		String checkedIds=request.getParameter("checkedIds");
		System.out.println("checkedIds="+checkedIds);
		List<Map<String,Object>> list=deptDaoImpl.deptTree();
		StringBuffer sf=new StringBuffer();
		if(list!=null&&list.size()>0){
			sf.append("[");
			sf.append("{ id:'1', pId:0, name:\"组织结构\", open:true,isParent:true,isRoot:1,iconSkin:\"pIcon01\"},");
			for(int i=0;i<list.size();i++){
				String id =  (String) list.get(i).get("ID");
				String fid =  (String) list.get(i).get("FID");
				String levelTemp =list.get(i).get("LEVEL").toString();//用String强制转换类型不行，必须用toString()????/
				
				int level = Integer.parseInt(levelTemp);
				String deptName = (String) list.get(i).get("DEPTNAME");
				if(level<=2){
					
					//String deptType = (String) deptList.get(i).get("DEPTTYPE");
					//if(deptType!=null && ("公司".equals(deptType) || "集团".equals(deptType) || "区域公司".equals(deptType))){
					if(level==1){
						sf.append("{ id:'"+id+"', pId:'1', name:'"+deptName+"',iconSkin:\"pIcon02\",isRoot:1,open:true},");
					}else{
						
						if(checkedIds.contains(id)){
							sf.append("{ id:'"+id+"', pId:'"+fid+"', name:'"+deptName+"',iconSkin:\"pIcon02\",lastOne:1,checked:true},");
						}else{
							sf.append("{ id:'"+id+"', pId:'"+fid+"', name:'"+deptName+"',iconSkin:\"pIcon02\",lastOne:1},");
						}
					}
				}else{
					if(checkedIds.contains(id)){
						sf.append("{ id:'"+id+"', pId:'"+fid+"', name:'"+deptName+"',iconSkin:\"pIcon02\",lastOne:1,checked:true},");
					}else{
						sf.append("{ id:'"+id+"', pId:'"+fid+"', name:'"+deptName+"',iconSkin:\"pIcon02\",lastOne:1},");
					}
					
				}
				}
		}
        String deptStr =  sf.toString();
		
		System.out.println("deptStr=====1=======>>"+deptStr);
		String zNodes= deptStr.substring(0, deptStr.length()-1)+"]";
		
		request.setAttribute("zNodes", zNodes);
		return "showDeptTrees";
	}
	public DeptBean getDept() {
		return dept;
	}
	public void setDept(DeptBean dept) {
		this.dept = dept;
	}
	public DeptDaoImpl getDeptDaoImpl() {
		return deptDaoImpl;
	}
	public void setDeptDaoImpl(DeptDaoImpl deptDaoImpl) {
		this.deptDaoImpl = deptDaoImpl;
	}
	
	
}
