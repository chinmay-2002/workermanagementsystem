package net.chinmay.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chinmay.springboot.model.Worker;
import net.chinmay.springboot.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	
	@Autowired
	private WorkerRepository workerRepository;
	
	
	
	@Override
	public List<Worker> getAllWorkers() {
		// TODO Auto-generated method stub
		return workerRepository.findAll();
	}



	@Override
	public void saveWorker(Worker w) {
		// TODO Auto-generated method stub
		this.workerRepository.save(w);
	}



	@Override
	public Worker getWorkerById(long id) {
		Optional <Worker> optional = workerRepository.findById(id);
		Worker worker = null;
		if(optional.isPresent()) {
			worker = optional.get();
		}
		else{
			throw new RuntimeException("Worker Not Found!! with id " + id);
		}
		return worker;
		
	}



	@Override
	public void deleteWorkerById(long id) {
		this.workerRepository.deleteById(id);
	}
	

}
