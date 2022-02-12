package com.tuts.controller;

import java.util.*;

import com.tuts.model.student;
import com.tuts.repository.Repos;
import com.tuts.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("Configure The Swagger")
@AllArgsConstructor
public class Controller {
	private final Service Service;
	Repos repo;

	// Save operation
	@PostMapping("/")
	@ApiOperation(value="create slider")
	public String saveDepartment(@RequestBody student student) {
		//sliderService.put(slider.getId(), slider);
		//return slider;
		Service.saveSlider(student);
		return "Created";
	}

	// Read operation
	@GetMapping("/")
	@ApiOperation(value="return all sliders")
	public List<student> fetchDepartmentList() {
		//return new ArrayList<slider>(sliderService.values());
		return Service.fetchSlider();
	}

	@GetMapping("/{id}")
	@ApiOperation(value="return slider by id")
	public Optional<student> fetchSliderById(@PathVariable String id) {
		//return sliderService.get(id);
		return Service.fetchSliderById(id);
	}

	@GetMapping("/get")
	public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
			@RequestParam(required = false) String email,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {

		try {
			List<student> tutorials = new ArrayList<>();
			Pageable paging = PageRequest.of(page, size);

			Page<student> pageTuts;
			if (email == null)
				pageTuts = repo.findAll(paging);
			else
				pageTuts = repo.findByTitleContainingIgnoreCase(email, paging);

			tutorials = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("result", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update operation
	@PutMapping("/{id}")
	@ApiOperation(value="update slider by id")
	public String updateSlider(@RequestBody student student,
							   @PathVariable("id") String id) {
		//sliderService.replace(id, slider);
		Service.updateSlider(student, id);
		return "Updated Successfully";
	}

	// Delete operation
	@DeleteMapping("/{id}")
	@ApiOperation(value="delete slider by id")
	public void deleteSliderById(@PathVariable("id") String id) {
		//sliderService.clear();
		Service.deleteSliderById(id);
	}
}
