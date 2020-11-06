package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
