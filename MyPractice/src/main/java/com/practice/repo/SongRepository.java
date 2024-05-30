package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

}
