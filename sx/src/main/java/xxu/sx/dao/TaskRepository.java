package xxu.sx.dao;

import org.springframework.data.repository.CrudRepository;

import xxu.sx.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
