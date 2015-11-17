package com.fengyang.version.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyang.base.entity.Page;
import com.fengyang.util.DateCommonUtils;
import com.fengyang.version.dao.UserDao;
import com.fengyang.version.entity.User;

@Service
public class UserService {
	SimpleDateFormat sdf=new SimpleDateFormat(DateCommonUtils.FORMAT_LONG);
	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user){
		user.setFlag("Y");
		String nowTime = sdf.format(new Date());
		user.setCreatDate(nowTime);
		userDao.save(user);
	}
	
	public List<User> getUserList(){
		String hqlStr = "from User where flag = 'Y'";
		List<User> list = userDao.find(hqlStr);
		return list;
	}
	
	public Page getUserList(int pageNo,int pageSize){	
		List<Object> params = new LinkedList<Object>();
		final int startIndex = Page.getStartOfPage(pageNo, pageSize);
		final int endIndex = pageSize;
		
		String hql = hqlCondition();
		String counthql="select count(*)" + hql;
		int totalSize=userDao.getHQLCount(counthql, params);
		List<?> dbList= userDao.getHQLPageList(hql, params, startIndex, endIndex);
		
		return new Page(startIndex, totalSize, pageSize, dbList);
	}
	
	public String  hqlCondition(){
		StringBuffer hql=new StringBuffer();
		hql.append("from User");
		hql.append(" where flag = 'Y' ");
		hql.append(" order by ");
		hql.append(" creatDate desc, ");
		hql.append(" updateDate desc ");
		return hql.toString();
	}
	
	public User findUserById(String id){
		String hqlStr= "from User where id='"+id+"'";
		List<User> list = userDao.find(hqlStr);
		return list.get(0);
	}
	
	public void updateUser(User user){
		String nowTime = sdf.format(new Date());
		user.setUpdateDate(nowTime);
		userDao.update(user);
	}
	
	public void deleteUser(String id){
		String hqlStr="update User set flag='N' where id='"+id+"'";
		userDao.getSession().createQuery(hqlStr).executeUpdate();
	}
}
