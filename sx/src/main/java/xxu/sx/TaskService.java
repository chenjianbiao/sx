package xxu.sx;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xxu.sx.dao.TaskRepository;
import xxu.sx.entity.Task;

@Transactional
@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public List<Task> findAll() {
		List<Task> list = new ArrayList<Task>();
		for (Task task : taskRepository.findAll()) {
			list.add(task);
		}
		return list;
	}
	public Task findById(int id){
		return taskRepository.findOne(id);
	}

	public void save(Task task) {
		taskRepository.save(task);
	}

	public void delete(int id) {
		taskRepository.delete(id);
	}
}
