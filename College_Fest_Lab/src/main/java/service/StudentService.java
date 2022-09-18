package service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import entity.Student;

@Service
public class StudentService {

	private SessionFactory factory;
	private Session session;

	public StudentService(SessionFactory factory) {
		this.factory = factory;
		try {
			this.session = factory.getCurrentSession();
		} catch (Exception e) {
			this.session = factory.openSession();
		}

		System.out.println("Session Created");
		System.out.println(this.session);
	}

	@Transactional
	public void saveorUpdate(Student student) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(student);

		tx.commit();
	}

	@Transactional
	public boolean delete(int id) {

		try {
			Transaction tx = session.beginTransaction();

			Student s1 = session.get(Student.class, id);
			session.delete(s1);

			tx.commit();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public Student findStudentById(int id) {
		Transaction tx = session.beginTransaction();

		Student student = session.get(Student.class, id);

		tx.commit();
		return student;
	}

	@Transactional
	public List<Student> findAllStudents() {

		Transaction tx = session.beginTransaction();

		List<Student> students = session.createQuery("from Student").list();

		tx.commit();
		return students;
	}
}
