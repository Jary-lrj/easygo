package cn.edu.tongji.easygo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin
@Api(value="举报",tags = "举报",description = "举报")
public class ReportController {



}
