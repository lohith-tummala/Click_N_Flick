package com.clicknflick.Controller;


import com.clicknflick.Model.User;
import com.clicknflick.Repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/signup")
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String createUser(@RequestBody User user){

        System.out.println(user.getMobile()+" "+user.getPassword()+" "+user.getId()+" "+user.getEmail());
        System.out.println((userRepository.findByMobile(user.getMobile())));
        System.out.println(user.getMobile()+" "+user.getPassword()+" "+user.getId()+" "+user.getEmail());

        userRepository.save(user);
        return "success";
    }


    @GetMapping(path = "/{id}")
    public JSONObject getUser(@PathVariable("id") String id) throws JSONException {
        userRepository.findByEmail(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result","success");

        return jsonObject;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) throws JSONException {
        String result = "fail";

        String mobile = user.getMobile();
        String password = user.getPassword();

        User l_user = null;

        try {
            l_user = userRepository.findByMobile(user.getMobile());
        }
        catch (NullPointerException npe){
            result = "User Not Found, Please check your mobile number";
        }
        //System.out.println(user.getMobile()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getId());
        //System.out.println(user.getMobile()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getId());
        //System.out.println(l_user.getMobile()+" "+l_user.getPassword()+" "+l_user.getEmail()+" "+l_user.getId());

        if(mobile.equals(l_user.getMobile()) && password.equals(l_user.getPassword())){
            result = "successful";
        }
        else{
            if(mobile.equals(l_user.getMobile()) && !password.equals(l_user.getPassword())){
                result = "Wrong password";
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);

        System.out.println(result);
        return jsonObject.toString();
    }


    @GetMapping(path = "/all")
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping(value = "/login/{mobile}")
    public User getUserByMobile(@PathVariable("mobile") String mobile){

        System.out.println(mobile);
        User user = userRepository.findByMobile(mobile);
        return user;
    }

}
