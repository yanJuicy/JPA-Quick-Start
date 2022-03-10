package com.rubypaper.biz.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Employee;
import com.rubypaper.biz.domain.EmployeeId;

public class EmployeeServiceClient {

	public static void main(String[] args) {
		// 엔터티 매니저 팩토리 생성
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Chapter02");
		
		// 엔터티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		// 엔터티 트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			/*
			 * // 트랜잭션 시작 tx.begin();
			 * 
			 * EmployeeId empId = new EmployeeId(1L, "guest123");
			 * 
			 * Employee employee = new Employee(); employee.setEmpId(empId);
			 * employee.setName("둘리"); em.persist(employee);
			 * 
			 * // 트랜잭션 종료 tx.commit();
			 */
			
			// 회원 정보 검색
			EmployeeId empId = new EmployeeId(1L, "guest123");
			Employee findEmployee = em.find(Employee.class, empId);
			System.out.println("검색된 직원 정보: " + findEmployee.toString());
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 엔터티 매니저 및 엔터티 매니저 팩토리 종료
			em.close();
			emf.close();
		}
		
	}
}
