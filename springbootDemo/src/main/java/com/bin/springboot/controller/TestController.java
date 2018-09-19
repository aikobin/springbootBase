package com.bin.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bin.springboot.component.Log;
import com.bin.springboot.component.Log.ProcedureEnum;
import com.bin.springboot.core.PageInfo;
import com.bin.springboot.core.ResBody;
import com.bin.springboot.dao.entity.User;
import com.bin.springboot.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "success";
	}

	@RequestMapping("/findUser")
	public User findUser(User user) {
		User returnUser = userService.findUser(user.getId());
		return returnUser;
	}

	@RequestMapping("/findAllUser")
	public List<User> findAllUser(User user) {
		return userService.findAllUser(user);
	}

	@RequestMapping("/findUserPage")
	public ResBody findUserPage(User user, @Validated PageInfo pageInfo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return getValidatedInfo(bindingResult);
		}
		return ResBody.buildSuccessResBody(userService.findUserPage(user, pageInfo).getContent());
	}

	@RequestMapping("/removeUser")
	public String removeUser(User user) {
		log.info("zzpps");
		log.error("sssqq");
		userService.removeUser(user.getId());
		return "success";
	}

	@RequestMapping(value = "/testDownload")
	public ResponseEntity<InputStreamResource> testDownload(HttpServletResponse res) throws IOException {
		String filePath = "C://work//output//1.mp4";
		FileSystemResource file = new FileSystemResource(filePath);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentLength(file.contentLength())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(new InputStreamResource(file.getInputStream()));
	}

	@RequestMapping(value = "/logTest")
	@Log(procedure = ProcedureEnum.FENJIAN_TRANS)
	public String logTest(User user) throws Exception {
	//	throw new RuntimeException("ssbin");
		return "success";
	}

}
