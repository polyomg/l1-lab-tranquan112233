package com.poly.lab5.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        try {
            return Integer.parseInt(getString(name, String.valueOf(defaultValue)));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        try {
            return Double.parseDouble(getString(name, String.valueOf(defaultValue)));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        return Boolean.parseBoolean(getString(name, String.valueOf(defaultValue)));
    }

    public Date getDate(String name, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(getString(name, ""));
        } catch (Exception e) {
            throw new RuntimeException("Sai định dạng ngày");
        }
    }

    public File save(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            try {
                File dest = new File(path, file.getOriginalFilename());
                file.transferTo(dest);
                return dest;
            } catch (Exception e) {
                throw new RuntimeException("Lỗi lưu file");
            }
        }
        return null;
    }

}
