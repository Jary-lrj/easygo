package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Report;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    Report addReport(Report report);

    Report showConcreteReport(Long reportId);
}
