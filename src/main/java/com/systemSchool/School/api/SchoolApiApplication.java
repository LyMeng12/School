package com.systemSchool.School.api;

import com.systemSchool.School.api.Repository.Repository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.systemSchool.School.api.Entity.student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootApplication
public class SchoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApiApplication.class, args);
	}
	@Autowired
	private Repository repository;

	@PostConstruct
	public void init() {
		student stu = new student();
		stu.setName("John Doe");
		repository.save(stu);

		student stu2 = new student();
		stu2.setName("JKJS");
		repository.save(stu2);
//		<S extends T> S save(S entity);

//		Optional<T> findById(ID primaryKey);
//		Optional<student> stu3 = repository.findById(2L);
//		if (stu3.isPresent()) {
//			System.out.println(stu3.get().getName());
//		}

//		Iterable//list//set//<T> findAll();
//		List<student> list= (List<student>) repository.findAll();
//		for(student jis :list){
//			System.out.println("ID: "+jis.getId());
//			System.out.println("Name:"+jis.getName());
//		}

//		long count();
//		Long total = repository.count();
//		System.out.println(total);

//		void delete(T entity);
//		repository.delete(stu2);

//		boolean existsById(ID primaryKey);
//		boolean exists = repository.existsById(5L);
//		System.out.println(exists);





	}
}
