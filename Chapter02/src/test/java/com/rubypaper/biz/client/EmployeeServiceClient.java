package com.rubypaper.biz.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Employee;

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
			// 직원 엔터티 생성
			Employee employee = new Employee();
			employee.setName("둘리");
			employee.setMailId("gurum");
			employee.setStartDate(new Date());
			employee.setTitle("과장");
			employee.setDeptName("총무부");
			employee.setSalary(2500.00);
			employee.setCommissionPct(12.50);
			
			// 트랜잭션 시작
			tx.begin();
			System.out.println("등록 전 id : " + employee.getId());
			
			// 직원 등록 처리
			em.persist(employee);
			for (int i=0 ;i <30; i++) {
				Thread.sleep(100);
				System.out.println("zzz...");
			}
			
			System.out.println("등록 후 id : " + employee.getId());
			// 트랜잭션 종료
			tx.commit();
			
			Employee findEmployee = em.find(Employee.class, 1L);
			System.out.println("검색한 회원 정보");
			System.out.println(findEmployee.toString());
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
