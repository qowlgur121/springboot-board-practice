package study.boardpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import study.boardpractice.domain.User;
import study.boardpractice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void creatUser(User user) {

        userRepository.save(user);
    }
}
