package com.theCode.demo.mycoolapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.theCode.demo.mycoolapp.cao.TeacherRepository;

import com.theCode.demo.mycoolapp.entities.InfoOfTeacher;

@Service
public class TeacherServiceImpl implements TeacherService { /*
	//field
	private TeacherRepository teacherRepository;
	
	//Constructor injection
	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository=teacherRepository;
	}
	
	@Override
	public List<InfoOfTeacher> findAll() {
		
		return teacherRepository.findAll();
	}

	@Override
	public InfoOfTeacher findById(int id) {
		
		Optional<InfoOfTeacher> result=teacherRepository.findById(id);
		
		InfoOfTeacher infoOfTeacher=null;
		if(result.isPresent()) {
			infoOfTeacher=result.get();
		}
		else {
			throw new RuntimeException("did not find employee id!");
		}
		return infoOfTeacher;
	}

	@Override
	public InfoOfTeacher save(InfoOfTeacher infoOfTeacher) {
		
		return teacherRepository.save(infoOfTeacher);
	}
	
	@Override
	public void deleteById(int id) {
		
		teacherRepository.deleteById(id);
		
	}*/
}
