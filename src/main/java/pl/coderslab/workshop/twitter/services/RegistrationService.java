package pl.coderslab.workshop.twitter.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.twitter.dto.RegistrationFormDTO;
import pl.coderslab.workshop.twitter.model.User;
import pl.coderslab.workshop.twitter.repositories.UserRepository;

@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailAvailable(String email) {
        long count = userRepository.countByEmail(email);
        if (count > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void registerUser(RegistrationFormDTO data) {
        User user = new User();
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        userRepository.save(user);
    }
}
