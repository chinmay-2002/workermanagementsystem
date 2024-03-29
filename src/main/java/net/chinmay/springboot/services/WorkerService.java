package net.chinmay.springboot.services;
import java.util.List;

import net.chinmay.springboot.model.*;
public interface WorkerService {
	List<Worker> getAllWorkers();
	void saveWorker(Worker w);
	Worker getWorkerById(long id);
	void deleteWorkerById(long id);
}
