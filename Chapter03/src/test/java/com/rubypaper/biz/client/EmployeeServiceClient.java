package com.rubypaper.biz.client;

import java.util.List;

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
			tx.begin();
			for (int i=2; i<=10; i++) {
				Employee employee = new Employee();
				employee.setName("직원 " + i);
				em.persist(employee);
			}
			
			tx.commit();
			
			// 직원 조회
			String jpql = "SELECT e FROM Employee e ORDER BY e.id DESC";
			List<Employee> employeeList =
					em.createQuery(jpql, Employee.class).getResultList();
			for (Employee employee : employeeList) {
				System.out.println("---> " + employee.toString());
			}
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
