package org.bjsxt.controller;

@RestController
public class UserController {

    @PostMapper("/save")
    public int save(int sid,String sanme){
        return 1;
    }


}
