package com.example.inuphonebook.service.departmentCrawling;

import com.example.inuphonebook.repository.EmployeeRepository;
import com.example.inuphonebook.service.ImageCrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@Transactional
@Service
public class ArtSportDepartmentService implements ImageCrawlingService {

    @Value("${location.url}")
    private String url;
    @Value("${location.url2}")
    private String url2;
    @Value("${location.url_design}")
    private String url_design;
    @Value("${location.url_sports}")
    private String url_sports;

    @Override
    public void getCrawling(String departmentType, EmployeeRepository employeeRepository) throws IOException {
        ImageCrawlingService.super.getCrawling(departmentType, employeeRepository);
    }

    @Override
    public void getCrawling_design(String departmentType, EmployeeRepository employeeRepository) throws IOException {
        ImageCrawlingService.super.getCrawling_design(departmentType, employeeRepository);
    }

    @Override
    public void getCrawling_sports(String departmentType, EmployeeRepository employeeRepository) throws IOException {
        ImageCrawlingService.super.getCrawling_sports(departmentType, employeeRepository);
    }

    @Override
    public String checkDepartmentType(String departmentType) {
        String siteId;
        String URI = null;
        if (departmentType == "finearts") {
            siteId = departmentType;
            URI = url + departmentType + url2 + "=1795617&siteId=" + siteId;
        } else if (departmentType == "design") {
            URI = url + departmentType + url_design;
        } else if (departmentType == "uipa10") {
            siteId = departmentType;
            URI = url + departmentType + url2 + "=133120&siteId=" + siteId;
        } else if (departmentType == "sports") {
            URI = "http://" + departmentType + url_sports;
        } else if (departmentType == "hlkn") {
            siteId = "uiex";
            URI = url + departmentType + url2 + "=1795602&siteId=" + siteId;
        }

        return URI;
    }
}
