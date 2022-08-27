package com.example.demo.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo") 
public class dataController {
  @Autowired
  private repo userRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser (@RequestParam long id
	  ,@RequestParam String roadName
      , @RequestParam String pickuppointName, @RequestParam int studentCount
      , @RequestParam long longitude, @RequestParam long latitude) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    user n = new user();
//    n.setName(name);
//    n.setEmail(email);
    n.setId(id);
    n.setRoadName(roadName);
    n.setPickupPointName(pickuppointName);
    n.setStudentCount(studentCount);
    n.setLongitude(longitude);
    n.setLatitude(latitude);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<user> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}