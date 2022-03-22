package com.rubypaper.biz.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.biz.domain.Employee;

public class EmployeeServiceClient {

	public static void main(String[] args) {

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Chapter03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			// 직원 엔터티 생성 및 초기화
			Employee employee = new Employee();
			employee.setName("둘리");
			
			tx.begin();
			em.persist(employee);
			tx.commit();
			
			for (int i=0; i<30; i++) {
				Thread.sleep(1000);
				System.out.println("다른 사용자가 데이터 수정중... " + i);
			}
			
			em.refresh(employee);
			System.out.println("갱신된 직원 정보 : " + employee.toString());

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
