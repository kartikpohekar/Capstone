package com.example.service;
import com.example.entity.Download;
import com.example.repo.DownloadRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DownloadService {

    @Autowired
    private DownloadRepository repo;

    public Download save(Download d){
        return repo.save(d);
    }

    public long count(Long appId){
        return repo.countByAppId(appId);
    }
}
