package com.CRUD.demoCRUD.DemoDAO;

import com.CRUD.demoCRUD.DemoEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
