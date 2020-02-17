package com.example.AuctionHouse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    private final long USER_ROLE_ID = 2;

    public User addUser(UserDTO userDTO) throws Exception{
        UserRole userRole = userRoleRepository.findById(USER_ROLE_ID).
                orElseThrow(()->new Exception("Role not found"));

        User newUser = new User(userDTO.getLogin(), bCryptPasswordEncoder.encode(userDTO.getPassword()), userRole);
//        User newUser = new User(userDTO.getLogin(), userDTO.getPassword(), userRole);

        userRepository.save(newUser);

        return newUser;
    }

    public ResponseEntity<String> delete(Long id) throws Exception {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> mockDelete(Long id, Long userId) {

        User user = userRepository.getOne(userId);

        if(user.getUserRole().equals("ROLE_ADMIN")){
            userRepository.deleteById(id);
            return new ResponseEntity<>("User deleted by admin", HttpStatus.OK);

        }else {
            return new ResponseEntity<>("User deletion denaied", HttpStatus.NOT_ACCEPTABLE);

        }


    }
}
