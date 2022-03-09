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
			// 트랜잭션 시작
			tx.begin();
			
			for (int i=1; i<=100; i++) {
				Employee employee = new Employee();
				employee.setName("직원 - " + i);
				em.persist(employee);
			}
			
			// 트랜잭션 종료
			tx.commit();
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
