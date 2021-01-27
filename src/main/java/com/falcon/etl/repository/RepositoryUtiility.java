package com.falcon.etl.repository;

import com.falcon.etl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class RepositoryUtiility {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void saveToDbList(List<User> dbList) {
        userRepository.saveAll(dbList);
    }

}
