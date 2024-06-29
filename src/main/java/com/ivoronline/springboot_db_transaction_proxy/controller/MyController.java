package com.ivoronline.springboot_db_transaction_proxy.controller;

import com.ivoronline.springboot_db_transaction_proxy.proxy.MyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyServiceProxy myServiceProxy;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public String insert() throws SQLException {
    myServiceProxy.insert();
    return "Records Inserted";
  }

}
