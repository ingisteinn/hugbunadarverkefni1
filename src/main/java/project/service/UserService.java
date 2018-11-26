package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Progress;
import project.persistence.entities.User;
import project.persistence.repositories.ProgressRepository;
import project.persistence.repositories.UserRepository;
import java.util.*;

@Service
public class UserService {

    UserRepository userRepository;
    ProgressRepository progressRepository;

    @Autowired
    public UserService(UserRepository userRepository, ProgressRepository progressRepository) {
        this.userRepository = userRepository;
        this.progressRepository = progressRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOne(String username) {
        return userRepository.findOne(username);
    }

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> findByUserId(Long userId) {
        return progressRepository.findByUserId(userId);
    }

    //Method to get chart data in the form that canvasjs requires
    public List<List<Map<Object,Object>>> getChartData(Long userId) {
        Map<Object,Object> map = null;
        List<List<Map<Object,Object>>> chartData = new ArrayList<List<Map<Object,Object>>>();
        List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();

        List<Progress> progress = progressRepository.findByUserId(userId);

        for(Progress prog : progress) {
            map = new HashMap<Object,Object>();
            map.put("x", prog.getDate().getTime());
            map.put("y", prog.getWeight());
            dataPoints.add(map);
        }


        chartData.add(dataPoints);

        return chartData;
    }

}
