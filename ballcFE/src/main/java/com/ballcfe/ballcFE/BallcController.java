package com.ballcfe.ballcFE;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;

/*
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import netscape.javascript.JSObject;
import org.json.JSONString;

*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;



@RestController
@RequestMapping
public class BallcController {

    ArrayList<Users> users = new ArrayList<>();
    //JSONArray usersObj = new JSONArray();

/*
    public BallcController() throws URISyntaxException {
    }


    @CrossOrigin(origins = "http://ea-case-ballc.herokuapp.com")
    @PostMapping("/api")
    public String sendToApi() throws JSONException, URISyntaxException, IOException {

        String firstname = users.get(users.size() - 1).getFirstname();
        JSONObject myjson = new JSONObject();
        myjson.put("name", firstname);
        String request = "http://ea-case-ballc.herokuapp.com/test";
        URL url = new URL(request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        try(DataOutputStream wr = new DataOutputStream((connection.getOutputStream()))){
            wr.writeUTF(myjson.toString());
        }

        return connection.getResponseMessage();
    }
*/

    @CrossOrigin(origins = "*")
    @PostMapping("/users")
    public ModelAndView getUsers(@RequestBody String user, ModelMap model) {

        //JSONObject myjson = new JSONObject(user);
        Users user1 = new Users();
        user1.setFirstname(user);
        String request = "http://ea-case-ballc.herokuapp.com/test";
        RedirectView vf = new RedirectView(request);

        vf.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        ModelAndView md = new ModelAndView(vf);
        md.addObject(user);


        return md;
    }
}
