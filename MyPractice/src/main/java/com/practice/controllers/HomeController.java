package com.practice.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.practice.entities.Song;
import com.practice.repo.SongRepository;

@Controller
public class HomeController {
	
	@Autowired
	private SongRepository songRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Song> songs=this.songRepository.findAll();
		model.addAttribute("songs",songs);
		System.out.println(songs);
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "add_song";
	}
	
	
	@PostMapping("/register")
	public String registerdone(@ModelAttribute Song song,@RequestParam MultipartFile audio) {
		System.out.println(song);
		System.out.println(audio.getOriginalFilename());
		song.setFilename(audio.getOriginalFilename());
		File saveFile;
		try {
			saveFile = new ClassPathResource("static/songs").getFile();
			java.nio.file.Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+ audio.getOriginalFilename());
	    	Files.copy(audio.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
	    	System.out.println("Image is Uploaded");
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		
		this.songRepository.save(song);
		return "success";
	}

}
