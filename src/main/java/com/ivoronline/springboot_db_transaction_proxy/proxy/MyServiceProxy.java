package com.ivoronline.springboot_db_transaction_proxy.proxy;

import com.ivoronline.springboot_db_transaction_proxy.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MyServiceProxy {

  //PROPERTIES
  @Autowired private MyService  myService;
  @Autowired private Connection connection;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  public void insert() throws SQLException {

    //TRANSACTION
    try {

      //START TRANSACTION
      connection.setAutoCommit(false);

      //CALL SERVICE
      myService.insert();

      //COMMIT TRANSACTION
      connection.commit();

    }
    catch (Exception e) {
      //ROLLBACK TRANSACTION
      connection.rollback();
    }
    finally {
      connection.close();
    }

  }

}
