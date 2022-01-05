package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.dto.ReportVo;
import cn.edu.tongji.easygo.model.Report;
import cn.edu.tongji.easygo.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin
@Api(value="举报",tags = "举报",description = "举报")
public class ReportController {
    @Autowired
    ReportService reportService;

    @ApiOperation("添加举报")
    @PostMapping("")
    public ResponseEntity<Object> addReport(@RequestBody ReportVo reportVo){
        Report report = new Report();
        report.setReportStatus(0);//未审核
        report.setReportThingId(reportVo.getReportThingId());
        report.setReportReason(reportVo.getReportReason());
        report.setReportType(reportVo.getReportType());
        report.setReportUserId(reportVo.getReportUserId());
        reportService.addReport(report);
        return ResponseEntity.status(200).body("添加成功");
    }

    @ApiOperation("查看某举报")
    @GetMapping("{reportId}")
    public ResponseEntity<Object> showReport(@PathVariable Long reportId){
        Report report = reportService.showConcreteReport(reportId);
        return ResponseEntity.status(200).body(report);
    }

    @ApiOperation("查看待处理（status为0）举报列表")
    @GetMapping("handle")
    public ResponseEntity<Object> showHandleList(){
        List<Report> reports = reportService.findReportByStatus(0);
        return ResponseEntity.status(200).body(reports);
    }

    @ApiOperation("查询所有举报信息")
    @GetMapping("")
    public ResponseEntity<Object> showReports(){
        List<Report> reports = reportService.findAllReport();
        return ResponseEntity.status(200).body(reports);
    }

    @ApiOperation("删除举报信息")
    @DeleteMapping("{reportId}")
    public ResponseEntity<Object> deleteReport(@PathVariable Long reportId){
        reportService.deleteReport(reportId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @ApiOperation("修改举报信息")
    @PutMapping("{reportId}")
    public ResponseEntity<Object> updateReport(@PathVariable Long reportId,@RequestBody Report report){
        try {
            reportService.updateReport(reportId,report);
            return ResponseEntity.status(200).body("修改成功");
        } catch (Exception e) {
            return ResponseEntity.status(200).body("修改失败");
        }
    }
}