package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Report;
import cn.edu.tongji.easygo.repository.ReportRepository;
import cn.edu.tongji.easygo.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    ReportRepository reportRepository;

    @Override
    public Report addReport(Report report) {
        return (reportRepository.save(report));
    }

    @Override
    public Report showConcreteReport(Long reportId) {
        return reportRepository.findReportByReportId(reportId);
    }
}
