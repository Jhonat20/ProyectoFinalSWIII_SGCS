package com.SGCS.repositories;

import com.SGCS.Domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository <Doctor, Long> {

}
