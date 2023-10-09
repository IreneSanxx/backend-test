package com.vodafone.backendtest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**This is the service layer, which is used to perform business logic. We will connect
 * with the repository here for CRUD operations.*/
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    /**The annotation @Autowired is used to inject UserRepository bean to local variable.*/
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** In this method, we call 'insert' method of UserRepository to create
     * new User in the collection.*/
    public void addNewUser(User user) {
        userRepository.insert(user);
    }

    /** In this method, we call 'findAll' method of UserRepository to retrieve
     * all elements saved in the collection.*/
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /** In this method, we call 'findById' method of UserRepository to retrieve
     * the user which id contains input id.
     * If this user exists, we return this element by 'get' method.
     * If not, we throw a Exception.*/
    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalStateException("Not found element with id: " + id);
        }
    }

    /** In this method, we call 'findById' method of UserRepository to retrieve
     * the user which id contains input id.
     * If this user exists, we retrieve this element by 'get' method, set its new
     * fields and update the element in collection with 'save' method of UserRepository.
     * If not, we throw a Exception.*/
    public void updateUser(String id, User user){
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()){
            User _user = userData.get();
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setEmail(user.getEmail());
            _user.setAge(user.getAge());
            userRepository.save(_user);
        }
        else {
            throw new IllegalStateException("Not found any user with id : " + id);
        }
    }

    /** In this method, we call 'findById' method of UserRepository to retrieve
     * the user which id contains input id.
     * If this user exists, we use 'delete' method of UserRepository to delete this user.
     * If not, we throw a Exception.*/
    public void deleteUser(String id) {
        Optional <User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            userRepository.delete(userData.get());
        } else {
            throw new IllegalStateException("Not found any user with id : " + id);
        }
    }
}
