package orm_practice.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import orm_practice.practice.model.DemoTest;

public interface DemoRepository extends JpaRepository<DemoTest,Long> {
}
