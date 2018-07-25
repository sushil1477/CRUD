package com.scp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.EmptyFileException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.constants.AppLevelConstants.EmpFields;
import com.scp.entity.Employee;
import com.scp.pojo.EmpPojo;
import com.scp.service.EmpService;
import com.scp.util.HibernateUtil;

	public class EmpServiceImpl implements EmpService {
	
	static SessionFactory sessionfactory=null;
	static{
			sessionfactory=HibernateUtil.getSessionFactory();
	      }
	
	public boolean addEmp(EmpPojo emp) {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		int id=(Integer) session.save(mapPojoToEntity(emp));
		HibernateUtil.flushNcommit(session, transaction);
		return id!=0;
		}
		catch(Exception e){
			transaction.rollback();
		}
		finally{
		HibernateUtil.closeSession(session);
		}
		return false;
	}

	public boolean deleteEmp(int empId) {
			Session session=null;
			Transaction transaction=null;
			try{
				session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Employee dbEntity=session.get(Employee.class,10);
			if(dbEntity==null)
				return false;
			session.delete(dbEntity);
			HibernateUtil.flushNcommit(session, transaction);
			return true;
			}
			catch(Exception e){
				transaction.rollback();}
			finally{
				HibernateUtil.closeSession(session);
			}
		return false;
	}

	public EmpPojo getEmp(int empId) {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
						Employee dbEntity=session.get(Employee.class, empId);
				return mapEntityToPojo(dbEntity);						
		}
		catch (Exception e) {
			transaction.rollback();
		}
				
		finally {
			HibernateUtil.closeSession(session);
		}
		
		return null;
	}

	public boolean updateEmp(EmpPojo emp) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		Employee Entity=(Employee) session.merge(mapPojoToEntity(emp));
		if(Entity==null)
			return false;
		session.delete(Entity);
		HibernateUtil.flushNcommit(session, transaction);
		return true;
		}
		catch(Exception e){
			transaction.rollback();}
		finally{
			HibernateUtil.closeSession(session);
		}
		
		return false;
	}

	public List<EmpPojo> getAllEmps() {
		Session session=null;
		Transaction transaction=null;
		try{
	          session=sessionfactory.openSession();
	        transaction=session.beginTransaction();
	      /*  List<Employee> listOfEmployee=session.createQuery("from Employee").list();
	        
	        System.out.println("The contents of list ="+ listOfEmployee);*/
	        Criteria cr=session.createCriteria(Employee.class);
	        List<Employee> list=cr.list();
	        
	        return mapListOfEntityToPojo(list);	        
		}
		catch(Exception e){
			transaction.rollback();
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return null;
	}

	
	public List<EmpPojo> searchEmp(HashMap<EmpFields, String> searchCriteria) {
		Session session=null;
		Transaction transaction=null;
		
			session=sessionfactory.openSession();
			 transaction=session.beginTransaction();
			 Query query=session.createQuery("from Employee where empUserName=:empUserName and empPassword=:empPassword");
			 
			 Set<Entry<EmpFields,String>> entrySet=searchCriteria.entrySet();
		
		for(Entry<EmpFields,String> entry:entrySet){
			
					if(entry.getKey().equals(EmpFields.empId))	{	//we save yes no in DB but in pojo we used True-false
					
					query.setInteger(entry.getKey().toString(),Integer.parseInt(entry.getValue())); //parseint=Strinng to Integer
					}
					if(entry.getKey().equals(EmpFields.isActive)){	//we save yes no in DB but in pojo we used True-false

					query.setString(entry.getKey().toString(),entry.getValue().toString());
					}
					if(entry.getKey().equals(EmpFields.empUserName)){
						query.setString(entry.getKey().toString(),entry.getValue().toString());
					}
					if(entry.getKey().equals(EmpFields.empPassword)){
						query.setString(entry.getKey().toString(), entry.getValue().toString());
					}
		}
		
		
		System.out.println(query.getQueryString());
		System.out.println("list of Query"+query.list());
	
		
		return  query.list() ;
	}
	
	private Employee mapPojoToEntity(EmpPojo empPojo){
		if(empPojo==null)
			return null;
			Employee entity=new Employee();
			entity.setEmpPassword(empPojo.getEmpPassword());
			entity.setEmpId(empPojo.getEmpId());
			entity.setEmpUserName(empPojo.getEmpUserName());
			String yesOrNo = empPojo.isActive() ? "Yes" : "No";
			entity.setActive(yesOrNo);
			
		return entity;
	}
	
	private EmpPojo mapEntityToPojo(Employee emp){
		if(emp==null)
			return null;
		EmpPojo pojo=new EmpPojo();
		pojo.setActive(emp.isActive().equals("Yes"));
		pojo.setEmpId(emp.getEmpId());
		pojo.setEmpPassword(emp.getEmpPassword());
		pojo.setEmpUserName(emp.getEmpUserName());
		
		return pojo;
		
	}

	private List<EmpPojo> mapListOfEntityToPojo(List<Employee> listOfEmployee){
		
		List<EmpPojo> listOfPojos=new ArrayList<EmpPojo>();
		
		if(listOfEmployee==null||listOfEmployee.isEmpty()){
			return null;
		}else{
			//listOfPojos=new ArrayList<EmpPojo>();
			for (Employee entity : listOfEmployee) {
				listOfPojos.add(mapEntityToPojo(entity));
			}
		return listOfPojos;
		}
	}
}
