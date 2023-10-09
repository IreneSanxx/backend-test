package com.vodafone.backendtest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
/**This is the controller that provides APIs for creating, reading, updating
 * and deleting (CRUD) Users and will be exposed to the clients.
 * @RestController annotation is used to define a controller and to indicate that the
 * return value of the methods should be bound to the web response body.
 * @RequestMapping("api/v1/user") indicates that all APIs' in the controller will
 * start with 'api/v1/user'.*/
public class UserController {

    private final UserService userService;

    @Autowired
    /** The annotation @Autowired is used to inject UserService bean to local variable.*/
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    /** @PostMapping annotation is used for handling POST HTTP requests.
     * This method calls 'addNewUser' method created in the service layer.*/
    public void createNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @GetMapping()
    /** @GetMapping annotation is used for handling GET HTTP requests.
     * This method calls 'getUsers' method created in the service layer.*/
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    /** @GetMapping annotation is used for handling GET HTTP requests.
     * This method calls 'getUserById' method created in the service layer,
     * passing the 'id' of the user from URL.*/
    public User getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    /** @PutMapping annotation is used for handling PUT HTTP requests.
     * This method calls 'updateUser' method created in the service layer,
     * passing the 'id' of the user to update from URL and the new information
     * to add from body of the request.*/
    public void updateUser(@PathVariable("id") String id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    /** @DeleteMapping annotation is used for handling DELETE HTTP requests.
     * This method calls 'deleteUser' method created in the service layer,
     * passing the 'id' of the user to delete from URL.*/
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}
