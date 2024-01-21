package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MusicDTO;
import com.itbank.service.MusicService;

@Controller
@RequestMapping("/music")
public class MusicController {
	
	@Autowired private MusicService musicService;
	
	@GetMapping("/list")
	public ModelAndView music() {
		ModelAndView mav = new ModelAndView();
		List<MusicDTO> list = musicService.selectAll();
		mav.addObject("list", list);
		
		return mav;
	}
	
	
	
}
